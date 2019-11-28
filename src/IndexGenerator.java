import java.io.IOException;
import java.net.MalformedURLException;
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

    private String wordFName= "04-330_WordIndex.html";
    private String exampleFName = "04-330_Examples.html";
    private TreeMap<String, HTMLLink> htmlFileList = new TreeMap<String, HTMLLink>();
    private String startUrl;
    //private TreeMap<String, TreeSet<HTMLLink>> wordIndex = new TreeMap<String, TreeSet<HTMLLink>>();
    private TreeMap<String, LinkedList<HTMLLink>> wordIndex = new TreeMap<String, LinkedList<HTMLLink>>();
    
    public IndexGenerator()
    {
        
    }
    
    public IndexGenerator(String startUrL)
    {
        this.startUrl = startUrL;
    }
    
    public String getStartURL()
    {
        return startUrl;
    }
    public TreeMap<String, HTMLLink> gethtmlFileList()
    {
        return htmlFileList;
    }
    
    public void setStartURL(String startUrl)
    {
        this.startUrl = startUrl;
    }
    
    public String getBaseURL() throws MalformedURLException
    {
        return URLUtils.getBaseURL(new URL(startUrl));
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
        return getWebpageTitle() + "Words.html";
    }
    public String getExampleIndexFile()
    {
        return getWebpageTitle() + "Examples.html";
    }
    
    
    public TreeSet<String> parseWords(WebCrawler web) throws IOException
    {
        LinkedList<String> listOfWords, excludeList;
        TreeSet<String> words, uniqueWords = new TreeSet<String>();
        String[] wordsT;
        String temp, word = "";
        
        excludeList = URLUtils.readFile("excludeWords.txt");
        listOfWords = web.readInURL(new URL(startUrl));
        for (String str : listOfWords)
        {
            temp = str.replaceAll("<.*?>", "");
            temp = temp.replaceAll("[\\p{Punct}0-9]", " ");
            word = word + " " + temp;            
        }

        wordsT = word.toLowerCase().split("\\p{Space}");      
        words = new TreeSet<String>(Arrays.asList(wordsT));
        for (String s : words)
        {
            if (!excludeList.contains(s))
                uniqueWords.add(s);
        }
        URLUtils.printTree(uniqueWords);
        return uniqueWords;  
    }

    public void addWordsAndHTML(WebCrawler web) throws IOException
    {
        TreeSet<String> words = new TreeSet<String>();
        //TreeSet<HTMLLink> hlinks;
        LinkedList<HTMLLink> hlinks;
        HTMLLink htmlink = new HTMLLink();
        
        web.parseAllHtml(new URL(startUrl));
        web.parseMoreHTML();
        
        words = parseWords(web);
        htmlFileList = web.gethtmlFileList();
        URLUtils.printMap(htmlFileList);
        
        
        for (String word : words)
        {
            if(word.equals(""))
                ;
            else if (!wordIndex.containsKey(word))
            {
                //hlinks = new TreeSet<HTMLLink>();
                hlinks = new LinkedList<HTMLLink>();
                htmlink = htmlFileList.get(startUrl);
                System.out.println("This is the starting url: " + startUrl);
                System.out.println(htmlink);
                hlinks.add(htmlink);
                wordIndex.put(word, hlinks);
            }
            else
            {
                htmlink = htmlFileList.get(startUrl);
                hlinks = wordIndex.get(word);
                hlinks.add(htmlink);
                wordIndex.put(word, hlinks);
            }
        } 
        URLUtils.printHMap(wordIndex);
    }
    
    public void writeWordFile(String fname) 
    { 
      Set<String> words;
      String flink;
      LinkedList<HTMLLink> hLinks;
      OutputDataFile dataFile = new OutputDataFile(fname);
      
      
      dataFile.open();
      if (!dataFile.isOpen())
      {
          System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
          System.exit(1);
      }
      words = wordIndex.keySet();
      for(String word : words)
      {
          System.out.println("Word: " + word);
          dataFile.println("<p><b>" + word + "</p>");
          hLinks = wordIndex.get(word);
          for (HTMLLink hlink: hLinks)
          {
              flink = hlink.formatLink();
              dataFile.println("<li>" + flink);    
          }
          System.out.println("Word: " + word);
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
