package hw7;

public class Mytests
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String s1, s2, s3, s4;
        String madWord, newWord;
        s1 = "[Boss]";
        s2 = s1 + ".";
        s3 = "[person name]";
        s4 = "s4";
        
        madWord = MadUtils.getMadWord(s1);
        
        System.out.println(s1 +  " MadWord is " + madWord);
        System.out.println("Replaced with " + MadUtils.replaceMadWord(s1, "newWord"));
        madWord = MadUtils.getMadWord(s2);
        System.out.println(s2 +  " MadWord is " + madWord);
        System.out.println("Replaced with " + MadUtils.replaceMadWord(s2, "newWord"));
        madWord = MadUtils.getMadWord(s3);
        System.out.println(s3 +  " MadWord is " + madWord);
        System.out.println("Replaced with " + MadUtils.replaceMadWord(s3, "newWord"));
        madWord = MadUtils.getMadWord(s4);
        System.out.println(s4 +  " MadWord is " + madWord);
        
        s1 = "apple";
        System.out.println(Utils.getIndefiniteArticle(s1) + " " + s1);
        
        s1 = "coffee";
        System.out.println(Utils.getIndefiniteArticle(s1) + " " + s1);

        
        
    }

}
