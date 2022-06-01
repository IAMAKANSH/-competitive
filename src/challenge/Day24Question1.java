package challenge;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day24Question1 {

    public static void main(String[] args) {

        MaxBinaryHeap heap=new MaxBinaryHeap();
        heap.buildHeap(IntStream.of(4,7,3,0,9,3,2,6).toArray());
        heap.print();
        Integer max=heap.extractMax();
        System.out.println("Max is "+max);
        Integer max1= heap.extractMax();
        System.out.println("Max is "+max1);

    }

}

class MaxBinaryHeap{

    int[] heap;

    public MaxBinaryHeap() {
        this.heap=new int[8];
    }

     public void buildHeap(int[] elements)
     {
            int length=elements.length;
            int lastParent= (int) (Math.floor(length/2)-1);
            for (int i=lastParent;i>=0;i--)
            {
                bubbleDown(elements,i);

            }
            this.heap=elements;
            return;
     }

    private void bubbleDown(int[] elements, int i) {

        int length=elements.length;
        int current=elements[i];
        while (true)
        {
            int leftChildIndex=2*i+1;
            int rightChildIndex=2*i+2;
            Integer leftChild = null,rightChild;
            Integer largest=null;
            if (leftChildIndex<length)
            {
                leftChild=elements[leftChildIndex];
                if (leftChild>current)
                {
                    largest=leftChildIndex;
                }
            }
            if(rightChildIndex<length)
            {
                rightChild=elements[rightChildIndex];
                if ((largest==null && rightChild>current) || (largest!=null && rightChild>leftChild))
                {
                    largest=rightChildIndex;
                }
            }
            if (largest==null)
                break;

            elements[i]=elements[largest];
            elements[largest]=current;
            i=largest;
        }
    }

    public Integer extractMax()
    {
        Integer max=this.heap[0];
        Integer last=this.heap[this.heap.length-1];
        this.heap=Arrays.copyOf(this.heap,heap.length-1);
        if (this.heap.length>0)
        {
            this.heap[0]=last;
            this.bubbleDown(this.heap,0);
        }
        return max;
    }
    ///insert todo
    public void print() {
        Arrays.stream(heap).forEach(value -> System.out.println(value));
    }
}
