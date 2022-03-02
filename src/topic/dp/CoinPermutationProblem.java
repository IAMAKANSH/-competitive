package topic.dp;

import java.util.Scanner;

public class CoinPermutationProblem {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter target");
        int target= sc.nextInt();
        int dp[]=new int[target+1];
        dp[0]=1;
        for (int i=1;i<dp.length;i++)
        {
            for (int j=0;j<arr.length;j++)
            {
                if(i>=arr[j])
                {
                    dp[i] +=dp[i-arr[j]];
                }
            }
        }
        System.out.println(dp[target]);
    }
}
