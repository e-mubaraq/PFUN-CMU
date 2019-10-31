package hw4;

/**
 * This is a helper class for the RunElevator test program.
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
 
public class Elevator
{
    private int topFloor;
    private int bottomFloor;
    private int presentFloor;
    private Door door = new Door();

    public Elevator()
    {
        topFloor = 4;
        bottomFloor = 1;
        presentFloor = 1;
    }

    public Elevator(int t, int b)
    {
        topFloor = t;
        bottomFloor = b;
        presentFloor = 1;
    }

    public int getTopFloor()
    {
        return topFloor;
    }
    
    public int getBottomFloor()
    {
        return bottomFloor;
    }

    public boolean setTopFloor(int n)
    {
        if (n < bottomFloor || n < presentFloor)
            return false;
        
        else
        {
            topFloor = n;
            return true;
        }
    }

    public boolean setBottomFloor(int n)
    {
        if (n > topFloor || n > presentFloor)
            return false;
        
        else
        {
            bottomFloor = n;
            return true;
        }
    }
    
    public void openDoor()
    {
        String openDoor = door.setOpen();
        System.out.println(openDoor);
    }

    public void closeDoor()
    {
        String closeDoor = door.setClose();
        System.out.println(closeDoor);
    }
    
    public String printMove(int floor, boolean up)
    {
        if (up)
            return "Going up to floor " + floor + ".";
        else
            return "Going down to floor " + floor + ".";
    }

    public boolean move(int destination)
    {
        String result = "";

        if (destination < bottomFloor || destination > topFloor)
        {
            System.out.println("Elevator can't move"); //check
            return false;
        }

        else
        {
            if (presentFloor < destination) // This means you are going up
            {
                if (door.isDoorOpen()) // If door is open
                    result = result + "\n" + door.setClose() + "."; // close it

                for (int i = presentFloor + 1; i <= destination; i++) // then move
                {
                    presentFloor = i; // make presentFloor the current floor
                    if (i == destination)
                        break;
                    result = result + "\n" + printMove(i, true); // print "going up" message.
                }
                System.out.println (result + "\n" + door.setOpen() + " at floor " + destination + "." + "\n" + "\n"
                        + "The elevator is on floor " + destination + ".");
            }

            else if (presentFloor == destination)
            {
                presentFloor = destination; // set present floor to floor number
                System.out.println(door.setOpen()); // open door
            }

            else // This means presentfloor > floorNumber, meaning we are going down
            {
                if (door.isDoorOpen())
                    result = result + "\n" + door.setClose() + ".";

                for (int i = presentFloor - 1; i >= destination; i--) // then move
                {
                    presentFloor = i; // make presentFloor the current floor
                    if (i == destination)
                        break;
                    result = result + "\n" + printMove(i, false); // print "going up" message.
                }
                System.out.println(result + "\n" + door.setOpen() + " at floor " + destination + "." + "\n" + "\n"
                        + "The elevator is on floor " + destination + ".");
            }
            return true;
        }
    }

    public String toString()
    {
        String text = "This elevation has " + topFloor + " as the maximum and " + bottomFloor + " as the minimum." +
                       "/n" + "It is currently on the " + presentFloor + ".";
        
        return text;
    }
}
