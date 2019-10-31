package tests;
import java.io.IOException;

import javax.swing.JFrame;

public class TestLabelledLine
{

    public static void main(String argv[]) throws IOException
    {
        JFrame frame = new JFrame();

        LabelledLine hLine;
        hLine = new LabelledLine();

        frame.add(hLine);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);

        frame.setVisible(true);
        System.out.println(hLine);
    }

}
