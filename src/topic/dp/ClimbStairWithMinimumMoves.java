package topic.dp;

import java.util.Scanner;

public class ClimbStairWithMinimumMoves {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int noOfStairs=sc.nextInt();
        int[] possibility=new int[noOfStairs];
        for (int z=0;z<noOfStairs;z++)
        {
            possibility[z]=sc.nextInt();
        }
        Integer[] dp=new Integer[noOfStairs+1];
        dp[noOfStairs]=0;
        for (int i=noOfStairs-1;i>=0;i--){
            if (possibility[i]>0)
            {
                int min=Integer.MAX_VALUE;
                for (int j=1;j<=possibility[i] && i+j<dp.length;j++)
                {
                    if(dp[i+j]!=null) {
                        min = Math.min(min, dp[i+j]);
                    }
                }
                if(min!=Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
