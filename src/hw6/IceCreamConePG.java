package hw6;
import java.awt.*;
import java.util.ArrayList;
/**
 * This class draws a filled Ice cream.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class IceCreamConePG extends PositionalGraphic
{

    private TrianglePG cone = new TrianglePG();
    private ArrayList<OvalPG> scoops = new ArrayList<OvalPG>();
    
    public IceCreamConePG()
    {
        super();
        reCalcDimensions();
    }
    public IceCreamConePG(Point centerPoint, int w, int h, Color c)
    {
        super(centerPoint, w, h, c);
        cone.setColor(c);
        reCalcDimensions();
    }
    public IceCreamConePG(int centerX, int centerY, int w, int h, Color c)
    {
        super(centerX, centerY, w, h, c);
        cone.setColor(c);
        reCalcDimensions();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        cone.setDown();
        cone.paint(g);
        for(OvalPG scoop:scoops)
            scoop.paint(g);
    }
    private void reCalculateLocation()
    {
        int x, y, h, w,n;
        h = getHeight();
        w = getWidth();        
        x = getTopLeft().x;
        y = getTopLeft().y;
        n = scoops.size();
        
        cone.setTopLeft(new Point(x + (int)(w * 0.4), y + (int)(h * 0.5)));
        for(int i = 0; i < n; i++)
        {
            if (i == 0)
                scoops.get(i).setMidBottom(cone.getMidTop());
            else
                scoops.get(i).setMidBottom(scoops.get(i - 1).getMidTop());
        }
    }
    private void reCalculateSizes()
    {
        int h, n;
        h = getHeight();
        n = scoops.size();

        for(int i = 0; i < n; i++)
        {
            cone.setShapeSize((int)(h * 0.5) / n , (int)(h * 0.5));
            scoops.get(i).setShapeSize((int)((h * 0.5) / n), (int)((h * 0.5) / n));
        }
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
        cone.setColor(c);
    }
    public void setColor(String colorString)
    {
        super.setColor(colorString);
        cone.setColor(colorString);
    }
    public void addScoop(Color c)
    {
        OvalPG scoop = new OvalPG();
        super.setColor(c);
        scoop.setColor(c);
        scoops.add(scoop);
        reCalcDimensions();
    }
    public void addScoop(String colorString)
    {
        OvalPG scoop = new OvalPG();
        super.setColor(colorString);
        scoop.setColor(colorString);
        scoops.add(scoop);
        reCalcDimensions();
    }     
    public String toString()
    {
        return "Ice cream cone with " + scoops.size() + " scoops." + super.toString();
    } 
        
}
