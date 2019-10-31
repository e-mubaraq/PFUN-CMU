package hw7;

import java.util.*;

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
