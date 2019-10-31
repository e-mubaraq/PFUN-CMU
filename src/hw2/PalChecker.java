package hw2;
import java.io.*;

/**
 * This class checks whether a word is Palindrome or not .
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class PalChecker
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Enter word: ");
        str = keyboard.readLine();

        if (reverseAll(str).equalsIgnoreCase(strippedString(str)))
            System.out.println("\n" + str + " IS a palindrome.");
        else
            System.out.println("\n" + str + " is NOT a palindrome.");
    }

    /**
     * This method removes any punctuation or space in between the String passed into it.
     * 
     * @param newWord String to be stripped of any space or punctuation.
     * @return A string that has been stripped off, of any form of space or punctuation.
     */
    public static String strippedString(String newWord)
    {
        String pal = "";
        pal = newWord.replaceAll("[\\p{Punct}\\p{Space}]", "");
        return pal;
    }

    /**
     * This method does a stripping of spaces and punctuation and then reverse the string passed into it.
     * 
     * @param word This is the string to be reversed.
     * @return Reversed string of the method's argument.
     */
    public static String reverseAll(String word)
    {
        String drow = ""; // reversed string of the input argument after stripping
        int i;
        word = strippedString(word);
        String wordHold = word;
        int wordLength = 0;

        while (!(wordHold.isEmpty()))
            {
                wordLength++;
                wordHold = "" + wordHold.substring(1);
            }
        for (i = wordLength; i >= 1; i--)
            drow = drow + word.substring(i - 1, i);
        return drow;
    }

}
