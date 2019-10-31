package hw4;
import java.io.*;

/**
 * This is a test program for an Elevator.
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

public class RunElevator
{

    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub

        Elevator lift = new Elevator();
        String str = "";
        int floor_num;

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the new floor (Enter to quit):");
        str = keyboard.readLine();
            
        System.out.println("The elevator is on floor 1");
        while (!str.equals(""))
        {
            floor_num = Integer.parseInt(str);
            boolean result;
            
            result = lift.move(floor_num);
            
            if (!result)
                System.out.println("Invalid entry");
           
            System.out.println("Please enter the new floor (Enter to quit):");
            str = keyboard.readLine();
            if (str.equals(""))
                System.out.println("Bye");
        }
    }
}
