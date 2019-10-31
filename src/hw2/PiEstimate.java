package hw2;
import java.io.*;

/**
 * This class calculates the value of pi from an infinite series.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.      
 *
 */
public class PiEstimate
{

    public static void main(String[] args) throws IOException
    {
        int numTerms;
        int i;
        int j;
        double pi = 0;
        double piCheck = 0;
        int holder = 0;

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Enter number of terms: ");
        str = keyboard.readLine();
        numTerms = Integer.parseInt(str);

        // prints first 5 and last 5 values of pi
        for (i = 1; i <= numTerms; i++)
            {
                pi = pi + (Math.pow(-1, (i + 1))) * (4.0 / ((2.0 * i) - 1));
                if (i >= 1 && i <= 5)
                    System.out.println(pi);
                else if (i >= numTerms - 5 && i <= numTerms)
                    System.out.println(pi);
            }

        // checks for the pattern when pi = 3.14159 is first located.
        for (j = 1; j <= numTerms; j++)
            {
                piCheck = piCheck + (Math.pow(-1, (j + 1))) * (4.0 / ((2.0 * j) - 1));
                if ((piCheck >= 3.141591) && (piCheck < 3.14160))
                    {
                        holder = j;
                        break;
                    }
            }
        if (holder != 0)
            System.out.println("1. Searched for 3.14159, found after " + (j-1) + " terms.");
        else
            System.out.println("1. Searched for 3.14159, not found after " + numTerms + " terms.");
        System.out.println("2. Pi for " + numTerms + " terms is " + pi + ".");
    }
}
