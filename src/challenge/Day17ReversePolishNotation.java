package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day17ReversePolishNotation {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> inputList=new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            inputList.add(sc.next());
        }
        Stack1 stack=new Stack1();
        int result=0;
        for (int i=0;i<n;i++)
        {
            String ele=inputList.get(i);
            if(ele.equals("+") || ele.equals("-") || ele.equals("*") ||
            ele.equals("/"))
            {
                int b=stack.removeFromBeginning();
                int a=stack.removeFromBeginning();
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
                stack.addAtBeginning(sum);
            }else
            {
                stack.addAtBeginning(Integer.parseInt(ele));
            }
        }
        System.out.println("Result is "+result);
    }
}

class NodeStack1
{
    int value;
    NodeStack1 node;

    public NodeStack1(int value) {
        this.value = value;
        this.node = null;
    }

    @Override
    public String toString() {
        return "NodeStack{" +
                "value=" + value +
                ", node=" + node +
                '}';
    }
}
class Stack1 {

    NodeStack1 first;
    NodeStack1 last;
    Integer size;

    public Stack1() {

        this.first = null;
        this.last = null;
        this.size = 0;
    }

    //add the beginning
    //remove from the beginning
    //reason for time complexity to 1
    public void addAtBeginning(int value) {
        NodeStack1 nodeStack = new NodeStack1(value);
        if (this.first != null) {
            NodeStack1 temp = this.first;
            this.first = nodeStack;
            this.first.node = temp;
        } else {
            this.first = nodeStack;
            this.last = nodeStack;
        }
        this.size++;
        return;
    }

    public Integer removeFromBeginning() {

        NodeStack1 temp=this.first;
        if (this.first != null) {
            this.first = this.first.node;
            this.size--;
            if (this.size == 0) {
                this.last = null;
            }
            return temp.value;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
