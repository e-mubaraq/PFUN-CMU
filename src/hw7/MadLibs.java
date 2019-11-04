package hw7;

import java.io.*;
import java.util.*;

/**
 * MadLibs is a program that helps to setup and play the Madlibs game.
  * @author Mubarak Mikail
 * 
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
        String storyFile,fileName, gameOption, printOption;

        fileName = "MadDictionary.dat";
        f = new File(fileName);
        
//        System.out.print("Enter a 1 to Play MadLibs.\n" + "Enter a 2 to Administer MadLibs.\n");
//        gameOption = keyboard.readLine();
        
        if (f.exists())
        {
            in = new ObjectInputStream(new FileInputStream(fileName));
            dictionary = (MadDictionary) in.readObject();
            in.close();
        }
        else
            System.out.println(fileName + " does not exist.\n");

        System.out.print("Enter the file name: ");
        storyFile = keyboard.readLine();       
//        while (!storyFile.equals(""))
//        {
//            
//        }
        
        story = new MadStory();
        story.readFromFile(storyFile);
        //story.print(5);
        story.setupGame(keyboard, dictionary);
        story.print(5);
        //story.play(keyboard);
        //story.print(8);
        //dictionary.print();

            
        
        out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(dictionary);
        out.close();
        
//        System.out.print("Enter a 1 to print the MadLib story to the screen.\n" + 
//                "Enter a 2 to print the MadLib story to a PDF file.");
//        if(gameOption.equals("1"))
//            System.out.print("Enter a 3 to play the MadLib.");
//        printOption = keyboard.readLine();
        
    }
}
