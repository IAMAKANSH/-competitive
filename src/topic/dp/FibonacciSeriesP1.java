package topic.dp;

import java.util.Scanner;

public class FibonacciSeriesP1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the fibonacci series");
        int n=sc.nextInt();

        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
        int result=fibonacci(n);
        System.out.println("Through recursion:: "+result);
    }

    static int fibonacci(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        //f(n)=f(n-1)+f(n-2)
        int fib1=fibonacci(n-1);
        int fib2=fibonacci(n-2);
        return fib1+fib2;

    }
}
