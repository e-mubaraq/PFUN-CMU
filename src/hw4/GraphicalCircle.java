package hw4;
import java.awt.*;
import javax.swing.*;

/**
 * This class uses the Graphics class to draw a circle.
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

public class GraphicalCircle extends JPanel
{
    private Point centerPoint;
    private int diameter;
    private Color color;

    public GraphicalCircle()
    {
        centerPoint = new Point(150, 200);
        diameter = 200;
        color = Color.blue;
    }

    public GraphicalCircle(Point p, int d)
    {
        centerPoint = new Point(p);
        diameter = d;
    }

    public GraphicalCircle(Point p, int d, Color c)
    {
        centerPoint = new Point(p);
        diameter = d;
        color = c;
    }

    public Point getCenter()
    {
        return new Point(centerPoint);
    }

    public int getDiameter()
    {
        return diameter;
    }

    public Color getColor()
    {
        return color;
    }

    public void setCenter(Point cPoint)
    {
        centerPoint = cPoint;
    }

    public void setDiameter(int newDiameter)
    {
        diameter = newDiameter;
    }

    public void setColor(Color c)
    {
        color = c;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawCircle(g, centerPoint, diameter);
    }

    public void drawCircle(Graphics g, Point centerPoint, int diameter)
    {
        int centerX;
        int centerY;
        int topLeftX;
        int topLeftY;

        centerX = centerPoint.x;
        centerY = centerPoint.y;
        topLeftX = centerX - (diameter / 2);
        topLeftY = centerY - (diameter / 2);
        g.setColor(color);
        g.fillOval(topLeftX, topLeftY, diameter, diameter);
    }

    public String toString()
    {
        String text = " A circle of diameter " + diameter + " starting at coordinates (" + centerPoint.x + ", "
                + centerPoint.y + ")";

        return text;
    }

}
