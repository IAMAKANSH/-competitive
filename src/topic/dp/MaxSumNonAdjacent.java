package topic.dp;

import java.util.Scanner;

public class MaxSumNonAdjacent {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] inc=new int[n];
        int[] exc=new int[n];
        inc[0]=arr[0];
        exc[0]=0;
        for (int i=1;i< arr.length;i++)
        {
            inc[i]=exc[i-1]+arr[i];
            exc[i]=Math.max(inc[i-1],exc[i-1]);
        }
        int ans=Math.max(inc[n-1],exc[n-1]);
        System.out.println(ans);
    }
}
