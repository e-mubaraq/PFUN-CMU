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
    private JLabel label;

    public HTMLLink()
    {
        link = "";
        label = new JLabel();
    }
    public HTMLLink(JLabel label)
    {
        this.label = label;
    }
    public HTMLLink(JLabel label, String link)
    {
        this.label = label;
        this.link = link;
    }

    public String getLink()
    {
        return link;
    }
    public JLabel getLabel()
    {
        return label;
    }
    public void setLink(String link)
    {
        this.link = link;
    }
    public void setLabel(JLabel label)
    {
        this.label = label;
    }

    public String formatLink(String url)
    {
        String htmlCode;
        
        //htmlCode = "<a href=https://" + url + ">" + url + "</a>";
        htmlCode = "<a href=" + url + ">" + url + "</a>";
        return htmlCode;
    }
    
    public String toString()
    {
        return "Link: " + getLink();
    }
    

}
