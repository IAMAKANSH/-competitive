package challenge;

import java.util.Scanner;

public class Day11Question1 {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for (int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        selectionSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
    /// 6 5 4 3 2 1
    private static void selectionSort(int[] arr) {

    for (int i=0;i<arr.length;i++)
    {
        int j=i+1;
        int smallest=i;
        while(j<arr.length)
        {
            if(arr[j]<arr[smallest])
            {
                smallest=j;
            }
            j++;
        }
        if(i!=smallest)
        {
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }

    }

    }

}
