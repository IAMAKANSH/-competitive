package freelancer;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) throws Exception {


        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        String response=reverseMain(str);
        System.out.println(response);
        }
    //this method check the condition and criteria and if matches then call the recursive method
    private static String reverseMain(String str)throws Exception {
        if(str.isEmpty())
        {
            return str;
        }
        if(str.equals(" "))
        {
            throw new Exception("The string contains a non-numerical element");
        }
        String finalResult;
        if(str.matches("[0-9]+"))
        {
            finalResult=reverse(str);
        }
        else
        {
            throw  new Exception("The string contains a non-numerical element");
        }
        return finalResult;
    }
    //main recursive method to reverse the string
    public static String reverse(String str)
    {
        if (str.isEmpty()){
            return str;
        }
        int n=Character.getNumericValue(str.charAt(0));
        if(n%2==0)
        {
            n=n+1;
        }
        return reverse(str.substring(1))+n;
    }
}
