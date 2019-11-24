import java.io.*;
import java.net.*;
import java.util.*;

public class Mytests
{

    public static void main(String[] args) throws IOException
    {
         String link = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
         URL url = new URL("http://public.africa.local.cmu.edu/cbishop/pfun/");
         
         System.out.println(URLUtils.getBaseURL(url));
         
         WebCrawler w = new WebCrawler(url);
         //w.crawlHTML(url);
         //System.out.println(w.crawlHTML(url));
         //System.out.println(w.parse(url));
         //System.out.println(w.readInURL(url));
         
         IndexGenerator indexG = new IndexGenerator(url);
         //indexG.parseWords(w);
         indexG.addWords(w);
    }

}

