package topic.dp;

import java.util.Scanner;

public class PairingFriend {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int noOfFriends=sc.nextInt();

        int[] dp=new int[noOfFriends+1];

        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=noOfFriends;i++)
        {
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
        }
        System.out.println(dp[noOfFriends]);
    }
}
