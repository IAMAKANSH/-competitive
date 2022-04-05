package challenge;

import java.util.Scanner;

public class Day2Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();

        int n=sc.nextInt();

        int[] arr=new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        int[] result=rotateArray(arr,k);
        for (int i=0;i<n;i++)
        {
            System.out.println(result[i]);
        }

    }

    private static int[] rotateArray(int[] arr, int k) {

        k=k%arr.length;
        int[] resultArray=new int[arr.length];

        for (int i=0;i<arr.length;i++)
        {
            int ele=arr[i];
            if((k+i)<arr.length)
            {
                resultArray[k+i]=ele;
            }
            else
            {
                resultArray[Math.abs(arr.length-(k+i))]=ele;
            }
        }
        return resultArray;
    }
}
