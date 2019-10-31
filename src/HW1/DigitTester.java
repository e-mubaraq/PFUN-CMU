package HW1;

/**
 * This class tests methods that manipulate digits in integer numbers.
 *
 * @author Mubarak Mikail
 * Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */

public class DigitTester
{

public static void main(String args[])
{
    System.out.println("checkResult() uses assert() to test replaceDigitN()");

    // Add your own test cases below these

    checkResult(replaceDigitN(37469, 2, 8), 37869, "called replaceDigitN(37469, 2, 8)") ;
    checkResult(replaceDigitN(37469, 4, 8), 87469, "called replaceDigitN(37469, 4, 8)") ;
    checkResult(replaceDigitN(0, 0, 1), 1, "called replaceDigitN(0, 0, 1)") ;
    checkResult(replaceDigitN(1, 0, 0), 0, "called replaceDigitN(1, 0, 0)") ;
    
    checkResult(replaceDigitN(12345, 3, 7), 17345, "called replaceDigitN(12345, 3, 7)") ;
    checkResult(replaceDigitN(-12345, 3, 7), -17345, "called replaceDigitN(-12345, 3, 7)");
    checkResult(replaceDigitN(-987654, 4, 4), -947654, "called replaceDigitN(-987654, 4, 4)");

    System.out.println("Since this is executed, it means all my tests pass!");
}
/*
 * This method will replace the nth digit in num with digit and return the
 * resulting new integer. Use mathematical calculations to determine the answer.
 *
 * Note: digits are counted right to left, and start at 0.
 *
 */
public static int replaceDigitN(int num, int n, int digit)
{
        // you write the code, using mathematical calculations
        int number = 0;
        int n1;
        int d;
        n1 = (int) (num / Math.pow(10, n));
        d = n1 % 10;
        if (num >= 0)
            {
                number = num - (int) (d * Math.pow(10, n)) + (int) (digit * Math.pow(10, n));
            } 
        else
            {
                number = num - (int) (d * Math.pow(10, n)) - (int) (digit * Math.pow(10, n));
            }

        return number;
}

/*
 * Call this method from main() with
 *
 *   - the result from your call to replaceDigit(),
 *   - the expected result (hardcoded in your call),
 *   - the failure message to print if they do not match.
 *
 */

public static void checkResult(int result, int expectedResult, String msg)
{
    
    // Note: this is a trace statement. It is meant to help you debug.
    //       You would normally comment it out before turning in your code,
    //       but please leave it in for this assignment.

    System.out.println("Does " + result + " equal " + expectedResult + "?");

    boolean traceResult = true;
    String errorMsg = "\n**Fail " + msg 
                        + " Result: " + result
                        + " Expected " + expectedResult;
    assert result == expectedResult : errorMsg;
    if (traceResult)
        System.out.println("\nSuccess: " + msg + " is " + expectedResult);
}
}