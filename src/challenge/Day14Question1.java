package challenge;

public class Day14Question1 {

    class Node{

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head=null;
    Node tail=null;
    int size=0;

    public void addNode(int data)
    {
        Node node=new Node(data);
        if(head==null)
        {
            head=node;
            size++;
        }else
        {
            tail.next=node;
            size++;
        }
        tail=node;
    }


    public void display()
    {
        Node current=head;
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list");

        while (current!=null)
        {

            System.out.print(current.value+ " ");
            current=current.next;
        }
        System.out.println();

    }

    public Boolean findValueExist(int value)
    {
        Node current=head;
        if(head==null)
        {
            return false;
        }
        while(current!=null)
        {
            if(current.value==value)
            {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public void insertInMiddle(int value,int position)
    {
        Node newNode=new Node(value);
        Node current=head;
        int counter=0;
        if(position<size)
        {
            while(current!=null)
            {
                //1->2->3->4->5
                if(counter==position-1)
                {
                    Node temp=current.next;
                    current.next=newNode;
                    newNode.next=temp;
                    size++;
                    break;
                }
                else {
                    counter++;
                    current=current.next;
                }
            }

        }
        return;
    }

    public void delete(int position)
    {

        Node current=head;

        if(head==null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        int counter=0;
        while (current!=null)
        {
            if(counter==position-1)
            {
                //main logic
                current.next=current.next.next;
                System.out.println("Element is deleted from the position "+(counter+1));
                break;

            }else
            {
                counter++;
                current=current.next;
            }

        }



    }

    public void removeDuplicates()
    {
        Node current =head;
        if(head==null)
        {
            System.out.println("No element found");
        }

        while(current!=null)
        {
            Node headNext=current.next;

            while (headNext!=null && current.value == headNext.value)
            {
                headNext=headNext.next;
            }
            current.next=headNext;
            current=current.next;
        }
    }

    public void reverseLinkedList()
    {
        Node curr=head;
        Node prev=null;
        while (curr!=null)
        {
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        System.out.println(prev.value);
    }

    public static void main(String[] args) {
//        LinkedListDay13Question2  linkedList=new LinkedListDay13Question2();
//        linkedList.addNode(1);
//        linkedList.addNode(2);
//        linkedList.addNode(3);
//        linkedList.addNode(4);
//        linkedList.addNode(5);
//        linkedList.display();
//        System.out.println(linkedList.size);
//        Boolean response=linkedList.findValueExist(5);
//        System.out.println(response);
//        linkedList.insertInMiddle(7,4);
//        linkedList.display();
//
//        linkedList.delete(4);
//        linkedList.display();

        Day14Question1  linkedList2=new Day14Question1();
        linkedList2.addNode(1);
        linkedList2.addNode(2);
        linkedList2.addNode(2);
        linkedList2.addNode(3);
        linkedList2.addNode(4);
        linkedList2.reverseLinkedList();
        linkedList2.display();
    }



}


