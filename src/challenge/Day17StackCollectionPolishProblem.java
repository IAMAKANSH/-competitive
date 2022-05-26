package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day17StackCollectionPolishProblem {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> inputList=new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            inputList.add(sc.next());
        }

        Stack<Integer> stack=new Stack();
        int result = 0;
        for (int i=0;i<n;i++)
        {
            String ele=inputList.get(i);
            if(ele.equals("-") || ele.equals("+") || ele.equals("/") || ele.equals("*"))
            {
                int b=stack.pop();
                int a=stack.pop();
                int sum;
                    if(ele.equals("+"))
                    {
                        sum=(a+b);
                        result =sum;
                    }
                    else if(ele.equals("-"))
                    {
                        sum=(a-b);
                        result =sum;
                    }
                    else if(ele.equals("*"))
                    {
                        sum=(a*b);
                        result =sum;
                    }
                    else
                    {
                        sum=Math.round(a/b);
                        result =sum;
                    }
                    stack.push(sum);
            }
            else {
                stack.push(Integer.parseInt(ele));
            }
        }
        System.out.println("Result is "+result);
    }
}
