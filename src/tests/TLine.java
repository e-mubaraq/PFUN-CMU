package tests;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TLine extends JPanel
{

    private int length;
    private int thickness;
    private Point startPoint;
    protected enum LineDirection  {VERTICAL, HORIZONTAL};
    private LineDirection type;
    
    public TLine()
    {
        type = LineDirection.VERTICAL;
        thickness = 50;
        length = 100;
        startPoint = new Point(50,50);       
    }
    
    public TLine(LineDirection dir)
    {
        type = LineDirection.VERTICAL;
        thickness = 50;
        length = 100;
        startPoint = new Point(50,50);       
    }
    /*
     * public TLine(int l, int t, Point s, LineDirection ty) { type = ty; length =
     * l; thickness = t; startPoint = s; }
     */
    
    public int getLength()
    {
        return length;
    }
    
    public int getThickness()
    {
        return thickness;
    }
    
    public Point getStartPoint()
    {
        return new Point(startPoint);
    }
    
    public void setLength(int l)
    {
        length = l;
    }
    public void setThickness(int t)
    {
        thickness = t;
    }
    
    public void setStartPoint(Point sPoint)
    {
        startPoint = sPoint;
    }
    
    public Boolean isHorizontal()
    {
        return type == LineDirection.HORIZONTAL;
    }
    
    public boolean isVertical()
    {
        return type == LineDirection.VERTICAL;
    }
    
    public void setHorizontal()
    {
        type = LineDirection.HORIZONTAL;
    }
    public void setVertical()
    {
        type = LineDirection.VERTICAL;
    }
    
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
        int startX;
        int startY;
        int width;
        int height;
        
        int midX = (int) startPoint.getX();
        int midY = (int) startPoint.getY();
        
        int testLineX2;
        int testLineY2;
        
        if(isHorizontal())
        {
            startX = midX;
            startY = midY - (thickness / 2);
            width = length;
            height = thickness;
            
            testLineX2 = midX + length;
            testLineY2 = midY;
        }
        else
        {
            startX = midX - (thickness / 2);
            startY = midY;
            width = thickness;
            height = length;
            
            testLineX2 = midX;
            testLineY2 = midY + length;
            
        }
        g.setColor(Color.blue);
        g.fillRect(startX,  startY, width, height);
        
        g.setColor(Color.RED);
        g.drawLine(midX, midY, testLineX2, testLineY2);
    }
    public String toString()
    {
        String str = "";
        
        str += type + " line. ";
        str += "Thickness: " + thickness + " Length: " + length;
        str += " (in pixels) ";
        str += "Starts at: " + startPoint + ".";
        
        return str;
    }
    
    
}
