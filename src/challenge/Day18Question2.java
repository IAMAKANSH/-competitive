package challenge;

import java.util.Scanner;
import java.util.Stack;

public class Day18Question2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Stack<Integer> inStack=new Stack<>();
        Stack<Integer> outStack=new Stack<>();

        while(true)
        {

            System.out.println("Enter 1-push 2-pop 3 peep 4 for exit");
            int res= sc.nextInt();

            if(res==1)
            {
                System.out.println("Enter the value");
                int value=sc.nextInt();

                inStack.push(value);
            }
            else if(res==2)
            {
                if(outStack.size()==0)
                {
                   while (inStack.size()>0)
                   {
                       outStack.push(inStack.pop());
                   }
                }
                System.out.println(outStack.pop());
            }
            else
            {
                break;
            }

        }
    }
}
