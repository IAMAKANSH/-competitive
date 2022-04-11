package challenge;

import java.util.Scanner;

public class Day2Question3 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int max=MaxAreaCovered(arr);
        System.out.println(max);

    }

    private static int MaxAreaCovered(int[] arr) {

        int max=Integer.MIN_VALUE;
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int area=(right-left)*Math.min(arr[left],arr[right]);
            if(area>max)
            {
                max=area;
            }
            if(arr[left]>arr[right])
                right--;
            else
                left++;

        }
return max;
    }
}
