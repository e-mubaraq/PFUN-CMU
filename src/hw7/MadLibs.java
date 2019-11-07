package hw7;
import java.io.*;
import java.util.*;

/**
 * MadLibs is a program that helps to setup and play the Madlibs game.
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class MadLibs
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        MadDictionary dictionary = new MadDictionary();
        MadStory story;
        ObjectOutputStream out;
        ObjectInputStream in;
        File f;
        String storyFile, fileName, gameOption, printOption;

        fileName = "MadDictionary.dat";
        f = new File(fileName);

        if (f.exists())
        {
            in = new ObjectInputStream(new FileInputStream(fileName));
            dictionary = (MadDictionary) in.readObject();
            in.close();
        }
        else
            System.out.println("Dictionary file does not exist.\n");

        System.out.print("Enter a 1 to Play MadLibs.\n" + "Enter a 2 to Administer MadLibs.\n");
        gameOption = keyboard.readLine();

        System.out.print("Enter the MadLib file name: ");
        storyFile = keyboard.readLine();

        while (!storyFile.equals(""))
        {
            f = new File(storyFile);
            if (!f.exists())
            {
                System.out.print("Enter a MadLib file name that exists: ");
                storyFile = keyboard.readLine();
            }
            story = new MadStory();
            story.readFromFile(storyFile);

            //story.print(80); // prints the madlibs story that was passed in from the story file.
            if (gameOption.equals("1")) // user
            {
                if (!story.setupGame(null, dictionary))
                {
                    System.out.println("MadLib cannot be played until the administrator has set it up.");
                    System.out.print("Enter another MadLib file name: ");
                    storyFile = keyboard.readLine();
                    continue;
                }
            }
            else if (!(gameOption.equals("1") || gameOption.equals("2"))) // neither a user nor administrator
            {
                System.out.println("Please enter a 1 to play or 2 to adminsiter a Madlibs game.");
                System.out.print("Enter a 1 to Play MadLibs.\n" + "Enter a 2 to Administer MadLibs.\n");
                gameOption = keyboard.readLine();
                continue;
            }
            else if (gameOption.equals("2")) // administrator
                story.setupGame(keyboard, dictionary);

            if (gameOption.equals("1"))
            {
                System.out.print("Enter a 1 to print the MadLib story to the screen.\n"
                        + "Enter a 2 to print the MadLib story to a PDF file.\n" + "Enter a 3 to play the MadLib.\n");
                printOption = keyboard.readLine();
                if (printOption.equals("3"))
                {
                    story.play(keyboard);
                    story.print(80);
                }
                else if (printOption.equals("2"))
                    story.printPDF(60);
                else if (printOption.equals("1"))
                    story.print(80);
                else
                    break;
            }
            else if (gameOption.equals("2"))
            {
                System.out.print("Enter a 1 to print the MadLib story to the screen.\n"
                        + "Enter a 2 to print the MadLib story to a PDF file.\n");
                printOption = keyboard.readLine();
                if (printOption.equals("1"))
                    story.print(80);
                else if (printOption.equals("2"))
                    story.printPDF(60);
                else
                    break;
            }

            System.out.print("Enter the next MadLib file name: ");
            storyFile = keyboard.readLine();
        }

        out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(dictionary);
        out.close();
    }

}
