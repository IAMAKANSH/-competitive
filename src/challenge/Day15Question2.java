package challenge;

public class Day15Question2 {

    Node head;
    Node tail;
    int size;

    public void addAtTail(int value)
    {
        Node node=new Node(value);
        if(head==null)
        {
            this.head=node;
            this.tail=this.head;
        }
        else
        {
            this.tail.next=node;
            this.tail=node;
        }
        this.size++;
        return;
    }

    public void display()
    {
        if(head==null)
        {
            System.out.println("Nothing to display");
        }
        Node curr=head;
        while(curr!=null)
        {
            System.out.println(curr.value);
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        //540+723=1263
        Day15Question2 linkedList=new Day15Question2();
        linkedList.addAtTail(0);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.display();
        System.out.println("=======================================");
        Day15Question2 linkedList2=new Day15Question2();
       linkedList2.addAtTail(3);
        linkedList2.addAtTail(2);
        linkedList2.addAtTail(7);
        linkedList2.display();
        System.out.println("=======================================");
        Day15Question2 response=addTwoLinkedList(linkedList.head,linkedList2.head);
        response.display();
    }

    public static Day15Question2 addTwoLinkedList(Node head1,Node head2)
    {
        Day15Question2 linkedListFinal=new Day15Question2();
        int carryForward=0;
        while(head1!=null || head2!=null || carryForward>0)
        {
            int v1=head1!=null?head1.value:0;
            int v2=head2!=null?head2.value:0;
            int sum=v1+v2+carryForward;
            int finalValueInResult=sum%10;
            linkedListFinal.addAtTail(finalValueInResult);
            carryForward= (int) Math.floor(sum/10);
            head1=head1==null?null:head1.next;
            head2=head2==null?null:head2.next;

        }
        return linkedListFinal;
    }
}

class Node{

    int value;
    Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node(int value) {
        this.value = value;
    }
}
