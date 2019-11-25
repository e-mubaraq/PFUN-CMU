import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * This is an helper class for processing ("crawling") the website.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class WebCrawler
{
    private TreeMap<String, HTMLLink> toProcess = new TreeMap<String, HTMLLink>();
    private TreeMap<String, HTMLLink> htmlFileList = new TreeMap<String, HTMLLink>();
    private TreeMap<String, HTMLLink> exampleFileList = new TreeMap<String, HTMLLink>();
    
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
    
    public LinkedList<String> readInURL(URL site) throws IOException
    {
        String str;
        LinkedList<String> lines = new LinkedList<String>();
        BufferedReader webPage = new BufferedReader(new InputStreamReader(site.openStream()));
        str = webPage.readLine();
        while(str != null)
        {
            lines.add(str);
            str = webPage.readLine();
        }
        webPage.close();
        
        URLUtils.printStack(lines);
        return lines;
    }
    
    public LinkedList<String> parse(URL site) throws IOException
    {
        LinkedList<String> href;
        LinkedList<String> list = new LinkedList<String>();
        href = readInURL(site);
        for (String str : href)
        {
            if (str.toLowerCase().contains("a href"))
                list.add(str);   
        }
        
        URLUtils.printStack(list);
        return list;   
    }
    
    public LinkedList<String> processHtml(URL site)
    {
        int idx, idx2;
        String line;
        LinkedList<String> href;
        LinkedList<String> list = new LinkedList<String>();
        
        try
        {
            href = parse(site);
            for (String str: href)
            {
                idx = str.indexOf("<a href");
                idx2 = str.lastIndexOf("a>");
                line = str.substring(idx , idx2 + 2);
                list.add(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        URLUtils.printStack(list);
        return list;
    }
    
    public void addLink(URL site)
    {
        LinkedList<String> href;
        String l, link, label;
        HTMLLink hlink;
        href = processHtml(site);
        
        for (String s : href)
        {
            l = getLink(s);
            label = getLabel(s);
            hlink = new HTMLLink(label, l);
            link = hlink.getFullLink(l);
            hlink = new HTMLLink(label, link);
            
            if (!link.startsWith("public"))
                ;
            else if (isSource(link))
                exampleFileList.put(link, hlink);
            else if (htmlFileList.containsValue(hlink))
                ;
            else if (toProcess.containsValue(hlink))
                ;
            else
                toProcess.put(link, hlink);
        }
        
        URLUtils.printMap(exampleFileList);
        //URLUtils.printMap(htmlFileList);
        //URLUtils.printMap(toProcess);
    }
    public void writeFile(String fname)
    {
        String s = "";
        OutputDataFile dataFile = new OutputDataFile(fname);
        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }
        
        dataFile.println(s);
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
        
        idx = htmlink.indexOf("=");
        idx2 = htmlink.indexOf(">" , idx);
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
        if (link.endsWith(".java") || link.endsWith(".c") || link.endsWith("h") || link.endsWith(".cpp"))
            return true;
        return false;
    }
    

    
    
}
