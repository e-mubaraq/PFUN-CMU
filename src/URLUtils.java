import java.net.URL;

/**
 * This class contains helpful static methods for working with URLs
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class URLUtils
{

    public static String getBaseURL(String url)
    {
        String temp, baseUrl;
        if (url.startsWith("http://"))
        {
            temp = url.replace("http://", "");
            baseUrl = "http://" + temp.replaceAll("[/].*$", "") + "/" + "cbishop/pfun/";
        }
        else if (url.startsWith("https://"))
        {
            temp = url.replace("https://", "");
            baseUrl = "https://" + temp.replaceAll("[/].*$", "") + "/" + "cbishop/pfun/";
        }            
        else
        {
            temp = url;
            baseUrl = temp.replaceAll("[/].*$", "") + "/" + "cbishop/pfun/";
        }
            
        
        return baseUrl;
    }

    public static String getBaseURL(URL url)
    {
        String baseURL;
        baseURL = url.getProtocol() + "://"+ url.getHost() + "/" + "cbishop/pfun/";
        
        
        return baseURL;
        
    }
    public static String getWebPageTitle(String link)
    {
        int idx, idx2;
        String title = "";
        if(link.contains("<title>"))
        {
            idx = link.indexOf("<title>");
            idx2 = link.indexOf("</title>");
            
            title = link.substring(idx + 7, idx2);
        }
        return title;        
    }
}
