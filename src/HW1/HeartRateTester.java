package HW1;

import java.io.*;

/**
 * This class tests maximum heart rate in beats per seconds.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class HeartRateTester
{
    public static void main(String[] args) throws IOException
    {
        String fName;
        String lName;
        int day;
        int month;
        int year;

        String str = "";
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        //String str = "";
        System.out.print("Enter your first name: ");
        fName = keyboard.readLine();

        System.out.print("Enter your last name: ");
        lName = keyboard.readLine();

        System.out.print("Enter day of birth: ");
        str = keyboard.readLine();
        day = Integer.parseInt(str);

        System.out.print("Enter month of birth: ");
        str = keyboard.readLine();
        month = Integer.parseInt(str);

        System.out.print("Enter year of birth: ");
        str = keyboard.readLine();
        year = Integer.parseInt(str);

        HeartRate HRtest = new HeartRate(fName, lName, day, month, year);
        System.out.println("\n" + "*** Output ***");
        System.out.println(HRtest + "\n" + "Age in Hex: " + getHex(HRtest.getAge()));

    }

    public static String getHex(int num) // This method converts an integer to hexadecimal
    {
        String hex = "";
        hex = Integer.toHexString(num);
        return hex;
    }

}
