import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;


/**
 * This class represents an html link
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class HTMLLink
{
    private String link;
    private String label;
    public static String baseURL; //= "http://public.africa.local.cmu.edu/cbishop/pfun/"

    public HTMLLink()
    {
        link = "";
        label = "";
    }
    public HTMLLink(String label, String link)
    {
        this.label = label;
        this.link = link;
    }

    public String getLink()
    {
        return link;
    }
    public String getLabel()
    {
        return label;
    }
    public String getBaseURL()
    {
        return baseURL;
    }
    public void setLink(String link)
    {
        this.link = link;
    }
    public void setLabel(String label)
    {
        this.label = label;
    }
    

    public String formatLink()
    {
        String htmlCode;
        
        htmlCode = "<a href=" + link + ">" + label + "</a>";
        return htmlCode;
    }
    
    public boolean equals(HTMLLink l)
    {
        return this.equals(l);
    }
    
    public boolean isBaseEquals(String URL) throws MalformedURLException
    {
        String bURL = URLUtils.getBaseURL(new URL(URL));
        
        return baseURL.equalsIgnoreCase(bURL);
    }
    
    public boolean isRelativeLink(String URL)
    {
        if (!URL.replaceAll("\"", "").startsWith("http"))
            return true;
        return false;
    }
    
    public String getFullLink(String link)
    {
        if(link.contains("/cbishop/pfun/"))
            return baseURL;
        else if(isRelativeLink(link))
            return baseURL + link.replaceAll("\"", "");
//        else if(link.equalsIgnoreCase("/cbishop/pfun/"))
//            return baseURL;
        else
            return link;
    }
    
    public String toString()
    {
        return "Link: " + getLink() + ", Label: " + getLabel();
    }
    
}
