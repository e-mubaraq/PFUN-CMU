import java.io.*;
import java.net.*;
import java.util.*;

public class Mytests
{

    public static void main(String[] args) throws IOException
    {
         String link = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
         URL url = new URL("http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/");
         String testHref = "<a href=OutputDataFile.java><b>OutputDataFile.java</b></a>";
         String tHref = "<a href=../../testExamples.txt>testExamples.txt</a>";
         //System.out.println(URLUtils.getBaseURL(url));
         WebCrawler we = new WebCrawler();
         WebCrawler w = new WebCrawler(url);
         //w.crawlHTML(url);
         w.processHtml(url);
         //System.out.println(w.parse(url));
         //System.out.println(w.readInURL(url));
         
         IndexGenerator indexG = new IndexGenerator(url);
         //indexG.parseWords(w);
         //indexG.addWords(w);
         
         System.out.println(we.getLabel(testHref));
         System.out.println(we.getLabel(tHref));
         
         System.out.println(we.getLink(testHref));
         System.out.println(we.getLink(tHref));
    }

}

