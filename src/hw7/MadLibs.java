package hw7;

import java.io.*;
import java.util.*;

public class MadLibs
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        MadDictionary dictionary = new MadDictionary();
        MadStory story;
        ObjectOutputStream out;
        ObjectInputStream in;
        String storyFile;

        String fileName = "MadDictionary.dat";
        File f = new File(fileName);

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

        story = new MadStory();
        story.readFromFile(storyFile);
        story.print(5);
        story.setupGame(keyboard, dictionary);
        story.play(keyboard);
        story.print(8);
        //dictionary.print();

            
        
        out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(dictionary);
        out.close();
        
    }
}
