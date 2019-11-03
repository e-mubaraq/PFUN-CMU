package hw7;

import java.util.*;

/**
 * Utils is a helper class that contains methods that can be used with any class.
 *
 * @author Mubarak Mikail
 * 
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class Utils
{

// Return "a" or "an", which ever matches wordToCheck

public static String getIndefiniteArticle(String wordToCheck)
{
    if (wordToCheck.matches("^[aeiou].*$"))
        return "an";
    return "a";
}

// This method will print a Stack as a Vector

public static void printStack(Vector<? extends Object> stack)
{
    int i = 0;
    for (Object e : stack)
    {
        System.out.println("Entry " + i + ": " + e);
        i++;
    }
}

}
