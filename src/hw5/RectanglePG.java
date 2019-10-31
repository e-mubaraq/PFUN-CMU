package hw5;
import java.awt.*;

/**
 * This class draws a filled rectangle.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class RectanglePG extends PositionalGraphic
{  
    public RectanglePG()
    {
        super();
    }
    public RectanglePG(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public RectanglePG(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }
    public RectanglePG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint , w ,h, c);
    }
    public RectanglePG(Point centerPoint, int w, int h, Color c, boolean b)
    {
        super(centerPoint , w ,h, c, b);
    }
    public RectanglePG(int w, int h)
    {
        super(w, h);
    }
    public RectanglePG(int w, int h, Color c)
    {
        super(w, h, c);
    }

    public void paint(Graphics g)
    {  
        super.paint(g);
        g.setColor(getColor());
        g.fillRect(getTopLeft().x, getTopLeft().y, getWidth(), getHeight());
    }
      
    public String toString()
    {
        return super.toString() + " Rectangle of width: " + getWidth() + " height: " + getHeight();
    }
}
