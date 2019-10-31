package hw4;
/**
 * This is a helper class for the RunElevator test program used to model a Door.
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
public class Door
{
    private boolean doorState;

    public Door()
    {
        doorState = true;
    }

    public Door(boolean d)
    {
        doorState = d;
    }

    public boolean isDoorOpen()
    {
        if (doorState)
            return doorState;
        return false;
    }

    public String setOpen()
    {
        if (isDoorOpen())
            doorState = true;
        return "Opening door";
    }

    public String setClose()
    {
        if (isDoorOpen())
            doorState = false;
        return "Closing door";
    }
}
