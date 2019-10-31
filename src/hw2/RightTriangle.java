package hw2;

/**
 * This class is an helper-class for the PrintRightTriangle class. It defines
 * the features of a Right Triangle.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class RightTriangle
{
    private int width;
    private String chara;
    private String location;

    public RightTriangle() // default constructor
    {
        width = 10;
        chara = "*";
        location = "bl";
    }

    public RightTriangle(int rWidth, String rChara, String rLocation) // constructor with arguments
    {
        width = rWidth;
        chara = rChara;
        location = rLocation;
    }

    // setters
    public void setWidth(int w)
    {
        width = w;
    }

    public void setCharacter(String c)
    {
        chara = c;
    }

    public void setLocaton(String l)
    {
        location = l;
    }

    // getter
    public int getWidth()
    {
        return width;
    }

    public String setCharacter()
    {
        return chara;
    }

    public String getLocation()
    {
        return location;
    }

    public String toString()
    {
        String text = "This is a program that prints Right Triangle of different forms";

        return text;
    }

    /**
     * This method does the major function of printing the triangle from 1 up to the
     * width.
     */

    public void drawAsciiArt()
    {
        int j;
        if (location.equalsIgnoreCase("BL"))
            {
                for (j = 1; j <= width; j++)
                    {
                        System.out.println("");
                        System.out.print(buildString(chara, j));
                    }
            }
        else if (location.equalsIgnoreCase("TL"))
            {
                for (j = width; j >= 1; j--)
                    {
                        System.out.println("");
                        System.out.print(buildString(chara, j));
                    }
            }
        else if (location.equalsIgnoreCase("TR"))
            {
                for (j = 0; j < width; j++)
                    {
                        System.out.println("");
                        System.out.print(buildString(" ", chara.length() * j));
                        System.out.print(buildString(chara, width - j));
                    }
            }
        else if (location.equalsIgnoreCase("BR"))
            {
                for (j = 1; j <= width; j++)
                    {
                        System.out.println("");
                        System.out.print(buildString(" ", chara.length() * (width - j)));
                        System.out.print(buildString(chara, j));
                    }
            }
        else
            System.out.println(location + " Please enter a valid location: tr,br,tl or bl");
    }

    /**
     * 
     * @param str String to be replicated multiple num times
     * @param num number of times you want to replicate the String str
     * @return String str repeated num times on a line.
     */

    private String buildString(String str, int num) // builds the string str to be drawn per num line
    {
        String bs = "";
        int i;
        for (i = 1; i <= num; i++)
            bs = bs + str;

        return bs;
    }

}
