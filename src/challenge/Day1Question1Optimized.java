package challenge;

import java.util.Scanner;

public class Day1Question1Optimized {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for (int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] response=sortedSquaredArray(arr);
        for (int i=0;i<response.length;i++)
        {
            System.out.println(response[i]);
        }
    }

    private static int[] sortedSquaredArray(int[] arr) {

        int[] result=new int[arr.length];
        int i=0;
        int j=arr.length-1;
        int x= arr.length-1;
        while(i<=j)
        {
            int left= (int) Math.pow(arr[i],2);
            int right= (int) Math.pow(arr[j],2);
            if(left<=right)
            {
                result[x]=right;
                x--;
                j--;
            }
            else {
                result[x]=left;
                x--;
                i++;
            }
        }
        return result;
    }
}
