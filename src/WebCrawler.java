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
    private TreeMap<String, HTMLLink> toProcess;

    private TreeMap<String, HTMLLink> htmlFileList;
    private TreeMap<String, HTMLLink> exampleFileList;
    
    public WebCrawler()
    {
        
    }
    public TreeMap<String, HTMLLink> gethtmlFileList()
    {
        return htmlFileList;
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
            {
                list.add(str);
            }      
        }
        for (String h : list)
            System.out.println(h);
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
        for (String s: list)
            System.out.println(s);  
        return list;
    }
    
    public void addLink(HTMLLink hlink)
    {
        String link = hlink.getLink();
        
        if (isSource(link))
            exampleFileList.put(link, hlink);
        else if (htmlFileList.containsValue(hlink))
            ;
        else if (toProcess.containsValue(hlink))
            ;
        else
            toProcess.put(link, hlink);
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
