package hw4;
import java.util.*;

/**
 * This program holds a secret string
 *
 * @author Mubarak Mikail
 * 
 * @author Ozioma Paul
 * 
 * Andrew ID: mmikail 
 * 
 * Andrew ID: pozioma
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class SecretString
{
    private String secretPhrase;

    private String displayString;

    public SecretString()
    {
        secretPhrase = "";
        displayString = "";
    }

    public SecretString(String secret)
    {
        secretPhrase = secret;
        displayString = secretPhrase.replaceAll("[A-Za-z]", "_");
    }

    public void setSecretPhrase(String secret)
    {
        secretPhrase = secret;
        displayString = secretPhrase.replaceAll("[A-Za-z]", "_");
    }

    public String toString()
    {
        return displayString;
    }

    public boolean equals(String display)
    {
        return display.equalsIgnoreCase(secretPhrase);
    }

    public int reveal(String match)
    {
        int count = 0;
        String fitIn = "";

        for (int i = 0; i < match.length(); i++)
        {
            for (int j = 0; j < secretPhrase.length(); j++)
            {
                if (String.valueOf(match.charAt(i)).equalsIgnoreCase(String.valueOf(secretPhrase.charAt(j))))
                {
                    if (j == 0)
                        fitIn = String.valueOf(secretPhrase.charAt(j)) + displayString.substring(j + 1);
                    else
                        fitIn = displayString.substring(0, j) + String.valueOf(secretPhrase.charAt(j))
                                + displayString.substring(j + 1);

                    displayString = fitIn;

                    count = count + 1;
                }
            }
        }
        return count;
    }
}