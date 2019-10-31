package hw5;

import java.awt.*;
import java.io.*;

import javax.swing.*;

/**
 * This program draws a bounded rectangle for other shapes.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class TestIceCreamConePG
{
public static void main(String[] args) throws IOException
{
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    
    // Declare and instantiate the variables you need to prompt for the centerX and centerY,
    // the width and height, and the color.
    // ---------- You write the code here:      
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    int width = 100;
    int height = 100;
    int centerX = 200;
    int centerY = 200;
    int i, n;
    Color color = Color.BLACK;
    String str, colorString;
    String [] coordinates;
    
    // Create your shape and call the constructor. Call your variable shape.
    // ---------- You write the code here:    
    IceCreamConePG shape = new IceCreamConePG();
    panel.add(shape);   // add your shape to the displayed screen

    // Do not change these. We will talk about the code as time permits.

    panel.setBackground(Color.white);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.setVisible(true);
    shape.setSize(frame.getSize());
    shape.setPreferredSize(frame.getSize());
    
    shape.setDebug(false);
    shape.setHeight(height);
    shape.setWidth(width);
    shape.setCenter(new Point(centerX, centerY));
    //shape.addScoop(Color.ORANGE);
    shape.setColor(color);
    /*
     * Use your setters to setup the initial attributes for your shape.
     * Don't forget to set debug on.
     */

    // ---------- You write the code here:

    /*
     * Prompt the user for the attributes, starting with the x and y coordinates of the center.
     *      Then prompt for width,height
     *      Then prompt for the color.
     *      Use your setters to re-set the attributes.
     *      Right before re-prompting, call shape.repaint() to update the picture.
     * Continue prompting until they press enter when asked for x,y.
     *
     */
    System.out.print("Enter center point  in x,y format: ");
    str = keyboard.readLine();
    
    while(!str.equals(""))
    {
        coordinates = str.replaceAll("\\p{Space}", "").split(",");

        centerX = Integer.parseInt(coordinates[0]);
        centerY = Integer.parseInt(coordinates[1]);

        System.out.print("Please enter the width: ");
        str = keyboard.readLine();
        width = Integer.parseInt(str);
        
        System.out.print("Please enter the height: ");
        str = keyboard.readLine();
        height = Integer.parseInt(str);
        
        System.out.print("Please enter the color: ");
        colorString = keyboard.readLine();
        color = ColorConverter.getColor(colorString);
        
        System.out.print("Enter numer of scoops: ");
        str = keyboard.readLine();
        n = Integer.parseInt(str);
        
        for (i = 1; i <= n; i++)
        {
            System.out.print("Enter the color of your scoop " + i + ": ");
            str = keyboard.readLine();
            shape.addScoop(str);
        }
        
        shape.setDebug(false);
        shape.setShapeSize(width, height);
        shape.setCenter(new Point(centerX, centerY));
        shape.setColor(color);
        
        shape.repaint();
        System.out.println(shape);
        
        System.out.print("Enter center point  in x,y format: ");
        str = keyboard.readLine();
        
    }

    // ---------- You write the code here:

    // This is printed when the user exits your input loop.
    System.out.println("Finished testing. Close the window when finished.");
}

}

