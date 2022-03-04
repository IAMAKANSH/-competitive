package topic.dp;

import java.util.Scanner;

public class KnapsackProblemUnbounded {
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

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        KnapsackProblem.Pair[] pairs = new KnapsackProblem.Pair[n];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            pairs[i] = new KnapsackProblem.Pair(val, 0);
        }
        for (int i = 0; i < n; i++) {
            int wt = sc.nextInt();
            pairs[i].setWt(wt);
        }
        System.out.println("Enter target");
        int target = sc.nextInt();
        int[] dp = new int[target + 1];

        dp[0]=0;
        for (int c=1;c< dp.length;c++)
        {int max=0;
            for (int i=0;i<n;i++)
            {

                if(pairs[i].wt<=c)
                {
                        int remaining=c-pairs[i].wt;
                        int remainingDP=dp[remaining];
                        int total=remainingDP+pairs[i].val;
                        if(total>max)
                        {
                            max=total;
                        }
                }
            }
            dp[c]=max;
        }
        System.out.println(dp[dp.length]);
    }
}
