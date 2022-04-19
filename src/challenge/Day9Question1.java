package challenge;

import java.util.Scanner;

public class Day9Question1 {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        Integer target=sc.nextInt();

        Integer n=sc.nextInt();
        int[] arr=new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int left=0;
        int right=arr.length;
        int[] range=new int[2];
        range[0]=-1;
        range[1]=-1;
        findLeftExtreme(arr,target,range,left,right);
        findRightExtreme(arr,target,range,left,right);
        System.out.println(range[0]+" "+range[1]);
    }

    private static void findRightExtreme(int[] arr, Integer target, int[] range, int left, int right) {

        if(left>right)
            return;

        int middle= (int) Math.floor((left+right)/2);
        ///1 2 5 5 5 5 5 5 7 8
        ///0 1 2 3 4 5 6 7 8 9
        //target=5;
        if(arr[middle]==target)
        {
            //check whether its the left extreme value
            if(middle==arr.length-1)
            {
                range[1]=arr.length-1;
            }else if(arr[middle+1]==target)
            {
                findRightExtreme(arr,target,range,middle+1,right);
            }
            else
            {
                range[1]=middle;
            }
        }
        else if(target>arr[middle])
            findRightExtreme(arr,target,range,middle+1,right);
        else
            findRightExtreme(arr,target,range,left,middle-1);

    }

    private static void findLeftExtreme(int[] arr, Integer target, int[] range, int left, int right) {

        if(left>right)
            return;

        int middle= (int) Math.floor((left+right)/2);
        ///1 2 5 5 5 5 5 5 7 8
        ///0 1 2 3 4 5 6 7 8 9
        //target=5;
        if(arr[middle]==target)
        {
            //check whether its the left extreme value
            if(middle==0)
            {
                range[0]=0;
            }else if(arr[middle-1]==target)
            {
                findLeftExtreme(arr,target,range,left,middle-1);
            }
            else
            {
                range[0]=middle;
            }
        }
        else if(target>arr[middle])
            findLeftExtreme(arr,target,range,middle+1,right);
        else
            findLeftExtreme(arr,target,range,left,middle-1);

    }

}
