package HW1;
import java.io.*;
import java.awt.*;

/**
 * This program performs mathematical calculations.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class PlayMath
{

public static void main(String args[]) throws IOException
{
    int n1;
    int n2;
    BufferedReader keyboard =  new BufferedReader(new InputStreamReader(System.in));
    String str = "";

    // prompt the user for the two integers, and store them in two local variables called n1 and n2
    System.out.print("Enter the first integer: ");
    str = keyboard.readLine();
    n1 = Integer.parseInt(str);

    System.out.print("Enter the second integer: ");
    str = keyboard.readLine();
    n2 = Integer.parseInt(str);

    // Print the sum of the two numbers
    System.out.println("The sum of the two numbers you have entered is: " + (n1 + n2));

    // print the maximum of the 2 numbers
    System.out.println("The maximum of the two numbers you have entered is: " + Math.max(n1 , n2));
    
    // print the remainder of n1 divided by n2
    System.out.println("The reminder of n1 divided by n2 is: " + (n1 % n2));
    
    // print the absolute value of n1 minus n2
    System.out.println("The absolute value of n1 minus n2 is: " + Math.abs(n1-n2));
    
    // print the value of n1 divided by n2, rounded to the closest integer
    System.out.println("The rounded integer value of n1 divided by n2 is: " + Math.round(n1/n2));
    
    // print n1 raised to the power of n2
    System.out.println("The value of n1 raised to the power of n2 is: " + Math.pow(n1,n2));
    
    // print the average of n1 and n2
    System.out.println("The average value of n1 and n2 is: " + ((double)(n1+n2)/2));
    
    // print the square root of n1 plus n2
    System.out.println("The square root of n1 plus n2 is: " + Math.sqrt(n1+n2));
    
    // print the minimum of the square root of n1 and the average of n1 and n2
    System.out.println("The minimum of the square root of n1 and the average of n1 and n2 is: "
            + Math.min(Math.sqrt(n1+n2), (n1+n2)/2));
    // print the area of a circle having a diameter of n1 + n2
    System.out.println("The area of a circle having a diameter of n1 + n2 is: " 
            + Math.PI * Math.pow((double)(n1+n2)/2, 2));
    
    // call getSlope() 4 times as specified below and print each returned answer
    /*
     * Test the method with the followings hard-coded values (so just call the method
     * 4 times here at the end of your main()). Make sure main() prints the answers.
     *
     *    A line with the first end point at (40, 40) and the second at (45, 45).
     * 
     *    A line with the first end point at (80, 120) and the second at (100, 40).
     * 
     *    A line with the first end point at (250, 50) and the second at (150, 75).
     * 
     *    A line with the first end point at (75, 88) and the second at (50, 88). 
     *
     */
    System.out.println("Slope of a line with the first end point at (40, 40) and the second at (45, 45) is: " 
     + getSlope(new Point(40, 40), new Point(45, 45)));
    System.out.println("Slope of a line with the first end point at (80, 120) and the second at (100, 40) is: " 
            + getSlope(new Point(80, 120), new Point(100, 40)));
    System.out.println("Slope of a line with the first end point at (250, 50) and the second at (150, 75) is: " 
            + getSlope(new Point(250, 50), new Point(150, 75)));
    System.out.println("Slope of a line with the first end point at (75, 88) and the second at (50, 88) is: " 
            + getSlope(new Point(75, 88), new Point(50, 88)));
}

/*
 * Write a method called getSlope() that takes 2 Point arguments and returns the
 * slope of the line connecting the 2 points (as a double). 
 * 
 * The formula for calculating the slope of a line is as follows:
 * 
 *  (y2 - y1) / (x2 - x1)
 *
 * Hint: you are calling the method fomr your main() - what does this tell you about the signature?
 */  
    public static Double getSlope(Point a, Point b)
    {
        double slope = 0;
        slope = (b.getY() - a.getY()) / (b.getX() - a.getX());
        return slope;
    }

}
