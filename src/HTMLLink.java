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
    
    public String toString()
    {
        return "Link: " + getLink();
    }
    

}
