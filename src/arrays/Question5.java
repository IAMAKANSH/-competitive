package arrays;

import java.util.Scanner;

public class Question5 {

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
        int[] result=index(arr,target);
        for (int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }
    }

    private static int[] index(int[] arr, Integer target) {
        int[] result=new int[2];
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int sum=arr[left]+arr[right];
            if(sum==target){
                result[0]=left+1;
                result[1]=right+1;
                break;
            }
            if(sum>target)
            {
                right--;
            }
            else {
                left++;
            }

        }
        return  result;
    }
}
