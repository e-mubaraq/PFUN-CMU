package HW1;
import java.io.*;

/**
 * This program sets linux files permissions.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class LinuxPermissions
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Enter permissions for the file: ");
        str = keyboard.readLine();
        if(str.length() == 9)
            System.out.println("This is the permission for chmod: " + permissionString(str));
        else
            System.out.print(str + " is not a valid permission. Permissions should be 9 chracters long.");
            
    }

    public static String permissionString(String perms)  // calls onePermission method 3 times and concatenate the result to get the permission 
    {
        String permission = "";
        String userPerm = perms.substring(0, 3);
        String groupPerm = perms.substring(3, 6);
        String otherPerm = perms.substring(6);

        userPerm = onePermission(userPerm);
        groupPerm = onePermission(groupPerm);
        otherPerm = onePermission(otherPerm);

        permission = userPerm + groupPerm + otherPerm;
        return permission;
    }

    public static String onePermission(String perms)  // This method converts each group of permission to its corresponding decimal value
    {
        String onePerm = "";
        int placeR = 0, placeW = 0, placeX = 0, place4 = 0, place;

        if(!(perms.contains("r") || perms.contains("w") || perms.contains("x") || perms.contains("-")))
            return perms;
        if (perms.contains("r"))
            placeR = 4;
        if (perms.contains("w"))
            placeW = 2;
        if (perms.contains("x"))
            placeX = 1;
        if (perms.contains("-"))
            place4 = 0;
        
        place = placeR + placeX + placeW + place4;
        onePerm = String.valueOf(place);
        return onePerm;
    }
}
