import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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

    public void addComponents(JFrame theFrame)
    {
        JTextField enteredURL;
        JButton genIndexButton;
        JEditorPane editPane;
        JScrollPane scroll;
         
        
        enteredURL= new JTextField("Please enter the starting url");
        genIndexButton = new JButton("Generate Index");
        editPane = new JEditorPane();
        scroll = new JScrollPane(editPane);
        editPane.setEditable(false);
        
        Container c = theFrame.getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.WHITE);
        c.add(enteredURL);
        c.add(genIndexButton);
        c.add(scroll);
        
        
        // Using anonynmous class
        genIndexButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    editPane.setText(enteredURL.getText());  
            }  
            });
    }

    
}
