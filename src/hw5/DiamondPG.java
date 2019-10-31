package hw5;

import java.awt.*;
/**
 * This class draws a filled diamond.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class DiamondPG extends PositionalGraphic
{

    public DiamondPG()
    {
        super();
    }
    public DiamondPG(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    public DiamondPG(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
    }
    public DiamondPG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint , w ,h, c);
    }
    public DiamondPG(Point centerPoint, int w, int h, Color c, boolean b)
    {
        super(centerPoint , w ,h, c, b);
    }
    public DiamondPG(int w, int h)
    {
        super(w, h);
    }
    public DiamondPG(int w, int h, Color c)
    {
        super(w, h, c);
    }
    
    
    public void paint(Graphics g)
    {
        int mLX, mLY, mRX, mRY, mTX, mTY, mBX, mBY;
        mLX = getMidLeft().x;
        mLY = getMidLeft().y;
        mRX = getMidRight().x;
        mRY = getMidRight().y;
        mTX = getMidTop().x;
        mTY = getMidTop().y;
        mBX = getMidBottom().x;
        mBY = getMidBottom().y;
        
        int [] xPoints = {mLX, mTX, mRX, mBX};
        int [] yPoints = {mLY, mTY, mRY, mBY};

        super.paint(g);
        g.setColor(getColor());
        g.fillPolygon(xPoints, yPoints, 4);
    }
  
    public String toString()
    {
     return super.toString() + " A Diamond of width: " + getWidth() + " and height: " + getHeight();
    }
    
}
