package hw7;

import java.io.*;
import java.util.*;

/**
 * MadUtils is a helper class that contains methods that are important to the working of the MadLibs game.
 *
 * @author Mubarak Mikail
 * 
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class MadUtils
{

/*
 * This method will lookup the word in the MadDictionary d.
 * If it does not exists, the method return null;
 *
 */

public static StringBuffer lookupWord(String word, MadDictionary d) throws IOException
{
    return lookupWord(word, d, null);
}

/*
 * This method will lookup the word in the MadDictionary d.
 * If it exists in the dictionary, it is returned.
 * If it does not exist, and keyboard is not null, it will
 * prompt for the MadDefinition, add it to the MadDictionary, and return it.
 */

public static StringBuffer lookupWord(String word, MadDictionary d, BufferedReader keyboard)
    throws IOException
{  
    StringBuffer definition = null;
    
    definition = d.getDescription(word);
    if (definition != null)
        return definition;

    if (keyboard != null)
    {
        System.out.print("Word: " + word + " not in MadDictionary. Please enter the description: ");
        definition = new StringBuffer(keyboard.readLine());
        d.addWord(word, definition);
    }

    return definition;
}
    
/*
 * This method returns the MadWord, which is the text within [ and ].
 * The method return null if there is no MadWord (no [ ], empty string, null pointer, ...)
 *
 */

public static String getMadWord(String str)
{
    int n, m;
    String madWord = null;
    String wordRep = "";
    
    if (str.contains("["))
        wordRep = str;
    else
        return null;
    if (str.contains("]"))
    {
        n = str.indexOf("]");
        m = str.indexOf("[");
        madWord = wordRep.substring(m+1, n);
    }

    return madWord;
}

// This method returns a String that has the text within [ and ] of madWord replaced with newWord.

public static String replaceMadWord(String madWord, String newWord)
{
    String result;
    String str = getMadWord(madWord);
    result = madWord.replace(str, newWord);
    
    return result;
}
public static LinkedList<String> smartSplit(String wordtoSplit)
{
    String words[];
    LinkedList<String> smartList = new LinkedList<String>();

    //words = wordtoSplit.split("(?=[,.!?:\\[])");   
    words = wordtoSplit.split(" (?![^\\[]*[\\]])");  
    if (wordtoSplit.equals(""))
        smartList = null;
    else
    {      
        for (String word : words)
            smartList.add(word);
    }
    return smartList;    
}
}

