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
    private List<File> toProcess = new ArrayList<File>();
    private List<File> processedFiles = new ArrayList<File>();
    
    private ArrayList<HTMLLink> htmlFileList = new ArrayList<HTMLLink>();
    private ArrayList<HTMLLink> exampleFileList = new ArrayList<HTMLLink>();
    
    
    public WebCrawler()
    {
        
    }
    public WebCrawler(URL site) throws IOException
    {
        String str;
        BufferedReader webPage = new BufferedReader(new InputStreamReader(site.openStream()));
        str = webPage.readLine();
        while(str != null)
        {
            str = webPage.readLine();
        }
        webPage.close();
        
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
    
    public LinkedList<String> crawlHTML(URL site) throws IOException
    {
        String str;
        LinkedList<String> href = new LinkedList<String>();
        BufferedReader webPage = new BufferedReader(new InputStreamReader(site.openStream()));
        str = webPage.readLine();
        while(str != null)
        {
            if (str.toLowerCase().contains("a href"))
            {
                href.add(str);
            }
            str = webPage.readLine();
        }
        webPage.close();
        for (String h : href)
            System.out.println(h);
        return href;
    }
    
    public LinkedList<String> parse(URL site) throws IOException
    {
        LinkedList<String> href;
        LinkedList<String> list = new LinkedList<String>();
        href = readInURL(site);
        for (String str : href){
            if (str.toLowerCase().contains("a href"))
            {
                list.add(str);
                //list.add(str.replaceAll(" (?<=[^<a href])", ""));
            }      
        }

        return list;   
    }
    
    public LinkedList<String> processFiles(URL site) throws IOException
    {
        LinkedList<String> href;
        LinkedList<String> list = new LinkedList<String>();
        href = parse(site);
        
        for (String str : href){
            if (str.contains(".cpp") || str.contains(".java") || str.contains(".h") || str.contains(".c"))
            {
                list.add(str);
            }
            else if(str.contains(".html"))
            {
                
            }
        }
                
        return list;
    }
    
    
    
}
