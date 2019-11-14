

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

    private String startUrl;
    private String baseUrl;
    
    
    public IndexGenerator()
    {
        
    }
    
    public IndexGenerator(String startURL)
    {
        this.startUrl = startURL;
    }
    
    public String getStartURL()
    {
        return startUrl;
    }
    
    public void setStartURL(String startURL)
    {
        this.startUrl = startURL;
    }
    
    public String getBaseURL()
    {
        return baseUrl;
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
        return getWebpageTitle() + ".html";
    }
    public String getExampleIndexFile()
    {
        return getWebpageTitle() + ".html";
    }
    
    public String toString()
    {
        return "URL: " + getStartURL()+ " wordsIndexFile: " + getWordsIndexFile() +  " examplesIndexFile: " + getExampleIndexFile();
    }
}
