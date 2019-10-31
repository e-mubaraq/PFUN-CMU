package hw6;

/**
 * This class implements a bouncer interface for an Oval shape.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MmikailBouncer2 extends OvalPG implements Bouncer
{
    public void move()
    {
        setXAndY(getTopRight().x + 100, getTopRight().y + 100);
    }
    
    public void setShapeX(int x)
    {
        setTopLeft(new Point(x , getTopLeft().y));
    }
    
    public void setShapeY(int y)
    {
        setTopLeft(new Point(getTopLeft().x , y));
    }
    
    public void setXAndY(int x, int y)
    {
        Point p = new Point(x , y);
        setTopLeft(p);
    }
    
    public Point getBottomRightPoint()
    {
        return getBottomRight();

    }
    public String toString()
    {
        return "An oval bouncing from " + getTopLeft();
    }
       
}
