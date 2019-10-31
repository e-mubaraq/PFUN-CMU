package hw6;
import java.awt.*;

/**
 * This class draws a bounded rectangle for all shapes.
 * @author Mubarak Mikail
 * @author Endegenaamare Taye
 * 
 * Andrew ID: mmikail 
 * Andrew ID: tendegen
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class PositionalGraphic extends Canvas
{
    private Rectangle boundRect;
    private boolean debug;
    private Color color;
    
    
    public PositionalGraphic()
    {
        boundRect = new Rectangle(30, 100, 200, 200);
        debug = false;
    }
    
    public PositionalGraphic(Point centerPoint, int w, int h, Color c)
    {
        int tLeftX, tLeftY;
        tLeftX = centerPoint.x - (w / 2);
        tLeftY = centerPoint.y - (h / 2);
        
        boundRect = new Rectangle(tLeftX, tLeftY, w , h);
        color = c;
    }
    public PositionalGraphic(Point centerPoint, int w, int h, Color c, boolean b)
    {
        int tLeftX, tLeftY;
        tLeftX = centerPoint.x - (w / 2);
        tLeftY = centerPoint.y - (h / 2);
        
        boundRect = new Rectangle(tLeftX, tLeftY, w , h);
        color = c;
        debug = b;
    }
    public PositionalGraphic(int centerX, int centerY, int width, int height)
    {
        int tLeftX, tLeftY;
        tLeftX = centerX - (width / 2);
        tLeftY = centerY - (height / 2);
        
        boundRect = new Rectangle(tLeftX, tLeftY, width , height);
    }
    public PositionalGraphic(int centerX, int centerY, int width, int height,Color c)
    {
        int tLeftX, tLeftY;
        tLeftX = centerX - (width / 2);
        tLeftY = centerY - (height / 2);
        
        boundRect = new Rectangle(tLeftX, tLeftY, width , height);
        color = c;
    }
    public PositionalGraphic(int width, int height, Color c)
    {
        boundRect = new Rectangle(width , height);
        debug = true;
        color = c;
    }
    public PositionalGraphic(int width, int height)
    {
        boundRect = new Rectangle(width , height);
    }
    
    //get methods
    public Rectangle getBoundRect()
    {
        return boundRect;
    }
    public boolean isDebug()
    {
        return debug;
    }
    
    public Color getColor()
    {
        return color;
    }
    public int getWidth()
    {
        return boundRect.width;
    }
    public int getHeight()
    {
        return boundRect.height;
    }
    public Point getTopLeft()
    {
        return new Point(boundRect.getLocation());
    }
    public Point getTopRight()
    {
        int topRightX = getTopLeft().x + getWidth();
        int topRightY = getTopLeft().y;
        
        return new Point(topRightX, topRightY);
    }
    public Point getBottomRight()
    {
        int botRX = getTopRight().x;
        int botRY = getTopLeft().y + getHeight();
        
        return new Point(botRX, botRY);
    }
    public Point getBottomLeft()
    {
        int botLX = getTopLeft().x;
        int botLY = getBottomRight().y;
        
        return new Point(botLX, botLY);
    }
    public Point getMidTop()
    {
        int midtX = getTopLeft().x + (getWidth() / 2);
        int midtY = getTopLeft().y;
        
        return new Point(midtX, midtY);
    }
    public Point getMidBottom()
    {
        int midBX = getMidTop().x;
        int midBY = getBottomLeft().y;
        
        return new Point(midBX, midBY);
    }
    public Point getMidLeft()
    {
        int midLX = getTopLeft().x;
        int midLY = getTopLeft().y + (getHeight() / 2);
        
        return new Point(midLX, midLY);
    }
    public Point getMidRight()
    {
        int midRX = getTopRight().x;
        int midRY = getMidLeft().y;
        
        return new Point(midRX, midRY);
    }
    public Point getCenterPoint()
    {
        int centerX = getMidTop().x;
        int centerY = getMidLeft().y;
        
        return new Point(centerX, centerY);
    }
 
    
    public void setBoundRect(Rectangle r)
    {
        boundRect = r;
    }
    public void setDebug(boolean bool)
    {
        debug = bool;
    }
    public void setColor(Color c)
    {
        color = c;
    }
    public void setColor(String colorString)
    {
        color = ColorConverter.getColor(colorString);
    }
    
    @Override
    public void paint(Graphics g)
    {
        Point topLeft = boundRect.getLocation();
        if (debug)
        {
            g.setColor(Color.RED);
            g.drawRect(topLeft.x, topLeft.y, getWidth(), getHeight());
        }
    }
    // set methods 
    public void setTopLeft(Point tL)
    {
        boundRect.setLocation(tL.x, tL.y);
    }
    public void setTopRight(Point tR)
    {
        int x = tR.x - boundRect.width;
        int y = tR.y;
        boundRect.setLocation(x, y);
    }
    public void setBottomRight(Point bR)
    {
        int x = bR.x - boundRect.width;
        int y = bR.y - boundRect.height;
        boundRect.setLocation(x, y);
    }
    public void setBottomLeft(Point bL)
    {
        int x = bL.x;
        int y = bL.y - boundRect.height;
        boundRect.setLocation(x, y);
    }
    public void setMidRight(Point mR)
    {
        int x = mR.x - boundRect.width;
        int y = mR.y - boundRect.height / 2;
        boundRect.setLocation(x, y);
    }
    public void setMidLeft(Point mL)
    {
        int x = mL.x;
        int y = mL.y - boundRect.height / 2;
        boundRect.setLocation(x, y);
    }
    public void setMidTop(Point mT)
    {
        int x = mT.x - boundRect.width / 2;
        int y = mT.y;
        boundRect.setLocation(x, y);
    }
    public void setMidBottom(Point mB)
    {
        int x = mB.x - boundRect.width / 2;
        int y = mB.y - boundRect.height;
        boundRect.setLocation(x, y);
    }
    
    public void setCenter(Point centerPoint)
    {
        int x = centerPoint.x - boundRect.width / 2;
        int y = centerPoint.y - boundRect.height / 2;
        boundRect.setLocation(x, y);
    }
    public void setHeight(int h)
    {
        boundRect.setSize(boundRect.width, h);
    }
    public void setWidth(int w)
    {
        boundRect.setSize(w, boundRect.height);
    }
    public void setShapeSize(int w, int h)
    {
        boundRect.setSize(w, h);
    }
    
    public String toString()
    {
        return "Positional Graphic with bounded rectangle of " + getWidth() + " width and " + getHeight() + " height drawn from " + getTopLeft();
    }
}
