package hw5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * This class holds shapes to be filled.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */
public class HoldShapes extends PositionalGraphic
{

// The ArrayList shapes holds a list of all your shapes. Look at what paint() does.

ArrayList<PositionalGraphic> shapes = new ArrayList<PositionalGraphic>();

// Note: this is an instance variable so addScoop() can access it. Make sure you instantiate it.

IceCreamConePG iceCreamCone;

public HoldShapes()
{
    int w,h;
    w = getWidth();
    h = getHeight();
    // Instantiate each of your PG objects. Use your setters to set each one up. Then add each
    // of them to your shapes ArrayList.

    //------------ You write the code ----------------
    
    RectanglePG rectangle = new RectanglePG();
    rectangle.setTopLeft(getTopLeft());
    rectangle.setShapeSize(w, h);
    rectangle.setColor(Color.BLUE);
    
    
    TrianglePG triangle = new TrianglePG();
    triangle.setTopLeft(new Point(rectangle.getTopRight().x + 50 , triangle.getTopRight().y));
    triangle.setShapeSize(w, h);
    triangle.setColor(Color.RED);
    
    OvalPG oval = new OvalPG();
    oval.setTopLeft(new Point(triangle.getTopRight().x + 50 , triangle.getTopRight().y));
    oval.setShapeSize(w, h);
    oval.setColor("PURPLE");
    
    
    DiamondPG diamond = new DiamondPG();
    diamond.setTopLeft(new Point(oval.getTopRight().x + 50 , triangle.getTopRight().y));
    diamond.setShapeSize(w, h);
    diamond.setColor(Color.CYAN);
    
    
    HalfCirclePG halfCircle = new HalfCirclePG();
    halfCircle.setTopLeft(new Point(rectangle.getBottomLeft().x , rectangle.getBottomLeft().y + 50));
    halfCircle.setShapeSize(w, h);
    halfCircle.setColor(Color.GREEN);
    
    
    HatPG hat = new HatPG();
    hat.setTopLeft(new Point(halfCircle.getTopRight().x + 50 , rectangle.getBottomLeft().y + 50));
    hat.setShapeSize(w, h);
    hat.setColor(Color.MAGENTA);
    
    iceCreamCone = new IceCreamConePG();
    iceCreamCone.setTopLeft(new Point(hat.getTopRight().x + 50 , rectangle.getBottomLeft().y + 50));
    iceCreamCone.setShapeSize(w, h);
    iceCreamCone.setColor(Color.YELLOW);
    
    
    HeartPG heart = new HeartPG();
    heart.setTopLeft(new Point(iceCreamCone.getTopRight().x + 50 , rectangle.getBottomLeft().y + 50));
    heart.setShapeSize(w, h);
    heart.setColor(Color.PINK);
   
    
    shapes.add(rectangle);
    shapes.add(triangle);
    shapes.add(oval);
    shapes.add(halfCircle);
    shapes.add(diamond);
    shapes.add(hat);
    shapes.add(iceCreamCone);
    shapes.add(heart);
}

public void addScoop(String color)
{
    
    //------------ You write the code ----------------
    iceCreamCone.addScoop(color);
    // Call addScoop() in your IceCreamConePG class that takes the color for the new scoop.
}

@Override
public void paint(Graphics g)
{
    // This code loops through and paints all of the shapes.
    for (PositionalGraphic shape:shapes)
    {
        shape.paint(g);
    }
}
public String toString()
{   
    return "A structure that contains multiple shapes";
}

}

