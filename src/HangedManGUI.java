import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HangedManGUI extends LayoutGUI implements StringHandler
{
    private ArrayList<SingleUseButton> letterButtons;
    SingleUseButton replayButton;
    HangedMan hMan;
    private JSecretString phrase;
    
    private int numOfWins = 0;
    private int numOfLoss = 0;
    private int numOfGames = 0;
    
    private JLabel numWins = new JLabel(String.valueOf(numOfWins));
    private JLabel numLost = new JLabel(String.valueOf(numOfLoss));
    private JLabel numGames = new JLabel(String.valueOf(numOfGames));
    

    public void processString(String text)
    {
        int i;
        
        if (text.equalsIgnoreCase("Replay"))
        {
            for (i = 0; i < letterButtons.size(); i++ )
                letterButtons.get(i).setEnabled(true); 
            phrase.setSecretPhrase("Ballack");
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
                System.out.println("You won this round");
            }
            
            if (phrase.isUncovered())            
            {
                numOfWins++;
                System.out.println("You lost this round");
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

        phrase = new JSecretString("Mubarak!!!");
        
        JPanel mainPanel = new JPanel();
        JPanel hangedManPanel = new JPanel();
        JPanel gameLabelPanel = new JPanel();
        JPanel letterButtonPanel = new JPanel();
        JPanel stringShowPanel = new JPanel();

        
        Container c = theFrame.getContentPane();
        hMan = new HangedMan(300, 400);       
        replayButton = new SingleUseButton("Replay", this);
        letterButtons = SingleUseButton.getLetterButtons(this);


        
        gameLabelPanel.setLayout(new GridLayout(3, 2));
        //gameLabelPanel.setBackground(Color.WHITE);
        gameLabelPanel.add(lGames);
        gameLabelPanel.add(numGames);
        gameLabelPanel.add(won);
        gameLabelPanel.add(lost);
        gameLabelPanel.add(numWins);
        gameLabelPanel.add(numLost);
        
        hangedManPanel.setLayout(new BorderLayout());
        hangedManPanel.setBackground(Color.CYAN);
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
