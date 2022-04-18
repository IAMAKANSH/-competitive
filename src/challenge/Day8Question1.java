package challenge;

import java.util.Scanner;

public class Day8Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int targetNumber=sc.nextInt();
        int n=sc.nextInt();

        int[] arr=new int[n];
        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int left=0;
        int right=arr.length-1;
        Integer result=binarySearch(arr,left,right,targetNumber);
        System.out.println(result);
    }

    private static Integer binarySearch(int[] arr, int left, int right,int targetNumber) {

        if(left>right)
            return  -1;
        int middle=(int)Math.floor((left+right)/2);
        if(arr[middle]==targetNumber)
            return middle;
        else if(arr[middle]>targetNumber)
        {
            right=middle-1;
            return binarySearch(arr,left,right,targetNumber);
        }
        else
        {
            left=middle+1;
            return binarySearch(arr,left,right,targetNumber);
        }
    }
}
