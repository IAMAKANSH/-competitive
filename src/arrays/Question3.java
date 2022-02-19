package arrays;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Question3 {

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
        System.out.println("Enter the K");
        int kth=sc.nextInt();
        int kthLargestElement=kthLargestElement(arr,kth);
        System.out.println(kthLargestElement);
    }

    private static int kthLargestElement(int[] arr, int kth) {

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            priorityQueue.add(arr[i]);
            if(priorityQueue.size()>kth)
            {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
