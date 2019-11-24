
import java.net.URL;
import javax.swing.JLabel;

/**
 * This is my test program
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class TestSiteIndex
{

    public static void main(String[] args)
    {
        String secretLink, classWebSite;
        URL sWebsite;
        HTMLLink link;
        IndexGenerator indexG;
        
        
        secretLink = "http://public.africa.cmu.edu/cbishop/pfun/.phase3/mmikailt9V/";
        classWebSite = "http://public.africa.cmu.edu/cbishop/pfun/";
        link = new HTMLLink("04-330" , classWebSite);
        indexG = new IndexGenerator(classWebSite);
        
        System.out.println("1. My secret link for Phase 3: " + secretLink);
        System.out.println("2. The class of the callback object for the Listener on the Return to Index button is: SiteIndexGUI");
        System.out.println("3. The method this listener calls with the callback object is: setPage");
        System.out.println("4. The class of the callback object for LinkListener is: JEditorPane");
        System.out.println("5. The LinkListener code calls this method to access the string value of the link that was clicked: getURL");
        System.out.println("6. The method the LinkListener calls with the callback object is: setPage");
        System.out.println("7. The class used to read in the contents of the URL for processing is: BufferedReader");
        System.out.println("8. The mystery() method to call for creating the BufferedReader is: openStream");
        
        

    }

}
