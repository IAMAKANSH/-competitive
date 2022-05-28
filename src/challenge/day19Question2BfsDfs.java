package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day19Question2BfsDfs {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        BinarySearchTree tree=new BinarySearchTree();
        while (true)
        {
            System.out.println("Enter 1-insert 2-remove 3-find 4-exit");
            int res=sc.nextInt();

            if(res==1)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                tree.insert(ele);
            }
            else if(res==3)
            {
                System.out.println("Enter the element");
                int ele=sc.nextInt();
                NodeTree response=tree.find(ele);
                System.out.println(response);
            }
            else
            {
                break;
            }
        }
        System.out.println(tree);
        NodeTree temp= tree.root;
        List<Integer> arr=new ArrayList<>();
        QueueBfs queueBfs=new QueueBfs();
        while(temp!=null)
        {


        }


    }
}
class NodeBfs{

    public Integer value;
    public NodeBfs next;

    public NodeBfs(Integer value) {
        this.value = value;
        this.next=null;
    }

    @Override
    public String toString() {
        return "NodeBfs{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
class QueueBfs{

    public NodeBfs first;
    public NodeBfs last;
    public Integer size;

    public QueueBfs() {

        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void insert(Integer value)
    {
        NodeBfs node=new NodeBfs(value);

        if(this.first==null)
        {
            this.first=node;
            this.last=node;
        }
        NodeBfs temp=this.last;
        this.last.next=node;
        this.last=node;
        size++;
    }

    public NodeBfs remove()
    {
        if(this.size==0)
        {
            return null;
        }
        NodeBfs removingNode=this.first;
        this.first=this.first.next;
        size--;
        if(this.size==0)
        {
            this.last=null;
        }
        return removingNode;
    }

    @Override
    public String toString() {
        return "QueueBfs{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }
}