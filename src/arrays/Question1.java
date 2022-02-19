package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String numbers= sc.nextLine();
        String num[]=numbers.split("\\s");
        int[] arr=new int[num.length];
        int k=0;
        for (String n:num
             ) {
            arr[k]=Integer.parseInt(n);
            k++;
        }
        Integer target= sc.nextInt();
        int[] indices=twoSum(arr,target);
        System.out.println(indices[0]+" "+indices[1]);

    }

    private static int[] twoSum(int[] arr, Integer target) {
        int[] result=new int[2];
        Map<Integer,Integer> hm=new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            int comp=target-arr[i];
            if (hm.containsKey(comp))
            {
                result[0]=hm.get(comp);
                result[1]=i;
            }
            else
            {
                hm.put(arr[i],i);
            }
        }
        return result;

    }
}
