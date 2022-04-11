package challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day3Questions {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int targetSum=sc.nextInt();
        int n= sc.nextInt();
        int[] arr=new int[n];

        for (int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int[] result=targetSumIndices(arr,targetSum);
        System.out.println(result[0]+" "+result[1]);

    }

    private static int[] targetSumIndices(int[] arr,int targetSum) {


        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for (int i=0;i<arr.length;i++)
        {
            int rem=targetSum-arr[i];
            if(map.get(rem)!=null)
            {
                result[1]=i;
                result[2]=map.get(rem);
            }
            else
            {
                map.put(arr[i],i);
            }
        }
        return result;
    }
}
