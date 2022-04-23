package challenge;

import java.util.Scanner;

public class Day10Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for (int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }

        getSortedArray(arr);
        for (Integer i :
             arr) {
            System.out.println(i);

        }

    }

    private static void getSortedArray(int[] arr) {

        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr.length-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
