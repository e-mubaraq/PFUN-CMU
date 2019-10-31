package hw6;
import java.awt.*;
/**
 * This class draws a filled oval.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class OvalPG extends PositionalGraphic
{
    
    public OvalPG()
    {
        super();       
    }
    public OvalPG(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public OvalPG(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h,c);
    }   
    public OvalPG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint , w ,h, c);
    }
    public OvalPG(Point centerPoint, int w, int h, Color c, boolean b)
    {
        super(centerPoint , w ,h, c, b);
    }
    public OvalPG(int w, int h)
    {
        super(w, h);
    }
    public OvalPG(int w, int h, Color c)
    {
        super(w, h, c);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(getColor());
        g.fillOval(getTopLeft().x, getTopLeft().y, getWidth(),  getHeight());
    }
   public String toString()
   {
       return super.toString() + " An Oval of width: " + getWidth() + " and height: " + getHeight();
   }
    
}
