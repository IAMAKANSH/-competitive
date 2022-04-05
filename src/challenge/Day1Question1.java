package challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Day1Question1 {

    /**
     *  Sorted Squared Array - You are given an array of
     *  Integers in which each subsequent value is not less than the previous value.
     *  Write a function that takes this array as an input and returns a
     *  new array with the squares of each number sorted in ascending order.
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for (int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        sortedSquaredArray(arr);
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }


    }
    //O(n)
    private static void sortedSquaredArray(int[] arr) {
        //O(n)
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=arr[i]*arr[i];
        }
        //O(nlogn)
        Arrays.sort(arr);
    }
}
