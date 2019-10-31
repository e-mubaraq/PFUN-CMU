package hw5;

import java.awt.*;
/**
 * This class draws a filled half circle.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class HalfCirclePG extends PositionalGraphic
{
  
    public HalfCirclePG()
    {
        super();
    }
    public HalfCirclePG(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public HalfCirclePG(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }
    public HalfCirclePG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint , w ,h, c);
    }
    public HalfCirclePG(Point centerPoint, int w, int h, Color c, boolean b)
    {
        super(centerPoint , w ,h, c, b);
    }
    public HalfCirclePG(int w, int h)
    {
        super(w, h);
    }
    public HalfCirclePG(int w, int h, Color c)
    {
        super(w, h, c);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(getColor());
        g.fillArc(getTopLeft().x, getTopLeft().y, getWidth(), getHeight() * 2, 0, 180);
    }
    
    public String toString()
    {
        return super.toString() + " An half-circle of width: " + getWidth() + " and height: " + getHeight();
    }
}
