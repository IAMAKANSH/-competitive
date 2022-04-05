package topic.dp;

import java.util.Scanner;

public class TilingNM {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int nLength=sc.nextInt();
        int mBreadth=sc.nextInt();

        int[] dp=new int[nLength+1];

        for (int i=1;i<=nLength;i++)
        {
            if(i<mBreadth)
            {
                dp[i]=1;
            }
            else if(i==mBreadth)
            {
                dp[i]=2;
            }
            else
            {
                dp[i]=dp[i-1]+dp[i-mBreadth];
            }
        }
        System.out.println(dp[nLength]);
    }
}
