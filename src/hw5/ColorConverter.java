package hw5;
/**
 * This class converts colors from String to Color.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

import java.awt.*;

public enum ColorConverter
{
    BLACK(Color.BLACK), 
    BLUE(Color.BLUE),
    RED(Color.RED), 
    YELLOW(Color.YELLOW), 
    GREEN(Color.GREEN),
    PINK(new Color(255,105,180)),
    MAGENTA(new Color(255,0,255)),
    PURPLE(new Color(128,0,128));

    private Color color;

    ColorConverter (Color c) { color = c; }
    
    public static Color getColor(String colorString) 
    {
        for (ColorConverter option : ColorConverter.values())
        {
            if (option.toString().equalsIgnoreCase(colorString))
                return option.color;
        }
        return Color.BLACK;
    }
}

