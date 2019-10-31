package hw4;
import java.util.*;

/**
 * This reads and stores phrases from it or others in an array list
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

public class PhraseList
{
    private ArrayList<String> phraseList = new ArrayList<String>();

    public PhraseList()
    {

    }

    public PhraseList(String filename)
    {
        readFile(filename);
    }

    public void readFile(String filename)
    {
        String input;

        InputDataFile dataFile = new InputDataFile(filename);

        dataFile.open();
        if (!dataFile.isOpen())
        {
            System.out.println("Can't read " + dataFile.getName() + " because it is not opening.");
            System.exit(1);
        }

        input = dataFile.readString();
        while (input != null)
        {
            phraseList.add(input);
            input = dataFile.readString();
        }

        dataFile.close();
    }

    public void addPhrase(String phrase)
    {
        phraseList.add(phrase);
    }

    public String getPhrase(int index)
    {
        if (index >= phraseList.size())
            return "This is out of bounds.";
        
        return phraseList.get(index);
    }

    public String getRandomPhrase()
    {
        Random random = new Random();
        return phraseList.get(random.nextInt(phraseList.size()));
    }

    public void clear()
    {
        phraseList.clear();
    }
    
    public void print()
    {
        for (int i = 0; i < phraseList.size(); i++)
            System.out.println( phraseList.get(i) + ", ");
    }
    
    public String toString()
    {
        String result = "This list has " + phraseList.size() + " items. They are: ";
        
        for (int i = 0; i < phraseList.size(); i++)
            result = result + phraseList.get(i) + ", ";
        
        return result;
    }
}
