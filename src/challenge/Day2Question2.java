package challenge;

import java.util.Scanner;

public class Day2Question2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr=new int[len];
        for (int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
        }
        Boolean result=Monotonic(arr);
        System.out.println(result);

    }

    private static Boolean Monotonic(int[] arr) {

        int firstElement=arr[0];
        int lastElement=arr[arr.length-1];
        for (int i=1;i< arr.length-1;i++)
        {
            if((arr[i]>=firstElement && arr[i]<=lastElement) ||
                    (arr[i]<=firstElement && arr[i]>=lastElement))
            {
                firstElement=arr[i];
            }
            else
                return false;
        }
        return true;
    }

}
