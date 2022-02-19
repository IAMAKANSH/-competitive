package arrays;

import java.util.Scanner;

public class Question2 {

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
        int area=maxArea(arr);
        System.out.println(area);


    }

    private static int maxArea(int[] arr) {
        int max=0;

        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            int area=(j-i)*Math.min(arr[i],arr[j]);
            if(max<area)
            {
                max=area;
            }
            if(arr[i]>arr[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return max;

    }
}
