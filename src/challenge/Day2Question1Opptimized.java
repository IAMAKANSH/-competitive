package challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Day2Question1Opptimized {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();

        int n=sc.nextInt();

        int[] arr=new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] result= rotation(arr,k);
        Arrays.stream(result).forEach(
                System.out::println
        );
    }

    private static int[] rotation(int[] arr, int k) {

        k=k%arr.length;

        reverse(arr,0,arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        return arr;
    }

    public static void reverse(int[] arr,int start,int end)
    {
       while(start<end)
       {
           int temp=arr[start];
           arr[start]=arr[end];
           arr[end]=temp;
           start++;
           end--;
       }
    }
}
