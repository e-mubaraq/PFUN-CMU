import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * This is an helper class for generating the index file(s).
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class IndexGenerator
{

    private String startUrl;
    private URL startUR;
    private TreeMap<String, ArrayList<HTMLLink>> wordIndex = new TreeMap<String, ArrayList<HTMLLink>>();
    
    
    public IndexGenerator()
    {
        
    }
    
    public IndexGenerator(String startUrL)
    {
        this.startUrl = startUrL;
    }
    
    public IndexGenerator(URL startUR)
    {
        this.startUR = startUR;
    }
    
    public String getStartURL()
    {
        return startUrl;
    }
    
    public void setStartURL(String startUrl)
    {
        this.startUrl = startUrl;
    }
    
    public String getBaseURL()
    {
        return URLUtils.getBaseURL(getStartURL());
    }
//    public URL getBaseURL()
//    {
//        return URLUtils.getBaseURL(getStartURL());
//    }
    public String getWebpageTitle()
    {
        String str, temp;
        if(startUrl.endsWith("/"))
            temp = startUrl.substring(0, startUrl.length() - 1);
        else
            temp = startUrl;
        
        str = temp.substring(temp.lastIndexOf("/") + 1, temp.length());
        
        return str;
    }
    
    public String getWordsIndexFile()
    {
        return getWebpageTitle() + "words.html";
    }
    public String getExampleIndexFile()
    {
        return getWebpageTitle() + "examples.html";
    }
    
    public TreeSet<String> parseWords(WebCrawler web) throws IOException
    {
        LinkedList<String> href;
        TreeSet<String> words;
        String[] wordsT;
        TreeMap<String, HTMLLink> pagesToParse;
        String temp, word = "";
        
        pagesToParse = web.gethtmlFileList();
        
        href = web.readInURL(startUR);
        for (String str : href)
        {
            temp = str.replaceAll("[\\p{Punct}0-9]", " ");
            word = word + " " + temp;
        }
        wordsT = word.split("\\p{Space}");
        
        words = new TreeSet<String>(Arrays.asList(wordsT));
        for (String s: words)
            System.out.println(s);
        return words;  
    }

    public LinkedList<String> addWords(WebCrawler web) throws IOException
    {
        int i;
        TreeSet<String> words;
        LinkedList<String> uniqueWords =  new LinkedList<String>();
        words = parseWords(web);
        
        for (String s : words)
        {
            for (i = 0; i < uniqueWords.size(); i++)
            {
                if (!(uniqueWords.get(i)).equals(s))
                    uniqueWords.add(s);
            }
        }
        return uniqueWords;
    }
    
    public void addWordsAndHTML(WebCrawler web) throws IOException
    {
        LinkedList<String> words;
        words = addWords(web);
        HTMLLink htmlink;
        ArrayList<HTMLLink> hlinks = new ArrayList<HTMLLink>();
        
        
        for (String s : words)
        {
            htmlink = web.gethtmlFileList().get(s);
            hlinks.add(htmlink);
            wordIndex.put(s, hlinks);
        }
    }
    
    public String getRootWord(String word)
    {
        String rootWord = "";
        
        return rootWord;
    }
    public String toString()
    {
        return "URL: " + getStartURL()+ " wordsIndexFile: " + getWordsIndexFile() +  " examplesIndexFile: " + getExampleIndexFile();
    }

}
