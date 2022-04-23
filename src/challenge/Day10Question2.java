package challenge;

import java.util.Scanner;

public class Day10Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        insertionSort(arr);
        for (int i:arr)
        {
            System.out.println(i);
        }
    }

    private static void insertionSort(int[] arr) {
        ////7459120
         ///ji
        ///7759120

        for (int i=1;i<arr.length;i++)
        {

            int j=i-1;   //j=0
            int temp=arr[i];  //4
            while(j>=0 && arr[j]>temp)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }

    }
}
