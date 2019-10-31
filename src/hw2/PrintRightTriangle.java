package hw2;
import java.io.*;

/**
 * This class draws a Right Triangle.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class PrintRightTriangle
{

    public static void main(String[] args) throws IOException
    {
        int width;
        String chara;
        String location;
        
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str ="";
        
        System.out.print("Enter the width of the triangle: ");
        str = keyboard.readLine();
        
        while(!(str.equals("")))
            {                
                width = Integer.parseInt(str);
                
                System.out.print("Enter character to draw triangle with: ");
                chara = keyboard.readLine();
                
                System.out.print("Enter location of triangle: " );
                location = keyboard.readLine();
                
                
                RightTriangle tri = new RightTriangle(width, chara, location);
                System.out.println("Description: " + tri);
                tri.drawAsciiArt();
                
                             
                System.out.print("\nEnter the width of the triangle: ");
                str = keyboard.readLine();                                       
            }      
    }

}
