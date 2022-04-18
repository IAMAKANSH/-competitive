package challenge;

import java.util.Scanner;

public class Day8Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Integer target=sc.nextInt();
        Integer n=sc.nextInt();

        int[] arr=new int[n];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        Integer response=searchRotatedSortedArray(arr,target);
    }

    private static Integer searchRotatedSortedArray(int[] arr, Integer target) {

        int left=0;
        int right=arr.length-1;
        int middle;
        while (left<=right)
        {
            middle= (int) Math.floor((left+right)/2);

            if(arr[middle]==target)
                return middle;
            if(arr[left]<=arr[middle])
            {
                //left is sorted
                if(target>=arr[left] && target<arr[middle])
                {
                    //explore left side;
                    right=middle-1;

                }
                else {

                    left=middle+1;
                    //explore right side;
                }

            }
            else {
                //right is sorted
                if(target>arr[middle] && target<=arr[right])
                {
                    //explore right

                    left=middle+1;

                }
                else
                {
                    //explore left
                    right=middle-1;
                }
            }
        }
    return -1;
    }
}
