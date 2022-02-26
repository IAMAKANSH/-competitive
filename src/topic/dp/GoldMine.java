package topic.dp;

import java.util.Scanner;

public class GoldMine {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter row");
        int r=sc.nextInt();
        System.out.println("Enter cols");
        int c= sc.nextInt();
        int[][] arr=new int[r][c];
        for (int i=0;i< arr.length;i++)
        {
            for (int j=0;j<arr[0].length;j++)
            {
                System.out.println("Enter row "+i+ " and col "+j);
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[r][c];
        for (int i= arr[0].length-1;i>=0;i--)
        {
            for ( int j=0;j< arr.length;j++)
            {
                if(i==(arr.length-1))
                {
                    dp[j][i]=arr[j][i];
                }
                else if(j==0)
                {
                    dp[j][i]= arr[j][i] + Math.max(dp[j+1][i+1],dp[j][i+1]);
                }
                else if(j== (arr.length-1))
                {
                    dp[j][i]= arr[j][i] + Math.max(dp[j][i+1],dp[j-1][i+1]);
                }
                else
                {
                    dp[j][i]=arr[j][i]+ Math.max(dp[j][i+1],Math.max(dp[j-1][i+1],dp[j+1][i+1]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<=0;i++)
        {
            for (int j=0;j< arr.length;j++)
            {
                max=Math.max(max,dp[j][i]);
            }
        }
        System.out.println("Max gold collected is "+max);
    }
}
