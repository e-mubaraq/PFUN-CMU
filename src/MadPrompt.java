

/**
 * MadPrompt is a class that stores the description of a madword and its position in the story.
 *
 * @author Mubarak Mikail
 * 
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class MadPrompt
{
    private int position;
    private String prompt;
/*
 * You will write and design this code. So, what is a "MadPrompt"?
 *
 * A MadPrompt stores the position of the MadWord in the story, and the string from the
 * MadDictionary that should be used to prompt the user. In our posted example MadLib,
 * the first MadPrompt would indicate that the string to prompt with is "person at work"
 * and that it is for the second word of the story.
 *
 * Note: this class is very simple!
 *
 */

    /*
     * public MadPrompt() { position = -1; prompt = ""; }
     */


public MadPrompt(int p, String d)
{
    position = p;
    prompt = d;
}

public int getPosition()
{
    return position;
}

public String getPrompt()
{
    return prompt;
}

public void setPosition(int p)
{
    position = p;
}

public void setPrompt(String d)
{
    prompt = d;
}


public String toString()
{
    return "MadWord at position " + getPosition() + " with description: " + getPrompt();
}
}
