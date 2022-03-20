package topic.dp;

import java.util.Scanner;

public class PaintHouse2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr=new int[n][c];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<c;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] dp=new int[n][c];

        for (int j=0;j<arr[0].length;j++)
        {
            dp[0][j]=arr[0][j];
        }
        for (int i=1;i<n;i++)
        {

            for (int j=0;j<dp[0].length;j++)
            {
                int min=Integer.MAX_VALUE;
               for (int k=0;k<dp[0].length;k++)
               {
                   if(k!=j) {
                       if (dp[i - 1][k] < min) {
                           min = dp[i - 1][k];
                       }
                   }
               }
               dp[i][j]=arr[i][j]+min;
            }
        }
        int min=Integer.MAX_VALUE;
        for (int k=0;k<dp[0].length;k++)
        {
                if (dp[n - 1][k] < min) {
                    min = dp[n - 1][k];
                }
        }
        System.out.println(min);
    }

}
