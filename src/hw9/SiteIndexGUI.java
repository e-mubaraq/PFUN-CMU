package hw9;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import javax.swing.*;


/**
 * This class represents the GUI for the site
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class SiteIndexGUI extends LayoutGUI
{
    private JEditorPane wordPane, exPane;
    private JTextField enteredURL;
    private WebCrawler web = new WebCrawler();
    private IndexGenerator indexG = new IndexGenerator(web);
    
    public void addComponents(JFrame theFrame)
    {
        JButton genIndexButton, returnToWordButton, returnToExampleButton;        
        JScrollPane scroll, exampleScroll;         
        JPanel urlPanel = new JPanel();
        JPanel scPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        
        enteredURL= new JTextField("http://public.africa.local.cmu.edu/cbishop/pfun/");
        
        genIndexButton = new JButton("Generate Index");
        returnToWordButton = new JButton("Return to Index");
        returnToExampleButton = new JButton("Return to Examples");
        
        wordPane = new JEditorPane();
        wordPane.setPreferredSize(new Dimension(500, 800));
        
        exPane = new JEditorPane();
        
        scroll = new JScrollPane(wordPane);
        exampleScroll = new JScrollPane(exPane);
        
        wordPane.setEditable(false);
        exPane.setEditable(false);
        
        Container c = theFrame.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.WHITE);
        
        urlPanel.setLayout(new FlowLayout());
        urlPanel.add(returnToWordButton);
        urlPanel.add(enteredURL);
        urlPanel.add(genIndexButton);    
        urlPanel.add(returnToExampleButton);
        
        scPanel.setLayout(new GridLayout(1, 1));
        scPanel.add(scroll);
        scPanel.add(exampleScroll);
        
        mainPanel.setLayout(new BorderLayout(50,50));
        mainPanel.add(urlPanel, BorderLayout.NORTH);
        mainPanel.add(scPanel, BorderLayout.CENTER);        
        c.add(mainPanel);        
        
        wordPane.addHyperlinkListener(new LinkListener(wordPane));
        exPane.addHyperlinkListener(new LinkListener(exPane));
        
        // Using anonynmous class
        genIndexButton.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e)
            {
                generateIndex();
            }
        }
        );
         
        returnToWordButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String wordFName = indexG.getWordsIndexFile();
                    indexG.writeWordFile(wordFName);
                    File wordFile = new File(wordFName);
                    wordPane.setPage(wordFile.toURI().toURL());
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
            }
        }
        );
        
        returnToExampleButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String exampleFName = indexG.getExampleIndexFile();
                    web.writeFile(exampleFName);
                    File f = new File(exampleFName);
                    exPane.setPage(f.toURI().toURL());
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                
            }
        }
        );  
    }

    public void generateIndex()
    {
        String exampleFName, wordFName;
        try
        {
            HTMLLink.baseURL = enteredURL.getText();
            indexG.setStartURL(enteredURL.getText());
            exampleFName = indexG.getExampleIndexFile();
            wordFName = indexG.getWordsIndexFile();
            File f = new File(exampleFName);
            File wordF= new File(wordFName);
            
            web.parseHtml(enteredURL.getText());
            web.parseMoreHTML();
            web.writeFile(exampleFName);
            exPane.setPage(f.toURI().toURL());
            

            indexG.parseWords();
            indexG.writeWordFile(wordFName);
            wordPane.setPage(wordF.toURI().toURL());
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    
}
