package challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Day11Question2 {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] response=mergeSort(arr);
        for (int i=0;i<response.length;i++)
        {
            System.out.println(response[i]);
        }
    }

    public static int[] mergeSortedArrays(int[] arr1,int[] arr2)
    {
        int[] mergedArray=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int z=0;
        while (i<arr1.length && j<arr2.length)
        {

            if(arr1[i]<=arr2[j])
            {
                mergedArray[z]=arr1[i];
                i++;
            }else
            {
                mergedArray[z]=(arr2[j]);
                j++;
            }
            z++;
        }
        while (i<arr1.length)
        {
            mergedArray[z]=(arr1[i]);
            i++;
            z++;
        }
        while (j<arr2.length)
        {
            mergedArray[z]=(arr2[j]);
            j++;
            z++;
        }
        return  mergedArray;
    }


    public static int[] mergeSort(int[] arr)
    {
        if(arr.length<=1)
        {
            return arr;
        }
        int middle= (int) Math.floor(arr.length/2);
        int[] leftArr= mergeSort(Arrays.copyOfRange(arr,0,middle));
        int[] rightArr=mergeSort(Arrays.copyOfRange(arr,middle,arr.length));
        return mergeSortedArrays(leftArr,rightArr);
    }


}
