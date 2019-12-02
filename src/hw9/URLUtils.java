package hw9;
import java.net.URL;
import java.util.*;

/**
 * This class contains helpful static methods for working with URLs
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class URLUtils
{

    public static String getBaseURL(URL url)
    {
        String baseURL;
        int idx = url.getFile().lastIndexOf("/");
        baseURL = url.getProtocol() + "://" + url.getHost() + url.getFile().substring(0, idx + 1);
        
        return baseURL;
    }
    public static String getWebPageTitle(String link)
    {
        int idx, idx2;
        String title = "";
        if(link.contains("<title>"))
        {
            idx = link.indexOf("<title>");
            idx2 = link.indexOf("</title>");
            
            title = link.substring(idx + 7, idx2);
        }
        return title;        
    }
    
    public static void printMap(TreeMap<String, HTMLLink> obj)
    {
        for (String key : obj.keySet())
        {
            System.out.println("link: " + key + "      HTMLLink: " + obj.get(key));
        }
    }

    public static void printList(LinkedList<String> list)
    {
        int i = 0;
        for (Object e : list)
        {
            System.out.println("Entry " + i + ": " + e);
            i++;
        }      
    }
    public static void printTree(TreeSet<String> list)
    {
        int i = 0;
        for (Object e : list)
        {
            System.out.println("Entry " + i + ": " + e);
            i++;
        }      
    }

    public static void printTreeMap(TreeMap<String, LinkedList<HTMLLink>> wordIndex)
    {
        for (String key : wordIndex.keySet())
        {
            System.out.println("word: " + key + "      HTMLLink: " + wordIndex.get(key));
        }
        
    }
    
    public static LinkedList<String> readFile(String filename)
    {
        String input;
        LinkedList<String> excludeWords = new LinkedList<String>();
        InputDataFile dataFile = new InputDataFile(filename);

        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't read " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }

        input = dataFile.readString();
        while (input != null)
        {
            excludeWords.add(input.toUpperCase());
            input = dataFile.readString();
        }

        dataFile.close();
        return excludeWords;
    }
}
