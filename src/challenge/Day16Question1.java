package challenge;

public class Day16Question1 {

    Node2 head;
    Node2 tail;
    int size;


    public void display()
    {
        Node2 curr=head;
        if(this.head==null)
        {
            System.out.println("Nothing to display");
        }
        while (curr!=null)
        {
            System.out.println(curr.value);
            curr=curr.next;
        }
    }
    public void removeElement(Node2 node)
    {
        if(this.head==node)
        {
            this.head=node.next;

        }
        if(this.tail==node)
        {
            this.tail=node.previous;
        }
        if(node.previous!=null)
        {
            node.previous.next=node.next;
        }
        if(node.next!=null)
        {
            node.next.previous=node.previous;
        }
        node.next=null;
        node.previous=null;
    }
    public void insert(Node2 nodePosition,Node2 givenNode)
    {
        if(this.head==givenNode && this.tail==givenNode)
        {
            return;
        }
        this.removeElement(givenNode);
        givenNode.previous=nodePosition.previous;
        givenNode.next=nodePosition;

        if(nodePosition==this.head)
        {
            this.head=givenNode;
        }
        else
        {
            nodePosition.previous.next=givenNode;
        }
        nodePosition.previous=givenNode;
    }
    public static void linkNode(Node2 n1,Node2 n2)
    {
        n1.next=n2;
        n2.previous=n1;
    }
    public static void main(String[] args) {

        Day16Question1 day16Question1=new Day16Question1();
        Node2 n1=new Node2(1);
        Node2 n2=new Node2(2);
        Node2 n3=new Node2(3);
        Node2 n4=new Node2(4);
        Node2 n5=new Node2(5);
        linkNode(n1,n2);
        linkNode(n2,n3);
        linkNode(n3,n4);
        linkNode(n4,n5);
        day16Question1.head=n1;
        day16Question1.tail=n5;
        day16Question1.size=5;
        day16Question1.display();
//        System.out.println("==========================");
//        day16Question1.removeElement(n3);
//        day16Question1.display();
        System.out.println("==========================");
        day16Question1.insert(n2,n3);
        day16Question1.display();

    }


}

class Node2{

    int value;
    Node2 next;
    Node2 previous;

    public Node2(int value, Node2 next, Node2 previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node2() {
    }

    public Node2(int value) {
        this.value = value;
    }
}
