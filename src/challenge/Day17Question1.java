package challenge;

import java.util.Scanner;

public class Day17Question1 {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int head=0;
        while(true)
        {
            System.out.println("Enter 1->push and 2->pop and 3->exit");
            int res=sc.nextInt();

            if(res==1)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                push(arr,ele,head);
                head++;
            }
            else if(res==2)
            {
                pop(arr,head);
                head--;
            }
            else
            {
                break;
            }
            display(arr,head);
        }

    }
    public static void push(int[] arr,int element,int head)
    {
        arr[head]=element;
    }
    public static void pop(int[] arr,int head)
    {
        arr[head]=0;
    }
    public static void display(int[] arr,int head)
    {
        for (int i=0;i<head;i++) {
                System.out.println(arr[i]);
        }
    }
}
