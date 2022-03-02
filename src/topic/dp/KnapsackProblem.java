package topic.dp;

import java.util.Scanner;

public class KnapsackProblem {

    public static class Pair{
        int val;
        int wt;

        public Pair(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public void setWt(int wt) {
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        Pair[] pairs=new Pair[n];
        for (int i=0;i<n;i++)
        {
            int val= sc.nextInt();
            pairs[i]=new Pair(val,0);
        }
        for (int i=0;i<n;i++)
        {
            int wt= sc.nextInt();
            pairs[i].setWt(wt);
        }
        System.out.println("Enter target");
        int target=sc.nextInt();
        int[][] dp=new int[n+1][target+1];
        for (int i=0;i<dp.length;i++)
        {
            for (int j=0;j<dp[0].length;j++)
            {
                if(i==0 && j==0)
                    dp[i][j]=0;
                else if(i==0)
                    dp[i][j]=0;
                else if(j==0)
                    dp[i][j]=0;
                else
                {
                    int val=pairs[i-1].val;
                    if(j>=val)
                    {
                        dp[i][j] =Math.max(pairs[i-1].wt+dp[i-1][j-val],dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println("max wt is "+dp[n][target]);
    }
}
