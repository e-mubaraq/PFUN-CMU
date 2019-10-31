package tests;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;

public class TestLineH
{

    public static void main(String argv[]) throws IOException
    {

        /* 
         * The basics steps for a graphical application are:
         *
         * 1. Create a Frame.
         * 2. Create your graphical object (with whatever settings you want).
         *    Note: your class should extend JPanel.
         * 3. Add your object to the frame.
         *    Note: you can only add 1 object to the frame.
         * 4. Set up the frame (CloseOperation and size)
         * 5. Make the frame visible.
         *
         */
        
        JFrame frame = new JFrame();

        TLine line;
        line = new TLine();
        frame.add(line);
        line.setStartPoint(new Point(100, 200));
        line.setHorizontal();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);

        // Note: this sets the frame to be visible, which will automatically call 
        // paintComponent() in your GraphicalCircle class.

        frame.setVisible(true);
        System.out.println(line);
    }

}
