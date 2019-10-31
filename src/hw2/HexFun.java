package hw2;
import java.io.*;

/**
 * This class converts a binary number to hexadecimal.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class HexFun
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String binaryNum = "";
        System.out.print("Enter a binary number: ");
        binaryNum = keyboard.readLine();

        if (binaryNum.contains("2") || binaryNum.contains("3") || binaryNum.contains("4") || binaryNum.contains("5") 
                || binaryNum.contains("6") || binaryNum.contains("7") || binaryNum.contains("8") || binaryNum.contains("9"))
            System.out.println("This is not a binary number.");
        else
            System.out.println("0x" + convertToHex(binaryNum));
        

    }

    /**
     * This method converts the passed in binary number(String) to hex (String) by
     * calling the method convertHexDigit() at every 4 digits intervals
     * 
     * @param binaryNumber : A binary number of whatever length which will be broken
     *                     down into groups of 4 starting from the right.
     * @return hex value of the binaryNumber passed in.
     */
    public static String convertToHex(String binaryNumber)
    {
        String hex = "";
        String subBin;
        int binLength = binaryNumber.length();
        int rem = (binLength % 4);

        if (rem == 1)
            binaryNumber = "000" + binaryNumber;
        else if (rem == 2)
            binaryNumber = "00" + binaryNumber;
        else if (rem == 3)
            binaryNumber = "0" + binaryNumber;

        for (int i = 0; i < binLength; i += 4)
            {
                subBin = binaryNumber.substring(i, i + 4);
                hex = hex + convertHexDigit(subBin);
            }
        return hex;
    }

    /**
     * This method converts the passed in binary number(String) to hex (String).
     * 
     * @param binaryNumber : 4 character string to be converted to hex at once.
     * @return hex value of the binary number.
     */
    public static String convertHexDigit(String binaryNumber)
    {
        String hexDigit = "";
        int bNum = Integer.parseInt(binaryNumber);
        int a;
        int b;
        int c;
        int d;
        int hexVal;
        a = ((bNum / 1000) % 10);
        b = ((bNum / 100) % 10);
        c = ((bNum / 10) % 10);
        d = bNum % 10;

        hexVal = (int) (a * Math.pow(2, 3) + b * Math.pow(2, 2) + c * 2 + d);

        if (hexVal == 10)
            hexDigit = "A";
        else if (hexVal == 11)
            hexDigit = "B";
        else if (hexVal == 12)
            hexDigit = "C";
        else if (hexVal == 13)
            hexDigit = "D";
        else if (hexVal == 14)
            hexDigit = "E";
        else if (hexVal == 15)
            hexDigit = "F";
        else
            hexDigit = String.valueOf(hexVal);

        return hexDigit;
    }

}
