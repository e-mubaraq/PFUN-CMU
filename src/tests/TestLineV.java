package tests;

import java.io.IOException;

import javax.swing.JFrame;

public class TestLineV
{

    public static void main(String argv[]) throws IOException
    {
        
        JFrame frame = new JFrame();

        TLine line;
        line = new TLine();
        
        frame.add(line);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);

        // Note: this sets the frame to be visible, which will automatically call 
        // paintComponent() in your GraphicalCircle class.

        frame.setVisible(true);
        System.out.println(line);
    }
}
