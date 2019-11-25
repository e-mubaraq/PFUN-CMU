import java.io.*;
import java.net.*;
import java.util.*;

public class Mytests
{

    public static void main(String[] args) throws IOException
    {
         String link = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
         URL url = new URL("http://public.africa.local.cmu.edu/cbishop/pfun/");
         String testHref = "<a href=OutputDataFile.java><b>OutputDataFile.java</b></a>";
         String tHref = "<a href=../../testExamples.txt>testExamples.txt</a>";
         HTMLLink hlink;
         hlink = new HTMLLink("PFUN", link);
         //System.out.println(URLUtils.getBaseURL(url));
         WebCrawler we = new WebCrawler();
         //we.crawlHTML(url);
         //we.processHtml(url);
         //we.parse(url);
         //we.readInURL(url);
         
         IndexGenerator indexG = new IndexGenerator(url);
         //indexG.parseWords(we);
         //indexG.addWords(w);
         
//         System.out.println(we.getLabel(testHref));
//         System.out.println(we.getLabel(tHref));        
//         System.out.println(we.getLink(testHref));
//         System.out.println(we.getLink(tHref));
         we.addLink(url);
         //System.out.println(url.getFile());
         
    }

}

