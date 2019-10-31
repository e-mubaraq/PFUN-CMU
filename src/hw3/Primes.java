package hw3;
/**
 * This class determines the prime numbers between 1 and 1000.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class Primes
{

    public static void main(String[] args)
    {
        int i;
        int j;
        int k;
        boolean primes[];
        primes = new boolean[1001];

        for (j = 1; j < primes.length; j++)
        {
            primes[j] = true; // assigns true to all the array elements.

            for (i = 2; i < primes.length; i++)
            {
                if (primes[i] == true)
                {
                    for (k = i * i; k < primes.length; k += i)
                        primes[k] = false;
                }
            }
            if (primes[j] == true)
                System.out.println("Prime number: " + j);
        }
    }
}
