package tests;

public class PalCheck
{

    public static void main(String[] args)
    {
        String test = "aba";
        
        if (isPalindrom(test))
            System.out.println(test + " can be Palidrome");
        else
            System.out.println(test + " canNOT be a Palidrome");
        

    }
    
    public static boolean isPalindrom(String word)
    {
        boolean check = false;
        int i, j, len, count, count1 = 0;
        int count2 = 1;
        int num_even_char = 0;
        int num_odd_char = 0;
        char [] letters;
        
        letters = word.toCharArray();
        len = letters.length;
        
        for (i = 0; i < len; i++)
        {
            count = 1;
            for (j = i + 1; j < (len - 1); j++)
            {
                if (letters[i] == letters[j])
                {
                    count++;
                }
                else
                    count1++;
                count2 = count++;
                    
            }
            if (count2 % 2 == 0)
            {
                num_even_char++;
            }
            else
            {
                num_odd_char++;
            }
        }
        
        if (num_odd_char > 0)
            check = false;
        else if (num_even_char > 0 && num_odd_char == 0)
            check = true;
        else if (num_even_char > 0 && count1 == 1)
            check = true;
        
        
        return check;
    }
    

}
