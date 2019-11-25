import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;

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

    public void addComponents(JFrame theFrame)
    {
        String fname = "out.hml";
        OutputDataFile out = new OutputDataFile(fname);
        JTextField enteredURL;
        JButton genIndexButton, returnButton, returnExample;
        JEditorPane editPane, exPane;
        JScrollPane scroll, exampleScroll;
         
        JPanel urlPanel = new JPanel();
        JPanel scPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        
        enteredURL= new JTextField("http://public.africa.local.cmu.edu/cbishop/pfun/index.html");
        //enteredURL= new JTextField("http://testExamples.html");
        genIndexButton = new JButton("Generate Index");
        returnButton = new JButton("Return to Index");
        returnExample = new JButton("Return to Examples");
        
        editPane = new JEditorPane();
        editPane.setPreferredSize(new Dimension(500, 800));
        
        exPane = new JEditorPane();
        
        scroll = new JScrollPane(editPane);
        exampleScroll = new JScrollPane(exPane);
        
        editPane.setEditable(false);
        exPane.setEditable(false);
        
        Container c = theFrame.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.WHITE);
        
        urlPanel.setLayout(new GridLayout(1, 2));
        urlPanel.add(returnButton);
        urlPanel.add(enteredURL);
        urlPanel.add(genIndexButton);    
        urlPanel.add(returnExample);
        
        scPanel.setLayout(new GridLayout(1, 1));
        scPanel.add(scroll);
        scPanel.add(exampleScroll);
        
        mainPanel.setLayout(new BorderLayout(50,50));
        mainPanel.add(urlPanel, BorderLayout.NORTH);
        mainPanel.add(scPanel, BorderLayout.CENTER);
        
        c.add(mainPanel);        
        
        // Using anonynmous class
        genIndexButton.addActionListener(new ActionListener()
        {  
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    editPane.setPage(enteredURL.getText());
                    exPane.setPage(enteredURL.getText());
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                editPane.addHyperlinkListener(new LinkListener(editPane));
                exPane.addHyperlinkListener(new LinkListener(exPane));
            }
        }
        );
         
        returnButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    editPane.setPage(enteredURL.getText());
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                
            }
        }
        );
        returnExample.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    exPane.setPage(enteredURL.getText());                  
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                
            }
        }
        );
        
    }

    
}
