package hw5;

import java.awt.*;
/**
 * This class draws a filled hat.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class HatPG extends PositionalGraphic
{
    private HalfCirclePG crown = new HalfCirclePG();
    private RectanglePG brim = new RectanglePG();
    
    public HatPG()
    {
        super();
        reCalcDimensions();
    }
    
    public HatPG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint, w, h, c);
        crown.setColor(c);
        brim.setColor(c);
        reCalcDimensions();
    }
    public HatPG(int centerX, int centerY, int w, int h, Color c)
    {
        super(centerX, centerY, w, h, c);
        crown.setColor(c);
        brim.setColor(c);
        reCalcDimensions();
    }
    
    public void paint(Graphics g)
    {     
        super.paint(g);
        crown.paint(g);
        brim.paint(g);
    }
    private void reCalculateLocation()
    {
        int x, y, h, w;
        h = getHeight();
        w = getWidth();        
        x = getTopLeft().x;
        y = getTopLeft().y;
        
        crown.setTopLeft(new Point(x + (int)(w * 0.1) ,  y));
        brim.setTopLeft(new Point(x, (y + (int)(h * 0.8))));
    }
    private void reCalculateSizes()
    {
        int h, w;
        h = getHeight();
        w = getWidth();
        crown.setShapeSize((int)(w * 0.8) , (int)(h * 0.8));
        brim.setHeight((int)(h * 0.2));
        brim.setWidth(w);
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
        crown.setColor(c);
        brim.setColor(c);
    }
    public void setColor(String colorString)
    {
        super.setColor(colorString);
        crown.setColor(colorString);
        brim.setColor(colorString);
    }
    
    public String toString()
    {
        return "Hat bounded in " + super.toString();
    }
}
