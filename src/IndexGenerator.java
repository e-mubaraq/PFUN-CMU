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

//    private String wordFName = "04-330_WordIndex.html";
//    private String exampleFName = "04-330_Examples.html";
    private TreeMap<String, HTMLLink> htmlFileList = new TreeMap<String, HTMLLink>();
    private String startUrl;
    private TreeMap<String, LinkedList<HTMLLink>> wordIndex = new TreeMap<String, LinkedList<HTMLLink>>();
    private WebCrawler web;

    public IndexGenerator(WebCrawler crawler)
    {
        web = crawler;
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
        if (startUrl.endsWith("/"))
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

    public void parseWords() throws IOException
    {
        Set<String> linkKeys;
        LinkedList<String> listOfLines, excludeList;
        LinkedList<HTMLLink> hlinks;
        TreeSet<String> uniqueWords;
        String[] wordsT;
        String temp, cleanedLines = "";
        HTMLLink htmlink;

        excludeList = URLUtils.readFile("excludeWords.txt");
        htmlFileList = web.gethtmlFileList();
        linkKeys = htmlFileList.keySet();
        for (String linkKey : linkKeys)
        {
            htmlink = htmlFileList.get(linkKey);
            listOfLines = web.readInURL(htmlink.getLink());

            for (String str : listOfLines)
            {
                temp = str.replaceAll("<.*?>", "");
                temp = temp.replaceAll("[\\p{Punct}0-9]", " ");
                cleanedLines = cleanedLines + " " + temp;              
            }
            wordsT = cleanedLines.toUpperCase().split("\\p{Space}");
            uniqueWords = new TreeSet<String>(Arrays.asList(wordsT));

            for (String word : uniqueWords)
            {
                if (excludeList.contains(word) || word.length() <= 3)
                    continue;
                else
                {
                    if (word.equals(""))
                        continue;
                    else if (!wordIndex.containsKey(word))
                    {
                        hlinks = new LinkedList<HTMLLink>();
                        htmlink = htmlFileList.get(linkKey);
                        hlinks.add(htmlink);
                        wordIndex.put(word, hlinks);
                    }
                    else
                    {
                        htmlink = htmlFileList.get(linkKey);
                        hlinks = wordIndex.get(word);
                        hlinks.add(htmlink);
                        wordIndex.put(word, hlinks);
                    }
                }
                System.out.println("Add word " + word + " for " + htmlink.getLink() + " to wordIndex");
            }
        }
    }

    public void writeWordFile(String fname)
    {
        Set<String> words;
        String flink;
        LinkedList<HTMLLink> hLinks;
        URLUtils.printMap(htmlFileList);
        OutputDataFile dataFile = new OutputDataFile(fname);

        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't write to " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }
        words = wordIndex.keySet();
        for (String word : words)
        {
            System.out.println("Word: " + word);
            dataFile.println("<p><b>" + word + "</p>");
            hLinks = wordIndex.get(word);
            for (HTMLLink hlink : hLinks)
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
        return "URL: " + getStartURL() + " wordsIndexFile: " + getWordsIndexFile() + " examplesIndexFile: "
                + getExampleIndexFile();
    }

}
