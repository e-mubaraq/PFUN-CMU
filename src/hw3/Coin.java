package hw3;
import java.util.*;

/**
 * This class sets up a cloin class.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class Coin
{
    private static Random r = new Random();

    private enum CoinSide
    {
        HEADS, TAILS
    };

    CoinSide sideUp;

    public Coin()
    {
        sideUp = CoinSide.HEADS;
    }

    public boolean isHeads()
    {
        if (sideUp == CoinSide.HEADS)
            return true;
        return false;
    }

    public boolean isTails()
    {
        if (sideUp == CoinSide.TAILS)
            return true;
        return false;
    }

    /**
     * This method flips the coin to give either heads or tails by utilizing the
     * Random class object.
     */
    public void flip()
    {
        // Generate a random number, either 0 or 1, and use it to set sideUp to HEADS or
        // TAILS
        int coinFace = r.nextInt(2);

        if (coinFace == 0)
            sideUp = CoinSide.HEADS;
        else
            sideUp = CoinSide.TAILS;
    }

    public String toString()
    {
        return ("Coins side up is: " + sideUp);
    }
}