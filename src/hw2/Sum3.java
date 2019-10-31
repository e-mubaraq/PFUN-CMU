package hw2;
import java.io.*;

/**
 * This class sums up all the integers between 1 and N that are divisible by 3.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class Sum3
{

    public static void main(String[] args) throws IOException
    {
        int num;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.print("Enter value for N: ");
        str = keyboard.readLine();
        num = Integer.parseInt(str);

        while (num != -1)
            {
                if (num < -1)
                    System.out.println(sum1toNdiv3(Math.abs(num))); // changes the negative number to positive and does
                                                                    // the sum
                else
                    System.out.println(sum1toNdiv3(num)); // process

                System.out.print("Enter value for N: "); // prompt
                str = keyboard.readLine();
                num = Integer.parseInt(str);
            }
    }

    /**
     * This method calculates the sum of all the multiples of 3 between 1 and n by
     * looping at every 3 steps such that and adding the previous sum to the next
     * the multiple of 3 in the loop.
     * 
     * @param n limit of the summation
     * @return
     */

    public static int sum1toNdiv3(int n)
    {
        int sumTotal;
        int i;
        sumTotal = 0;
        for (i = 0; i <= n; i += 3)
            sumTotal = sumTotal + i;

        return sumTotal;
    }
}
