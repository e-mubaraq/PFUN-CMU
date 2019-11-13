import java.awt.*;
import java.io.*;
import javax.swing.JFrame;

import hw4.PhraseList;
import hw4.SecretString;


public class PlayGame
{

    public static void main(String[] args) throws IOException
    {
//        String filename;
//        if (args.length == 0)
//            filename = "names.txt";
//        else
//            filename = args[0];
//
//        PhraseList listOfPhrases = new PhraseList(filename);
//        SecretString secretPhrase = new SecretString();
        
        final LayoutGUI gui;       
        
        gui = new HangedManGUI();

        // Note: this is an anonymous inner-class that extends the Runnable class
        //       and overrides the run() method.

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

        JFrame      theFrame = new JFrame(gui.getClass().getName() + " Application");
        Container   c = theFrame.getContentPane();

        // Instantiate the GUI, which is a JPanel

        gui.addComponents(theFrame);

        // Set the size of the frame and exit behavior

        theFrame.setPreferredSize(new Dimension(800, 600));
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the GUI to the frame

        c.add(gui);

        // show the frame

        theFrame.pack();
        theFrame.setVisible(true);
    }
}


