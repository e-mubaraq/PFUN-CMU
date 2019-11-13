package GUI;
import java.awt.*;  // import the AWT graphic classes
import javax.swing.*;   // import the Swing classes

public class BetterGUI extends LayoutGUI
{
public void addComponents (JFrame theFrame)
{
    JLabel  l1  = new JLabel("Enter your name: ");
    JLabel  l2  = new JLabel("Things to do for a GUI");
    JLabel  l3  = new JLabel(" or ");

    JPanel  namePanel = new JPanel();
    JPanel  typePanel = new JPanel();
    JPanel  layoutPanel = new JPanel();
    JPanel  stepsPanel = new JPanel();
    JPanel  topPanel = new JPanel();
    JPanel  bottomPanel = new JPanel();

    JComboBox<String> comboLayout = new JComboBox<String>();
    comboLayout.setToolTipText("Select a Layout Manager");
    //comboLayout.setMaximumRowCount(2);
    comboLayout.addItem("Flow");
    comboLayout.addItem("Grid");
    comboLayout.addItem("Border");
    comboLayout.addItem("Box");
    comboLayout.addItem("Spring");

    JTextArea   notes = new JTextArea(5, 40);
    JScrollPane scrollNotes = new JScrollPane(notes);

    JButton okButton = new JButton("OK");

    ButtonGroup radioGroup = new ButtonGroup();
    JRadioButton appletRadio;
    JRadioButton frameRadio;

    Container c = theFrame.getContentPane();

    c.setLayout(new FlowLayout());
    c.setBackground(Color.white);

    namePanel.setLayout(new FlowLayout());
    namePanel.setBackground(Color.WHITE);
    namePanel.add(l1);
    namePanel.add(new JTextField(25));

    typePanel.setLayout(new FlowLayout());
    typePanel.setBackground(Color.WHITE);
    typePanel.add(l2);

    // radio buttons have 2 steps: 1. Logically group them 2. add to the Frame or Panel

    appletRadio = new JRadioButton("Applet", false);
    frameRadio = new JRadioButton("Frame", false);
    radioGroup.add(appletRadio);
    radioGroup.add(frameRadio);
    typePanel.add(appletRadio);
    typePanel.add(l3);
    typePanel.add(frameRadio);

    layoutPanel.setLayout(new GridLayout(1,2));
    layoutPanel.setBackground(Color.WHITE);
    layoutPanel.add(new JCheckBox("Set layout manager"));
    layoutPanel.add(comboLayout);

    stepsPanel.setLayout(new GridLayout(2,2));
    stepsPanel.setBackground(Color.WHITE);
    stepsPanel.add(new JCheckBox("Create components"));
    stepsPanel.add(new JCheckBox("Get content pane"));
    stepsPanel.add(new JCheckBox("Add components"));
    stepsPanel.add(new JCheckBox("Handle component events"));

    topPanel.setLayout(new GridLayout(4,1));

    topPanel.add(namePanel);
    topPanel.add(typePanel);
    topPanel.add(layoutPanel);
    topPanel.add(stepsPanel);

    c.add(topPanel);
    c.add(scrollNotes);
    c.add(okButton);
}
}

