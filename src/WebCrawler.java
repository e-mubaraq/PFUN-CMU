import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * This is an helper class for processing ("crawling") the website.
 *
 * @author Mubarak Mikail Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class WebCrawler
{
    private TreeMap<String, HTMLLink> toProcess = new TreeMap<String, HTMLLink>();
    private TreeMap<String, HTMLLink> htmlFileList = new TreeMap<String, HTMLLink>();
    private TreeMap<String, HTMLLink> exampleFileList = new TreeMap<String, HTMLLink>();
    private LinkedList<String> errorLinks = new LinkedList<String>();

    public WebCrawler()
    {

    }

    public TreeMap<String, HTMLLink> gethtmlFileList()
    {
        return htmlFileList;
    }

    public TreeMap<String, HTMLLink> getToProcess()
    {
        return toProcess;
    }

    public TreeMap<String, HTMLLink> getExampleFileList()
    {
        return exampleFileList;
    }

    public LinkedList<String> getErrorLinks()
    {
        return errorLinks;
    }
    
    public LinkedList<String> readInURL(URL site)
    {
        String str;
        BufferedReader webPage; 
        LinkedList<String> lines = new LinkedList<String>();
        if(!site.toString().contains("#"))
        {
            try
            {
                webPage = new BufferedReader(new InputStreamReader(site.openStream()));
                str = webPage.readLine();
                while (str != null)
                {
                    lines.add(str);
                    str = webPage.readLine();
                }
                webPage.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                errorLinks.add(e.getMessage() + " " + site);
            }
        }
       return lines;
    }
    
    /**
     * This method returns every line in the readIn html that contain a href  and then filters out tags that are not href
     * @param site to be crawled
     * @return List of lines that contain href and without non href tags
     */
    public LinkedList<String> parseHref(URL site) throws IOException
    {
        int idx, idx2;
        String line;
        LinkedList<String> allLines, listOfHref = new LinkedList<String>();
        LinkedList<String> list = new LinkedList<String>();
        
        allLines = readInURL(site);
        for (String str : allLines)
        {
            if (str.toLowerCase().contains("a href") && str.contains("</a>") && !str.contains("mailto:"))
                listOfHref.add(str);
        }
        for (String str : listOfHref)
        {
            idx = str.toLowerCase().indexOf("<a href");
            idx2 = str.toLowerCase().lastIndexOf("a>");
            line = str.substring(idx, idx2 + 2);
            list.add(line);
        }
        return list;
    }
/**
 * 
 * @return
 * @throws IOException
 */
   public void parseAllHtml(URL site) throws IOException
   {
       HTMLLink hlink;
       String tLink, link, label;
       LinkedList<String> hrefs;
       
       hrefs = parseHref(site);
       for (String s : hrefs)
       {
           tLink = getLink(s);         
           label = getLabel(s);
           hlink = new HTMLLink(label, tLink);
           
           link = hlink.getFullLink(tLink);
           hlink = new HTMLLink(label, link);
           
           if (!link.startsWith(HTMLLink.baseURL) || link.contains("#")) // Links not part of Cathy's website and those on the same page with different IDs
               ;
           else if (isSource(link))     //Links that are source files
               exampleFileList.put(link, hlink);
           else if (htmlFileList.containsKey(hlink.getLink()))      //Links already part of the htmlFilelist
               ;
           else if (toProcess.containsKey(hlink.getLink()))         //Links to be processed
               ;
           else
               toProcess.put(hlink.getLink(), hlink);
       }
        //URLUtils.printList(errorLinks);
    }
    
    public void parseMoreHTML()
    {
        HTMLLink hlink;
        String link;
        
        while (!toProcess.isEmpty())
        {
            link = toProcess.firstKey();
            hlink = toProcess.get(link);
            toProcess.remove(hlink.getLink());
            htmlFileList.put(link, hlink);
            try
            {
                parseAllHtml(new URL (hlink.getLink()));
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
      public void writeFile(String fname) 
      { 
        Set<String> links;
        String flink;
        HTMLLink hlink;
        OutputDataFile dataFile = new OutputDataFile(fname);
        
        links = exampleFileList.keySet();
        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }
        dataFile.println("<b>Example Files</b>");
        for(String s : links)
        {
            hlink = exampleFileList.get(s);
            flink = hlink.formatLink();
            dataFile.println("<br>" + flink + "</br>");    
        }

        dataFile.close();
      }
     

    public String getLabel(String link)
    {
        String label;
        int idx, idx2;

        idx = link.indexOf(">");
        idx2 = link.lastIndexOf("<");
        label = link.substring(idx + 1, idx2).replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "");

        return label;
    }

    public String getLink(String htmlink)
    {
        String link;
        int idx, idx2;

        if (htmlink.contains("=\""))
        {
            idx = htmlink.indexOf("=\"");
            idx2 = htmlink.indexOf("\">", idx);
        }
        else
        {
            idx = htmlink.indexOf("=");
            idx2 = htmlink.indexOf(">", idx);
        }
        link = htmlink.substring(idx + 1, idx2);

        return link;
    }

    public boolean isHTML(String link)
    {
        if (link.endsWith(".html") || link.contains(".html") || link.endsWith("/"))
            return true;
        return false;
    }

    public boolean isSource(String link)
    {
        if (link.endsWith(".java") || link.endsWith(".c") || link.endsWith(".h") || link.endsWith(".cpp"))
            return true;
        return false;
    }

}
