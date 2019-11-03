package hw7;
/**
 * MadDictionary is an helper class that stores madWords and their definitions.
 *
 * @author Mubarak Mikail
 * 
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
import java.io.*;
import java.util.*;

public class MadDictionary implements Serializable
{
    private HashMap<String, StringBuffer> madWords;
    
    public MadDictionary()
    {
        madWords = new HashMap<String, StringBuffer>();
    }

    public StringBuffer addWord(String word, StringBuffer description)
    {
        if (getDescription(word) != null)
            return null; // indicates it is already in the list

        // Call the method to add the key(word) and value (description) to madWords
        madWords.put(word.toLowerCase(), description);
        return description;
    }

    public StringBuffer getDescription(String word)
    {
        StringBuffer description;

        // Call the method to set description to the value in madWords for the key word
        description = madWords.get(word.toLowerCase());
        return description;
    }

    public void print()
    {
        for (String key : madWords.keySet())
        {
            // Write the System.out.printl() call to print the key and value in madWords
            System.out.println("Word: " + key + "      Definition: " + madWords.get(key));
        }
    }
    
    public String toString()
    {
        return "There are " + madWords.size() + "entries in the Mad Dictionary";
    }
}
