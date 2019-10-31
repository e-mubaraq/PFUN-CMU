package hw5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * This program draws all the shapes.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class ShowShapes
{

public static void main(String argv[]) throws IOException
{
    JFrame frame = new JFrame();
    HoldShapes shapes;
    shapes = new HoldShapes();
    String str;
    int i , n;
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    //------------ You write the code ----------------

    System.out.print("Enter numer of scoops: ");
    str = keyboard.readLine();
    n = Integer.parseInt(str);
    
    for (i = 1; i <= n; i++)
    {
        System.out.print("Enter the color of your scoop " + i + ": ");
        str = keyboard.readLine();
        shapes.addScoop(str);
    }
    // Prompt for the number of scoops then prompt for each color and call
    // shapes.addScoop(). You will finish addScoop() in HoldShapes - it should take one
    // argument that is the color to use. Note: see Hold.java for more comments.


    System.out.println("Thanks for ordering " + n + " scoops! Close the window when done.");

    frame.setSize(1000, 850);
    shapes.setSize(frame.getSize());
    shapes.setPreferredSize(frame.getSize());
    frame.add(shapes);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

}

