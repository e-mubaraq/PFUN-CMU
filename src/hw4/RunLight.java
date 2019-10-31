package hw4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 * This is a basic traffic light test program.
 *
 * @author Mubarak Mikail
 * 
 * @author Ozioma Paul
 * 
 * Andrew ID: mmikail 
 * 
 * Andrew ID: pozioma
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class RunLight
{
    public static void main(String argv[]) throws IOException
    {
        JFrame frame = new JFrame();

        TrafficLight light;
        light = new TrafficLight();

        // This is the code to add the "Listener" - it listens for mouse clicks
        light.addMouseListener(new Listener(light));
        frame.add(light);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setVisible(true);
        System.out.println(light);
    }
}

class Listener extends MouseAdapter
{
    private TrafficLight light;

    Listener(TrafficLight l)
    {
        light = l;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // This method handles when the mouse os pressed.
        // Take out the trace statement after you have seen when this code is executed.

        System.out.println("Mouse Pressed: ");

        // System.out.println(light);
        light.change(); // Note: you write this method
        light.repaint(); // This will call your paintComponent() method automatically.
                         // Note: Do NOT write repaint().
        System.out.println("\n" + light);
    }
}
