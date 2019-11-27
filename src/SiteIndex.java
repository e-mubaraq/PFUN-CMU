import java.awt.*;
import java.io.*;
import javax.swing.JFrame;

/**
 * This program runs the SiteIndexGUI
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class SiteIndex
{
    public static void main(String[] args) throws IOException
    {

        final LayoutGUI gui;

        gui = new SiteIndexGUI();

        // Note: this is an anonymous inner-class that extends the Runnable class
        // and overrides the run() method.

        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI(gui);
            }
        });
    }

    private static void createAndShowGUI(LayoutGUI gui)
    
    {
        // Create a JFrame and get its content pane

        JFrame theFrame = new JFrame(gui.getClass().getName() + " Application");
        Container c = theFrame.getContentPane();

        // Instantiate the GUI, which is a JPanel

        gui.addComponents(theFrame);

        // Set the size of the frame and exit behavior

        theFrame.setPreferredSize(new Dimension(500, 400));
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the GUI to the frame

        c.add(gui);

        // show the frame

        theFrame.pack();
        theFrame.setVisible(true);
    }

}
