package hw3;
import java.io.*;

/**
 * This class gives the count of letters, word and sentences on a line.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class WordCount
{

    public static void main(String[] args) throws IOException
    {

        String words[];
        String sentences[];
        Character[] letters;
        String lines[];
        int lineCounter;
        int i;

        lines = new String[11];

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        System.out.print("Please enter a string, press Enter to end: ");
        str = keyboard.readLine();

        lineCounter = 0;
        while (!(str.equals(""))) // lineCounter < 10 &&
        {
            if (lineCounter >= 10)
            {
                System.err.println("You have entered more than 10 lines. Sorry, this program can only accept 10 lines");
                break;
            }
            ++lineCounter;
            lines[lineCounter] = str;

            System.out.print("Please enter a string, press Enter to end: ");
            str = keyboard.readLine();
        }

        System.out.println("Thank you for entering " + (lineCounter) + " lines of data. Here are your results:\n");

        for (i = 1; i <= lineCounter; i++)
        {
            System.out.println("** Line " + i + ": " + lines[i]);

            letters = splitLetters(lines[i]);
            //words = lines[i].split("[\\p{Punct}\\p{Space}]+");
            words = lines[i].split("[,:.!?\\p{Space}]+");
            sentences = lines[i].split("[.;!?][\\p{Space}]*");

            System.out.println("Counts (letters, words, sentences): " + letters.length + " " + words.length + " "
                    + sentences.length + "\n");

            printArray("letter", letters);
            System.out.println();
            printArray("word", words);
            System.out.println();
            printArray("sentence", sentences);
            System.out.println();
        }
    }

    /**
     * This method splits the letters in a String into an array of characters.
     * 
     * @param word String that is to be splitted into letters.
     * @return char array of splitted word containing letters of the String.
     */
    public static Character[] splitLetters(String word)
    {
        int i;
        Character letters[];
        char ls[];
        ls = word.toCharArray();
        letters = new Character[ls.length];
        for (i = 0; i < letters.length; i++)
            letters[i] = Character.valueOf(ls[i]);

        return letters;
    }

    /**
     * This method helps to format the output of how the elements of the words and
     * sentences array are presented
     * 
     * @param label used to label each element at an index position
     * @param array gives the array to be indexed so as to get the element at each
     *              position
     */
    public static void printArray(String label, Object array[])
    {
        int j;
        for (j = 0; j < array.length; j++)
            System.out.println(label + "[" + j + "]" + ": " + array[j]);
    }

}
