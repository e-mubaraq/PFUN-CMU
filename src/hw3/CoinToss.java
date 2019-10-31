package hw3;

/**
 * This class flips a coin a number of times.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class CoinToss
{

    public static void main(String[] args)
    {
        int i;
        int headsCount = 0;
        Coin c = new Coin();
        int total;

        if (args.length == 0)
            System.err.println("You have not entered the number of toss, please enter number of toss!");
        else
        {
            total = Integer.parseInt(args[0]);

            for (i = 1; i <= total; i++)
            {
                c.flip();
                if (c.isHeads())
                    headsCount++;
            }

            System.out.println("Tossed a coin " + total + " times.");
            System.out.println("Heads: " + headsCount + "  Tails: " + (total - headsCount));
            System.out.println(
                    "Heads: " + formatPercent(headsCount, total) + " Tails: " + formatPercent((total - headsCount), total)); 
        }
        

    }

    /**
     * This method calculates percentage of a number out of total and returns the
     * percentage as a string.
     * @param number number to be expressed as a percentage of total
     * @param total  maximum value that will give 100%
     * @return An integer concatenated with the percent(%) sign.
     */
    public static String formatPercent(double number, double total)
    {
        String percent;
        int pct;

        pct = (int) ((number / total) * 100);
        percent = String.valueOf(pct) + "%";

        return percent;
    }
}
