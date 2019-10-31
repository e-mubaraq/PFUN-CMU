package hw6;
import    java.awt.*;
import    java.applet.*;
import    javax.swing.*;

/**
 * This Applet runs bouncer classes that implements a Bouncer interface.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class BounceApplet extends JApplet implements Runnable
{
Bouncer bouncers[] = new Bouncer[30];
int     numBouncers = 0;
Thread  myThread;

public void init()
{
    int i = 0;

    addBouncer(new MmikailBouncer());
    i = numBouncers - 1;
    bouncers[i].setXAndY(0,30);

    addBouncer(new MmikailBouncer2());
}

public void addBouncer(Bouncer b)
{
    bouncers[numBouncers] = b;
    if (b instanceof IceCreamConePG)
    {
        IceCreamConePG cone = (IceCreamConePG) b;
        cone.addScoop("blue");
        cone.addScoop("green");
    }
    else
    {
        b.setColor("black");
    }
    numBouncers++;
}

// Create and start thread

public void start()
{
    if (myThread == null)
    {
        myThread = new Thread(this);
        myThread.start();
    }
}

public void paint(Graphics g)
{
    int i;

    g.clearRect(0, 0, getSize().width, getSize().height);

    for (i = 0; i < numBouncers; i++)
        bouncers[i].paint(g);
}

public void run()
{
    int i;
    Point p;

    while (true)
    {
        for (i = 0; i < numBouncers; i++)
        {
            bouncers[i].move();
            
            p = bouncers[i].getBottomRightPoint();
            if (p.getX() >= getSize().width)
            {
                bouncers[i].setColor(Color.RED);
                bouncers[i].setShapeX(0);
            }
            if (p.getY() >= getSize().height)
            {
                bouncers[i].setColor("pink");
                bouncers[i].setShapeY(0);
            }
        }
        repaint();
        pause(200);
    }
}

void pause(int milliseconds)
{
    try
    {
        Thread.sleep(milliseconds);
    }
    catch (InterruptedException e) {}
}

public synchronized void stop()
{
        myThread = null;        // set to null so start recreates
        notifyAll();
}
}
