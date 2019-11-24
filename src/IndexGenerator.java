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
    private List <String> wordIndex = new LinkedList<String>();
    private List <String> exampleFiles = new LinkedList<String>();
    
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
    public HashSet<String> parseWords(WebCrawler web) throws IOException
    {
        LinkedList<String> href, list;
        HashSet<String> words;
        String[] wordsT;
        
        String temp, word = "";
        href = web.readInURL(startUR);
        for (String str : href)
        {
            temp = str.replaceAll("[\\p{Punct}0-9]", " ");
            word = word + " " + temp;
        }
        wordsT = word.split("\\p{Space}");
        
        words = new HashSet<String>(Arrays.asList(wordsT));
//        for (String s: words)
//            System.out.println(s);
        return words;  
    }
    
    public void addWords(WebCrawler web) throws IOException
    {
        int i;
        HashSet<String> words;
        words = parseWords(web);
        
        wordIndex.addAll(words);
        
        for (String s : words)
        {
            for (i = 0; i < wordIndex.size(); i++)
            {
                if (wordIndex.get(i).equals(s))
                    wordIndex.add(s);
            }
        }
    }
    
    public String toString()
    {
        return "URL: " + getStartURL()+ " wordsIndexFile: " + getWordsIndexFile() +  " examplesIndexFile: " + getExampleIndexFile();
    }

}
