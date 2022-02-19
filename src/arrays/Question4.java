package arrays;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows");
        int rows=sc.nextInt();
        int[][] metric=new int[rows][2];
        for(int j=0;j<rows;j++) {
            Scanner sc1=new Scanner(System.in);
            String numbers = sc1.nextLine();
            String num[] = numbers.split("\\s");
            int k=0;
            for (String n : num
            ) {
                metric[j][k] = Integer.parseInt(n);
                k++;
            }
        }
        System.out.println("whats the kth element");
        int kth=sc.nextInt();
        int[][] result=getkthClosest(metric,kth);
        for (int i=0;i<result.length;i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    private static int[][] getkthClosest(int[][] metric, int kth) {
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((o1, o2) ->{
            return (o2[0]*o2[0]+o2[1]*o2[1])-(o1[0]*o1[0]+o1[1]*o1[1]);
        });
        for (int[] res:metric)
        {
            priorityQueue.add(res);
            if(priorityQueue.size()>kth)
                priorityQueue.poll();
        }
        int[][] result=new int[kth][2];
        int i=0;
        while (!priorityQueue.isEmpty())
        {
            result[i]=priorityQueue.poll();
            i++;
        }
        return result;
    }
}
