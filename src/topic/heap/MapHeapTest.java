package topic.heap;

public class MapHeapTest {

    public static void main(String[] args) {

        MaxHeap maxHeap=new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.print();
        System.out.println("Max value"+maxHeap.extractMax());
        maxHeap.print();
    }
}
