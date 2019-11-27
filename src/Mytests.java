import java.io.*;
import java.net.*;
import java.util.*;

public class Mytests
{

    public static void main(String[] args) throws IOException
    {
        String fname = "out.html";
        //String hlink = "<a href =\"http://www.cmu.edu/academic-integrity/index.html\">ssnn <\a>";
         String link = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
         URL url = new URL("http://public.africa.local.cmu.edu/cbishop/pfun/");
         HTMLLink hlink;
         
         
         //System.out.println(url.getFile());
         
         hlink = new HTMLLink("PFUN", link);
         //System.out.println(URLUtils.getBaseURL(url));
         WebCrawler we = new WebCrawler();
         //we.parse(url);
         we.parseAllHtml(url);
         we.writeFile(fname);
         URLUtils.printStack(we.getErrorLinks());
         
         IndexGenerator indexG = new IndexGenerator(url);
         //indexG.parseWords(we);
         //indexG.addWords(we);
                 
         
         //indexG.addWordsAndHTML(we);
         //indexG.writeWordFile(fname);
         
         
    }

}

