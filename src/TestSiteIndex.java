import java.awt.print.Printable;

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
        // TODO Auto-generated method stub
        String secretLink;
        HTMLLink link;
        IndexGenerator indexG;
        
        link = new HTMLLink(new JLabel("04-330"));
        
        secretLink = "http://public.africa.local.cmu.edu/cbishop/pfun/.phase2/mmikail07S/";
        indexG = new IndexGenerator(secretLink);
        
        System.out.println("1. My secret link for Phase 2: " + secretLink);
        System.out.println("2. base URL: " + URLUtils.getBaseURL(secretLink));
        System.out.println("3. formatted link: " + link.formatLink(secretLink));
        System.out.println("4. Listener: HyperlinkListener");
        System.out.println("5. Listener Method to Overload: public void hyperlinkUpdate(HyperlinkEvent e)");
        System.out.println("6. IndexGenerator: " + indexG );
        
        

    }

}
