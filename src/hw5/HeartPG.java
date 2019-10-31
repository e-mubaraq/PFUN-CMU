package hw5;

import java.awt.*;
/**
 * This class draws a filled Ice cream.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class HeartPG extends PositionalGraphic
{

    private TrianglePG triangle = new TrianglePG();
    private HalfCirclePG ovalLeft = new HalfCirclePG();
    private HalfCirclePG ovalRight = new HalfCirclePG();
    
    public HeartPG()
    {
        super();
        reCalcDimensions();
    }
    public HeartPG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint, w, h, c);
        reCalcDimensions();
    }
    public HeartPG(int centerX, int centerY, int w, int h, Color c)
    {
        super(centerX, centerY, w, h, c);
        reCalcDimensions();
    }
    public void paint(Graphics g)
    {        
        super.paint(g);
        triangle.setDown();
        triangle.paint(g);
        ovalLeft.paint(g);
        ovalRight.paint(g);
    }
    
    private void reCalculateLocation()
    {
        int x, y, h, w;
        h = getHeight();
        w = getWidth();        
        x = getTopLeft().x;
        y = getTopLeft().y;
        
        triangle.setTopLeft(new Point(x , y + (int)(h * 0.25)));
        ovalLeft.setTopLeft(new Point(x , y));
        ovalRight.setTopLeft(new Point(x + (int)(w * 0.5) , y));
    }
    private void reCalculateSizes()
    {
        int h, w;
        h = getHeight();
        w = getWidth();
               
        triangle.setShapeSize(w, (int)(h * 0.75));
        ovalLeft.setShapeSize((int)(w * 0.5) , (int)(h * 0.25));
        ovalRight.setShapeSize((int)(w * 0.5) , (int)(h * 0.25));
    }
    private void reCalcDimensions()
    {
        reCalculateSizes();
        reCalculateLocation();
    }
    
    public void setBoundRect(Rectangle r)
    {
        super.setBoundRect(r);
        reCalcDimensions();
    }
    public void setCenter(Point centerPoint)
    {
        super.setCenter(centerPoint);
        reCalculateLocation();
    }
    public void setTopLeft(Point tL)
    {
        super.setTopLeft(tL);
        reCalculateLocation();
    }
    public void setBottomLeft(Point bL)
    {
        super.setBottomLeft(bL);
        reCalculateLocation();
    }
    public void setWidth(int w)
    {
        super.setWidth(w);
        reCalculateSizes();
    }
    public void setHeight(int h)
    {
        super.setHeight(h);
        reCalculateSizes();
    }
    public void setShapeSize(int w, int h)
    {
        super.setShapeSize(w, h);
        reCalculateSizes();
    }
    public void setColor(Color c)
    {
        super.setColor(c);
        triangle.setColor(c);
        ovalLeft.setColor(c);
        ovalRight.setColor(c);
    }
    public void setColor(String colorString)
    {
        super.setColor(colorString);
        triangle.setColor(colorString);
        ovalLeft.setColor(colorString);
        ovalRight.setColor(colorString);
    }
    
    
    public String toString()
    {
        return "Heart bounded in " + super.toString();
    }
}
