package hw6;
import java.awt.*;

/**
 * This interface declared the methods required by a bouncer class to bounce shapes.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public interface Bouncer
{
    void move();
    void paint(Graphics g);
    void setShapeX(int x);
    void setShapeY(int y);
    void setXAndY(int x, int y);
    void setColor(Color c);
    void setColor(String c);
    Point getBottomRightPoint();
}
