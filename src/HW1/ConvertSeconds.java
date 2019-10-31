package HW1;
import java.io.*;

/**
 * This class converts seconds into hours, minutes and seconds.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class ConvertSeconds 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Enter the seconds: ");
        str = keyboard.readLine();
        int secs = Integer.parseInt(str);
        int hours = secs / 3600;
        int minutes = (secs % 3600) / 60;
        int secondsRemain = (secs % 3600) % 60;
        
        System.out.println("\n" + "*** Output ***");
        System.out.println("\n" + "Hours:   " + hours);
        System.out.println("Minutes: " + minutes);
        System.out.println("Seconds: " + secondsRemain);

    }
}
