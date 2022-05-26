package challenge;

import java.util.Scanner;

public class Day17Question1LinkedList {

    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        Stack stack=new Stack();
        while(true)
        {
            System.out.println("Enter 1->push 2->pop and 3->exit");
            int res= sc.nextInt();
            if(res==1)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                stack.addAtBeginning(ele);
            }
            else if(res==2)
            {
                stack.removeFromBeginning();
            }
            else
            {
                break;
            }
        }
        System.out.println(stack );
    }
}
class NodeStack
{
    int value;
    NodeStack node;

    public NodeStack(int value) {
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
class Stack{

    NodeStack first;
    NodeStack last;
    Integer size;
    public Stack() {

        this.first=null;
        this.last=null;
        this.size=0;
    }
    //add the beginning
    //remove from the beginning
    //reason for time complexity to 1
    public void addAtBeginning(int value)
    {
        NodeStack nodeStack=new NodeStack(value);
        if(this.first!=null)
        {
            NodeStack temp=this.first;
            this.first=nodeStack;
            this.first.node=temp;
        }
        else
        {
            this.first=nodeStack;
            this.last=nodeStack;
        }
        this.size++;
        return;
    }
    public void removeFromBeginning()
    {

        if(this.first!=null) {
            this.first = this.first.node;
            this.size--;
            if(this.size==0)
            {
                this.last=null;
            }
        }
        return;
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
