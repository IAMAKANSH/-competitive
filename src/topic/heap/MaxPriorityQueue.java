package topic.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxPriorityQueue {

    public static void main(String[] args) {
        //max heap through priority queue Collections.reverseOrder()
        //by default it follow natural order(min heap)
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.add(5);
        priorityQueue.add(6);
        priorityQueue.add(17);
        priorityQueue.add(2);
        priorityQueue.add(1);

        //to iterate through all the elements
        priorityQueue.forEach(integer -> System.out.println(integer));

        //2nd approach
//        Iterator<Integer> iterator=priorityQueue.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

        //want to retrieve the max value
        int max=priorityQueue.poll();
        System.out.println(max);

        priorityQueue.forEach(integer -> System.out.println(integer));

        //want priority queue to be an array

        Object[] arr=priorityQueue.toArray();
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(i+" : "+arr[i]);
        }
/**
 * Few important points on Priority Queue are as follows:
 *
 * PriorityQueue doesn’t permit null.
 * We can’t create PriorityQueue of Objects that are non-comparable
 * PriorityQueue are unbound queues.
 * The head of this queue is the least element with respect to the specified ordering. If multiple elements are tied for least value, the head is one of those elements — ties are broken arbitrarily.
 * Since PriorityQueue is not thread-safe, so java provides PriorityBlockingQueue class that implements the BlockingQueue interface to use in java multithreading environment.
 * The queue retrieval operations poll,  remove,  peek, and element access the element at the head of the queue.
 * It provides O(log(n)) time for add and poll methods.
 * It inherits methods from AbstractQueue, AbstractCollection, Collection and Object class
 */
    }
}
