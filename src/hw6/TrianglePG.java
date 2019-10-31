package hw6;

import java.awt.*;

/**
 * This class draws a filled triangle.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class TrianglePG extends PositionalGraphic
{

    private enum triangleDir {UP, DOWN};
    private triangleDir direction;
    
    public TrianglePG()
    {
        super();
    }
    public TrianglePG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint, w, h, c);
    }
    
    public boolean isUp()
    {
        return direction == triangleDir.UP;
    }
    public boolean isDown()
    {
        return direction == triangleDir.DOWN;
    }
    
    public void setUp()
    {
        direction = triangleDir.UP;
    }
    public void setDown()
    {
        direction = triangleDir.DOWN;
    }
    
    @Override
    public void paint(Graphics g)
    {
        int tLX, tLY, tRX, tRY, bLX, bLY, bRX, bRY, mTX, mTY, mBX, mBY;
        
        tLX = super.getTopLeft().x;
        tLY = super.getTopLeft().y;
        tRX = super.getTopRight().x;
        tRY = super.getTopRight().y;
        bLX = super.getBottomLeft().x;
        bLY = super.getBottomLeft().y;
        bRX = super.getBottomRight().x;
        bRY = super.getBottomRight().y;
        mTX = super.getMidTop().x;
        mTY = super.getMidTop().y;
        mBX = super.getMidBottom().x;
        mBY = super.getMidBottom().y;
        
        int [] xDPoints = {tLX, tRX, mBX};
        int [] yDPoints = {tLY, tRY, mBY};
        int [] xUPoints = {bLX, bRX, mTX};
        int [] yUPoints = {bLY, bRY, mTY};
        
        super.paint(g);
        g.setColor(getColor());
        if (isDown())
            g.fillPolygon(xDPoints, yDPoints, 3);
        else
            g.fillPolygon(xUPoints, yUPoints, 3);
    }
    public String toString()
    {
     return super.toString() + " A triangle of width: " + getWidth() + " and height: " + getHeight();
    }
    
}
