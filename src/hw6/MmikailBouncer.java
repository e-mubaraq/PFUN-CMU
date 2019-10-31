package hw6;
import java.awt.*;

/**
 * This class implements a bouncer interface for an Ice cream cone shape.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class MmikailBouncer extends IceCreamConePG implements Bouncer
{
    public void move()
    {
        Point p = getTopLeft();   
        setXAndY(p.x + 100, p.y + 100);
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
        return "Ice cream cone bouncing from " + getTopLeft();
    }
}
