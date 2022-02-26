package topic.dp;

import java.util.Scanner;

public class StairProblemWithVariableJump {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int noOfStairs=sc.nextInt();
        int[] possibility=new int[noOfStairs];
        for (int z=0;z<noOfStairs;z++)
        {
            possibility[z]=sc.nextInt();
        }
        int[] dp=new int[noOfStairs+1];
        dp[noOfStairs]=1;
        for (int j=noOfStairs-1;j>=0;j--)
        {
                for(int k=1;k<=possibility[j] && k+j<dp.length;k++)
                {
                    dp[j]+=dp[j+k];
                }
        }
        System.out.println(dp[0]);
    }
}

/**
 * Input 13
 * 5 5 2 4 1 5 9 8 6 3 8 9 1
 * expected ans:2044
 */
