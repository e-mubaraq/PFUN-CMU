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
                e.printStackTrace();
                errorLinks.add(site.toString());
            }
        }
       return lines;
    }
    
    /**
     * This method returns every line in the readIn html that contain a href  and then filters out tags that are not href
     * @param site to be crawled
     * @return List of lines that contain href and without non href tags
     */
    public LinkedList<String> parse(URL site) throws IOException
    {
        int idx, idx2;
        String line;
        LinkedList<String> href, listOfHref = new LinkedList<String>();
        LinkedList<String> list = new LinkedList<String>();
        
        href = readInURL(site);
        for (String str : href)
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
        //URLUtils.printStack(list);
        return list;
    }
/**
 * 
 * @return
 * @throws IOException
 */
   public void parseAllHtml(URL site) throws IOException
   {
       HTMLLink hlink, hKLink;
       String tLink, link, label, klink;
       Set<String> links;
       LinkedList<String> href, href2;
       LinkedList<String> list = new LinkedList<String>();
       
       href = parse(site);
       for (String s : href)
       {
           tLink = getLink(s);         
           label = getLabel(s);
           hlink = new HTMLLink(label, tLink);
           
           link = hlink.getFullLink(tLink);
           hlink = new HTMLLink(label, link);
           
           if (!link.startsWith("http://public.") || link.contains("#")) // Links not part of Cathy's website and those on the same page with different IDs
               ;
           else if (isSource(link))     //Links that are source files
               exampleFileList.put(link, hlink);
           else if (htmlFileList.containsValue(hlink))      //Links already part of the htmlFilelist
               ;
           else if (toProcess.containsValue(hlink))         //Links to be processed
               ;
           else
               toProcess.put(link, hlink);
       }
       
       links = toProcess.keySet();
       for(String key : links)
       {
           hlink = toProcess.get(key);
           link = getLink(hlink.formatLink());
           System.out.println("link to be crawled: " + link);
           href2 = parse(new URL(link));
           
           for(String k : href2)
           {
               klink = hlink.getFullLink(getLink(k)).replace("\"", "");
               //System.out.println("inner Link: " + klink);
               if (isSource(klink))
                   exampleFileList.put(klink, new HTMLLink(getLabel(k), klink));
               else if (klink.contains("https://"))
                   ;
               else
                   list = parse(new URL(klink));
           }
           htmlFileList.put(link, hlink);
           //toProcess.remove(key);
       }
       
       //URLUtils.printMap(exampleFileList);
        URLUtils.printMap(htmlFileList);
        //URLUtils.printMap(toProcess);

    }
    
      public void writeFile(String fname) 
      { 
        Set<String> links;
        links = exampleFileList.keySet();

        String flink;
        HTMLLink hlink;
        OutputDataFile dataFile = new OutputDataFile(fname);
        
        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }
        
        for(String s : links)
        {
            hlink = exampleFileList.get(s);
            flink = hlink.formatLink();
            dataFile.println("<p>" + flink + "<p>");    
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
