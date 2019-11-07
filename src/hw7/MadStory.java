package hw7;

import java.io.*;
import java.util.*;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

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

// Read a story from the file.

    public boolean isReady()
    {
        return isReady;
    }

    public void readFromFile(String filename)
    {
        InputDataFile datafile;
        String inword;
        List<String> wordList;

        datafile = new InputDataFile(filename);
        story.clear();
        // read a line of data
        // while input OK
        datafile.open();
        if (!datafile.isOpen())
        {
            System.out
                    .println("can't open " + datafile.getName() + " for reading. File does not exist, program ending");
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

        prompts.clear();
        for (String word : story)
        {
            numWords++;
            str = MadUtils.getMadWord(word);
            if (str != null)
            {
                // ----------- You write the code -----------//
                // Look up the definition in the dictionary, using your MadUtils.lookupWord()
                // method
                // create a MadPrompt using numWords and the definition
                // add it to the Stack (use the proper method for a Stack)

                madDef = MadUtils.lookupWord(str, dictionary, keyboard);
                if (madDef == null)
                    return false;
                p = new MadPrompt(numWords, madDef.toString());
                prompts.push(p);
            }
        }
        //Utils.printStack(prompts);
        isReady = true;
        return true;
    }

// Play the game

    public boolean play(BufferedReader keyboard) throws IOException
    {
        String str, prompt, madWord, newWord;
        MadPrompt p;
        int position;

        if (!isReady)
            return false;

        isReady = false;

        // ----------- You write the code -----------//
        // Process the MadPrompts stack - use the proper terms and method
        // for processing a Stack.

        // For each MadPrompt taken off the Stack, prompt the user (use
        // Utils.getIndefiniteArticle())
        // then use the entered value to replace the mad word in the story LinkedList.
        while (!prompts.isEmpty())
        {
            p = prompts.pop();
            prompt = p.getPrompt();
            position = p.getPosition();

            System.out.print("Please enter " + Utils.getIndefiniteArticle(prompt) + " " + prompt + ": ");

            str = keyboard.readLine();
            madWord = story.get(position - 1);

            // Replace word in the story
            newWord = MadUtils.replaceMadWord(madWord, str);
            story.set(position - 1, newWord);
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
        MadPrompt p;
        Stack<MadPrompt> p2 = new Stack<MadPrompt>();
        String madWordCheck, madWord, definition;
        String topLine = "";
        String bottomLine = "";
        int wordLenght, j, counter = 0;

        while (!prompts.isEmpty())
        {
            p = prompts.pop();
            p2.push(p);
        }

        if (p2.isEmpty())
            printOtherwise(n);
        else
        {
            for (String s : story)
            {
                wordLenght = s.length();
                counter = counter + wordLenght + 1;
                if ((counter >= n) || s.equals(""))
                {
                    Utils.printIfNotEmpty(topLine);
                    Utils.printIfNotEmpty(bottomLine);
                    System.out.println();
                    topLine = "";
                    bottomLine = "";
                    counter = 0;
                    if (s.equals(""))
                        continue;
                }
                madWord = MadUtils.getMadWord(s);
                if (madWord != null) // it is a madword
                {
                    madWordCheck = s.substring(wordLenght - 1);
                    p = p2.pop();
                    definition = p.getPrompt();
                    if (madWordCheck.equals("]"))
                    {
                        topLine = topLine + Utils.replaceStrWithUnderscores(definition) + " ";
                        bottomLine = bottomLine + definition + " ";
                    }
                    else
                    {
                        topLine = topLine + Utils.replaceStrWithUnderscores(definition) + madWordCheck + " ";
                        bottomLine = bottomLine + definition + " " + " "; // needs an extra space for the punctuaution
                    }
                }
                else
                {
                    topLine = topLine + s + " ";
                    for (j = 0; j <= wordLenght; j++)
                    {
                        bottomLine = bottomLine + " ";
                    }
                }
            }
            System.out.println(topLine);
            System.out.println(bottomLine);
            System.out.println();
        }
    }

    public void printOtherwise(int n)
    {
        String topLine = "";
        int wordLenght, counter = 0;

        for (String s : story)
        {
            wordLenght = s.length();
            counter = counter + wordLenght + 1;
            if ((counter >= n) || s.equals(""))
            {
                Utils.printIfNotEmpty(topLine);
                System.out.println();
                topLine = "";
                counter = 0;
                if (s.equals(""))
                    continue;
            }
            topLine = topLine + s + " ";
        }
        System.out.println(topLine);
        System.out.println();
    }

    public void printPDF(int n)
    {
        Document document;
        document = new Document();

        MadPrompt p;
        Stack<MadPrompt> p2 = new Stack<MadPrompt>();
        String madWordCheck, madWord, definition;
        String topLine = "";
        String bottomLine = "";
        int wordLenght, j, counter = 0;

        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("madword.pdf"));
            document.open();

            while (!prompts.isEmpty())
            {
                p = prompts.pop();
                p2.push(p);
            }

            for (String s : story)
            {
                wordLenght = s.length();

                counter = counter + wordLenght + 1;

                if ((counter >= n) || s.equals(""))
                {
                    document.add(new Paragraph(topLine, new Font(FontFamily.COURIER , 11)));
                    document.add(new Paragraph(bottomLine, new Font(FontFamily.COURIER, 11)));
                    document.add(new Paragraph());
                    topLine = "";
                    bottomLine = "";
                    counter = 0;
                    if (s.equals(""))
                        continue;
                }
                madWord = MadUtils.getMadWord(s);
                if (madWord != null) // it is a madword
                {
                    madWordCheck = s.substring(wordLenght - 1);
                    p = p2.pop();
                    definition = p.getPrompt();

                    if (madWordCheck.equals("]"))
                    {
                        topLine = topLine + Utils.replaceStrWithUnderscores(definition) + " ";
                        bottomLine = bottomLine + definition + " ";
                    }
                    else
                    {
                        topLine = topLine + Utils.replaceStrWithUnderscores(definition) + madWordCheck + " ";
                        bottomLine = bottomLine + definition + " " + " "; // needs an extra space for the punctuaution
                    }
                }
                else
                {
                    topLine = topLine + s + " ";
                    for (j = 0; j <= wordLenght; j++)
                    {
                        bottomLine = bottomLine + " ";
                    }
                }
            }

            document.add(new Paragraph(topLine, new Font(FontFamily.COURIER, 11)));
            document.add(new Paragraph(bottomLine, new Font(FontFamily.COURIER, 11)));
            document.add(new Paragraph());

            document.close();
            writer.close();
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public String toString()
    {
        String text = "";
        
        text = "A MadStory for the MadLibs game";
        return text;
    }

}
