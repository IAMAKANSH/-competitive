package topic.dp;

import java.util.Scanner;

public class CountingStrings {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input= sc.next();

        int[] dp=new int[input.length()];
        dp[0]=1;
        for (int i=1;i<dp.length;i++)
        {
           if(input.charAt(i-1)=='0' && input.charAt(i)=='0')
           {
                dp[i]=0;
           }
            else if(input.charAt(i-1)=='0' && input.charAt(i)!='0')
            {
                dp[i]=dp[i-1];
            }
           else if(input.charAt(i-1)!='0' && input.charAt(i)=='0')
           {
                if(input.charAt(i-1)=='1' || input.charAt(i-1)=='2')
                {
                    dp[i]=i>2?dp[i-2]:1;
                }
                else
                {
                    dp[i]= 0;
                }
           }
           else
           {
               dp[i]=dp[i-1];
                if(Integer.parseInt(input.substring(i-1,i+1))<=26)
                {
                    dp[i] +=i>=2?dp[i-2]:1;
                }
           }

        }
        System.out.println(dp[input.length()-1]);
    }
}
