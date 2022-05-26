package challenge;

import java.util.Scanner;

public class Day18Queue {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Queue queue=new Queue();
        while(true)
        {
            System.out.println("Enter 1-add in queue 2-pop from queue and 3 exit");
            int res=sc.nextInt();
            if(res==1)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                queue.enqueue(ele);
            }
            else if(res==2)
            {
                queue.deque();
            }
            else
            {
                break;
            }
        }
        System.out.println(queue);
    }
}
class NodeQueue{

    public Integer value;
    public NodeQueue next;

    public NodeQueue(Integer value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "NodeQueue{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
class Queue{

    private NodeQueue first;
    private NodeQueue last;
    private Integer size;

    public Queue() {
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void enqueue(Integer value)
    {
        NodeQueue node=new NodeQueue(value);
        if(this.first==null)
        {
           this.first=node;
           this.last=node;
        }
        this.last.next=node;
        this.last=node;
        this.size++;
    }

    public void deque()
    {
        if(this.size==0)
        {
            return ;
        }
        NodeQueue removingNode=this.first;
        this.first=this.first.next;
        size--;
        if(this.size==0)
        {
            this.last=null;
        }
        return;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}
