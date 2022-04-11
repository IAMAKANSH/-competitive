package challenge;

import java.util.Scanner;

public class Day6Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Boolean response=checkStringPalindrome(str);
        System.out.println(response);
    }

    private static Boolean checkStringPalindrome(String str) {

        int left=0;
        int right=str.length()-1;
        while (left<right)
        {
            if(str.charAt(left)!=str.charAt(right))
                return false;

            left++;
            right--;
        }

        return  true;
    }
}
