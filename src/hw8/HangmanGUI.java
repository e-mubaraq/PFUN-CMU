package hw8;
/**
 * This class represents the GUI for an Hangman game
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class HangmanGUI extends LayoutGUI implements StringHandler
{
    private ArrayList<SingleUseButton> letterButtons;
    private PhraseList listOfPhrases;
    private SingleUseButton replayButton;
    private HangedMan hMan;
    private JSecretString phrase;
    private String filename, randomPhrase;;
    
    private int numOfWins = 0;
    private int numOfLoss = 0;
    private int numOfGames = 0;
    
    private JLabel numWins = new JLabel(String.valueOf(numOfWins));
    private JLabel numLost = new JLabel(String.valueOf(numOfLoss));
    private JLabel numGames = new JLabel(String.valueOf(numOfGames));
    
    public HangmanGUI()
    {
        filename = "names.txt";
        listOfPhrases = new PhraseList(filename);
        randomPhrase = listOfPhrases.getRandomPhrase();
    }

    public HangmanGUI(String file)
    {
        File f = new File(file);
        if (!f.exists())
        {
            file = "names.txt";
        }
        filename = file;
        listOfPhrases = new PhraseList(file);
        randomPhrase = listOfPhrases.getRandomPhrase();
    }
    
    public void setPhraseList(String file)
    {
        File f = new File(file);
        if (!f.exists())
        {
            file = "names.txt";
        }
        filename = file;
        listOfPhrases = new PhraseList(file);
        randomPhrase = listOfPhrases.getRandomPhrase();
    }
    public void processString(String text)
    {
        int i;
        
        if (text.equalsIgnoreCase("Replay"))
        {
            for (i = 0; i < letterButtons.size(); i++ )
                letterButtons.get(i).setEnabled(true); 
            phrase.setSecretPhrase(listOfPhrases.getRandomPhrase());
            hMan.reset();
            return;
        }

        if (phrase.reveal(text) == 0)
        {
            hMan.addBodyPart();
            hMan.repaint();
        }
        
        if (hMan.isHanged() || phrase.isUncovered())
        {
            for (i = 0; i < letterButtons.size(); i++ )
                letterButtons.get(i).setEnabled(false);
            if (hMan.isHanged())
            {
                phrase.unCoverAll();
                numOfLoss++;
            }
            
            if (phrase.isUncovered())            
            {
                numOfWins++;
            }
            numOfGames++;
            numWins.setText(String.valueOf(numOfWins));
            numLost.setText(String.valueOf(numOfLoss));
            numGames.setText(String.valueOf(numOfGames));
            replayButton.setEnabled(true);
            return;
        }
    }

    public void addComponents(JFrame theFrame)
    {
        int i;
        JLabel lGames = new JLabel("Games: ");
        JLabel won = new JLabel("<html><u>WON</u></html>");
        JLabel lost = new JLabel("<html><u>LOST</u></html>");

        phrase = new JSecretString(randomPhrase);
        phrase.setFont(new Font("SANS_SERIF", 12, 30));
        
        JPanel mainPanel = new JPanel();
        JPanel hangedManPanel = new JPanel();
        JPanel gameLabelPanel = new JPanel();
        JPanel gPanel = new JPanel();
        JPanel letterButtonPanel = new JPanel();
        JPanel stringShowPanel = new JPanel();

        
        Container c = theFrame.getContentPane();
        hMan = new HangedMan(300, 400);       
        replayButton = new SingleUseButton("Replay", this);
        letterButtons = SingleUseButton.getLetterButtons(this);


        gPanel.setLayout(new GridLayout(2, 2));
        gPanel.setBackground(Color.WHITE);
        gPanel.add(won);
        gPanel.add(lost);
        gPanel.add(numWins);
        gPanel.add(numLost);
        
        gameLabelPanel.setLayout(new GridLayout(2, 2));
        gameLabelPanel.setBackground(Color.WHITE);
        gameLabelPanel.add(lGames);
        gameLabelPanel.add(numGames);
        gameLabelPanel.add(gPanel);

        
        hangedManPanel.setLayout(new BorderLayout());
        hangedManPanel.setBackground(Color.ORANGE);
        hangedManPanel.add(hMan);
        
        c.setLayout(new FlowLayout());
        c.setBackground(Color.WHITE);
        
        letterButtonPanel.setLayout(new GridLayout(3, 9));
        for (i = 0; i < letterButtons.size(); i++ )
            letterButtonPanel.add(letterButtons.get(i));
        letterButtonPanel.add(replayButton);
        replayButton.setEnabled(false);
        
        stringShowPanel.setLayout(new FlowLayout());
        stringShowPanel.add(phrase);
        
        mainPanel.setLayout(new BorderLayout(50,50));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.add(hangedManPanel , BorderLayout.EAST);
        mainPanel.add(letterButtonPanel, BorderLayout.SOUTH);
        mainPanel.add(gameLabelPanel, BorderLayout.WEST);
        mainPanel.add(phrase, BorderLayout.CENTER);
        
        c.add(mainPanel);
    }
    
}
