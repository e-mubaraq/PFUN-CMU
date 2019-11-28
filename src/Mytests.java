import java.io.*;
import java.net.*;
import java.util.*;

public class Mytests
{

    public static void main(String[] args) throws IOException
    {
        String fname = "out.html";
        String link = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
        String url = "http://public.africa.local.cmu.edu/cbishop/pfun/index.html";
        HTMLLink hlink;

        // System.out.println(url.getFile());

        hlink = new HTMLLink("PFUN", link);
        WebCrawler we = new WebCrawler();
         //we.parseHref(url);
         //we.parseAllHtml(url);
         //we.parseMoreHTML();
        // we.writeFile(fname);
        //URLUtils.printList(we.getErrorLinks());

        IndexGenerator indexG = new IndexGenerator(url);
         //indexG.parseWords(we);
        
        //indexG.addWordsAndHTML(we);
        // indexG.writeWordFile(fname);
         
         System.out.println(new URL(url).getFile());
         System.out.println(URLUtils.getBaseURL(new URL(url)));

    }

}
