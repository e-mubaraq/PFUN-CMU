package hw4;
import java.awt.*;
import javax.swing.*;

/**
 * This class simulates a Kigali (or American) traffic light.
 *
 * @author Mubarak Mikail
 * 
 * @author Ozioma Paul
 * 
 * Andrew ID: mmikail 
 * 
 * Andrew ID: pozioma
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class TrafficLight extends JPanel
{
    private boolean redState;
    private boolean yellowState;
    private boolean greenState;

    Color redOff = new Color(187, 0, 0);
    Color yellowOff = new Color(187, 187, 0);
    Color greenOff = new Color(0, 100, 0);

    private GraphicalCircle redLight = new GraphicalCircle(new Point(150, 100), 100, Color.red);
    private GraphicalCircle yellowLight = new GraphicalCircle(new Point(150, 250), 100, yellowOff);
    private GraphicalCircle greenLight = new GraphicalCircle(new Point(150, 400), 100, greenOff);

    public TrafficLight()
    {
        redState = true;
        yellowState = false;
        greenState = false;
    }

    public void paintComponent(Graphics g)
    {
        g.fillRect(100, 50, 100, 400);
        redLight.paintComponent(g);
        yellowLight.paintComponent(g);
        greenLight.paintComponent(g);
    }

    public boolean isRedState()
    {
        if (redLight.getColor().equals(Color.red))
            return redState = true;
        return false;
    }

    public boolean isYellowState()
    {
        if (yellowLight.getColor().equals(Color.yellow))
            return yellowState = true;
        return false;
    }

    public boolean isGreenState()
    {
        if (greenLight.getColor().equals(Color.green))
            return greenState = true;
        return false;
    }

    public boolean isStop()
    {
        if (isRedState() && !isYellowState() && !isGreenState())
            return true;
        return false;
    }

    public boolean isCaution()
    {
        if (!isRedState() && isYellowState() && !isGreenState())
            return true;
        return false;
    }

    public boolean isGo()
    {
        if (!isRedState() && !isYellowState() && isGreenState())
            return true;
        return false;
    }

    public void setStop()
    {
        redLight.setColor(Color.red);
        yellowLight.setColor(yellowOff);
        greenLight.setColor(greenOff);
    }

    public void setCaution()
    {
        redLight.setColor(redOff);
        yellowLight.setColor(Color.yellow);
        greenLight.setColor(greenOff);
    }

    public void setGo()
    {
        redLight.setColor(redOff);
        yellowLight.setColor(yellowOff);
        greenLight.setColor(Color.green);
    }

    public void change()
    {
        if (isStop())
            setCaution();
        else if (isCaution())
            setGo();
        else if (isGo())
            setStop();
    }

    public String toString()
    {
        String text = "The red state is: " + isRedState() + "\nThe yellow state is: " + isYellowState()
                + "\nThe green state is: " + isGreenState();
        return text;
    }
}
