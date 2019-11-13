
import java.util.*;
import javax.swing.JLabel;

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

public class JSecretString extends JLabel
{
    private String secretPhrase;
    private String displayString;

    public JSecretString()
    {
        secretPhrase = "";
        displayString = "";
    }

    public JSecretString(String secret)
    {
        secretPhrase = secret;
        displayString = secretPhrase.replaceAll("[A-Za-z]", "_");
        setText(displayString);
    }

    public void setSecretPhrase(String secret)
    {
        secretPhrase = secret;
        displayString = secretPhrase.replaceAll("[A-Za-z]", "_");
        setText(displayString);
    }

    public boolean equals(String display)
    {
        return display.equalsIgnoreCase(secretPhrase);
    }
    public boolean isUncovered()
    {
        if (displayString.equals(secretPhrase))
            return true;
        return false;     
    }

    public void unCoverAll()
    {
        setText(secretPhrase);
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
        setText(displayString);
        return count;
    }
    
    public String toString()
    {
        return displayString;
    }
}