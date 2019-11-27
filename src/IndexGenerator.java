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
    private TreeMap<String, LinkedList<HTMLLink>> wordIndex = new TreeMap<String, LinkedList<HTMLLink>>();
    
    
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
        String link, temp, word = "";
        
        pagesToParse = web.gethtmlFileList();
        
        href = web.readInURL(startUR);
        for (String str : href)
        {
            temp = str.replaceAll("[\\p{Punct}0-9]", " ");
            word = word + " " + temp;
        }
//        word = word.replaceAll("^[A-Za-z].$", "");
        wordsT = word.toLowerCase().split("\\p{Space}");
        
        words = new TreeSet<String>(Arrays.asList(wordsT));
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
            uniqueWords.add(s);
//            for (i = 0; i < uniqueWords.size(); i++)
//            {
//                if (!(uniqueWords.get(i)).equals(s))
//                    uniqueWords.add(s);
//            }
        }
        //URLUtils.printStack(uniqueWords);
        return uniqueWords;
    }
    
    public void addWordsAndHTML(WebCrawler web) throws IOException
    {
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<HTMLLink> hlinks = new LinkedList<HTMLLink>();
        HTMLLink htmlink;
        words = addWords(web);
        
        for (String s : words)
        {
            System.out.println("add + " + s);
            //htmlink = web.gethtmlFileList().get(s);
            htmlink = web.getToProcess().get(s);
            System.out.println("hlink =>> " + htmlink);
            hlinks.add(htmlink);
            wordIndex.put(s, hlinks);
        } 
        
        //URLUtils.printHMap(wordIndex);
    }
    public boolean isExclude()
    {
        return false;
    }
    
    public void writeWordFile(String fname) 
    { 
      Set<String> words;
      words = wordIndex.keySet();
      String flink;
      LinkedList<HTMLLink> hLinks;
      OutputDataFile dataFile = new OutputDataFile(fname);
      
      dataFile.open();
      if (!dataFile.isOpen())
      {
          System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
          System.exit(1);
      }
      
      for(String s : words)
      {
          dataFile.println("<p>" + s + "</p>");
          hLinks = wordIndex.get(s);
          for (HTMLLink hlink: hLinks)
          {
              flink = hlink.formatLink();
              dataFile.println("<li>" + flink);    
          }
      }
      dataFile.close();
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
