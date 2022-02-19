package topic.heap;

public class MaxHeap {

    private int[] heap;
    private int capacity;
    private int pointer;

    public MaxHeap(int capacity) {
        this.capacity=capacity;
        this.pointer =0;
        this.heap=new int[capacity];
    }

    private int parent(int pos)
    {
        return (pos-1)/2;
    }
    private int leftChild(int pos)
    {
        return (2*pos)+1;
    }
    private int rightChild(int pos)
    {
        return (2*pos)+2;
    }
    private Boolean isLeaf(int pos)
    {
        if(pos>(pointer/2) && pos<=pointer)
            return true;
        return false;
    }
    private void maxHeapify(int pos)
    {
        if(isLeaf(pos))
            return;
        if(heap[pos]<heap[leftChild(pos)] || heap[pos]>heap[rightChild(pos)])
        {
            if(heap[leftChild(pos)]>heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));

            }
        }

    }
    public int extractMax()
    {
        int popped=heap[0];
        heap[0]=heap[pointer--];
        maxHeapify(0);

        return popped;
    }
    private  void swap(int lPos,int rPos)
    {
        int temp=heap[lPos];
        heap[lPos]=heap[rPos];
        heap[rPos]=temp;
    }
    public void insert(int element)
    {
        heap[pointer]=element;
        int current=pointer;
        while (heap[current]>heap[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }
        pointer++;
    }
    public void print()
    {
       for (int i=0;i<pointer/2;i++)
       {
           System.out.println("Parent Node: "+heap[i]);
           if(leftChild(i)<pointer)
           {
               System.out.println("left child node :"+heap[leftChild(i)]);
           }
           if(rightChild(i)<pointer)
           {
               System.out.println("right child node :"+heap[rightChild(i)]);
           }
       }
    }
}
