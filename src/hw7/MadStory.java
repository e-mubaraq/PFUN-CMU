package hw7;

import java.io.*;
import java.util.*;

/**
 * MadStory is an helper class that sets up, plays and prints the MadLibs game.
 *
 * @author Mubarak Mikail
 * 
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class MadStory
{
private LinkedList<String> story = new LinkedList<String>();
private Stack<MadPrompt> prompts = new Stack<MadPrompt>();
private boolean isReady = false;
private InputDataFile datafile;
// Read a story from the file.

public void readFromFile(String filename)
{
    String inword;
    List<String> wordList;
    
    datafile = new InputDataFile(filename);
    // read a line of data
    // while input OK
    datafile.open();
    if(!datafile.isOpen())
    {
        System.out.println("can't open " + datafile.getName()
        + " for reading. File does not exist, program ending");
        System.exit(1);
    }
    inword = datafile.readString();    
    while (inword != null)
    {

        // Call your MadUtils.smartSplit() method.
        // It should indicate that it got a blank line with null.
        // This means it's a paragraph break - if it returns null,
        // add an empty string to your story, read a line, then continue.

        // Not a paragraph break, so add the words to the story.
        
        // read a line of data
        if (MadUtils.smartSplit(inword) == null)
            story.add("");
        else
        {
            wordList = MadUtils.smartSplit(inword);
            story.addAll(wordList);
        }
        inword = datafile.readString();
    }
    datafile.close();
}


// Set up the game

public boolean setupGame(BufferedReader keyboard, MadDictionary dictionary) throws IOException
{
    MadPrompt p;
    StringBuffer madDef = null;
    String str;

    int numWords = 0;

    // Iterate through the story

    for (String word : story)
    {
        numWords++;
        str = MadUtils.getMadWord(word);
        if (str != null)
        {
            // ----------- You write the code -----------//
            // Look up the definition in the dictionary, using your MadUtils.lookupWord() method
            // create a MadPrompt using numWords and the definition
            // add it to the Stack (use the proper method for a Stack)
            madDef = MadUtils.lookupWord(str, dictionary, keyboard);
            
            p = new MadPrompt(numWords, madDef.toString());
            prompts.push(p);
        }
    }
    Utils.printStack(prompts);
    isReady = true;
    return true;
}

// Play the game

public boolean play(BufferedReader keyboard) throws IOException
{
    String str, prompt, madWord, newWord;
    MadPrompt p;
    int i, position;

    if (!isReady)
        return false;

    isReady = false;

    // ----------- You write the code -----------//
    // Process the MadPrompts stack - use the proper terms and method
    // for processing a Stack.
    
    // For each MadPrompt taken off the Stack, prompt the user (use Utils.getIndefiniteArticle())
    // then use the entered value to replace the mad word in the story LinkedList.
    for (i = prompts.size(); i > 0; i--)
    {       
        p = prompts.pop();
        prompt = p.getPrompt();
        position = p.getPosition();
        System.out.print("Please enter " + Utils.getIndefiniteArticle(prompt) + " " + prompt + ": ");
        
        str = keyboard.readLine();
        madWord = story.get(position - 1);
        
        // Replace word in the story 
        newWord = MadUtils.replaceMadWord(madWord, str);
        System.out.println("Replaced with " + newWord);
        System.out.println("***************** put new word in to story");      
    }

    return true;
}

// ----------- You write the code -----------//
// Print the story to the screen
// Be sure to show the paragraph markers.

// Start by printing the MadWords, then update it to format it into lines of n characters,
// with the MadWord replaced with underscores and the MadPrompt on the line below.

public void print(int n)
{
    String madWord;
    int i = 0;
    
    for (String s : story)
    {
        madWord = MadUtils.getMadWord(s);
        i++;
        if (i % n == 0)
        {
            if (madWord != null)
                System.out.print(Utils.replaceStrWithUnderscores(madWord) + " " );             
            else
                System.out.print(i + ": " + s + " " );
            System.out.println();
            continue;
            
        }
        else
        {
            if (madWord != null)
                System.out.print(Utils.replaceStrWithUnderscores(madWord) + " " );             
            else
                System.out.print(s + " " );
        }
         
    }
        
    System.out.println();

    
}
}
