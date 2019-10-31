package tests;
import java.awt.*;
import java.util.*;


public class LabelledLine extends TLine
{

    private String label;
    private Color labelColor = Color.BLUE;
    
    public LabelledLine()
    {
        super();
        label = "Labelled Line";
    }
    
    public LabelledLine(String l , LineDirection dir)
    {
        super(dir);
        label = l;
    }
    
    public LabelledLine(String l)
    {
        super();
        label = l;
    }
    
    public String getLabel()
    {
        return label;
    }
    public void setLabel(String s)
    {
        label = s;
    }
    public Color getLabelColor()
    {
        return labelColor;
    }
    public void setLabelColor(Color c)
    {
        labelColor = c;
    }
    
    public String toString()
    {
        return label + " " + super.toString();
    }
    
    public void paintComponent(Graphics g)
    {
        Color saveColor;
        Point p;
        int x, y;
        
        p = getStartPoint();
        x = (int) p.getX();
        y = (int) p.getY();
        
        super.paintComponent(g);
        
        saveColor = g.getColor();
        g.setColor(labelColor);
        g.drawString(label, x, y - 40);
        g.setColor(saveColor);    
    }
}
