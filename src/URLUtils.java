
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
            temp = url.replace("http://", "");
        else
            temp = url;
        baseUrl = temp.replaceAll("[/].*$", "") + "/";
        
        return baseUrl;
    }

}
