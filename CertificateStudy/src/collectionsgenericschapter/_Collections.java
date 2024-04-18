package collectionsgenericschapter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _Collections {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
//        factoryMethods();
//        arrayDeque();
//        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }


    public static void factoryMethods() {
        String[] array = new String[] {"Alpha", "Beta", "Charlie"};
        List<String> asList = Arrays.asList(array);
        List<String> listOf = List.of(array);
        List<String> copyOf = List.copyOf(asList);

        array[0] = "Delta";     // changes to the array 'write through' to the list
        System.out.println(Arrays.toString(array)); // [Delta, Beta, Charlie]
        System.out.println(asList);                 // [Delta, Beta, Charlie

        asList.set(1, "Echo");  // changes to the list 'write through' to the array
        System.out.println(Arrays.toString(array)); // [Delta, Echo, Charlie]
        System.out.println(asList);                 // [Delta, Echo, Charlie]
    }

    public static void linkedListQueue() {
        // A FIFO queue
        Queue<Integer> queue = new LinkedList<>();
        // add() inserts into queue (throws exception if no space exists - if capacity restricted)
        // offer() inserts into queue (returns false if no space exists - capacity restricted)
        queue.add(1);        // Head -> [1]
        queue.offer(2);   // Head -> [1,2]
        queue.add(3);       // Head -> [1,2,3]
        queue.offer(4);  // Head -> [1,2,3,4]
        // element() retrieves but does not remove the head of the queue (throws exception if queue empty)
        // peek() retrieves but does not remove the head of the queue (returns null if queue empty)
        System.out.println(queue.element());    // 1
        System.out.println(queue.peek());       // 1
        System.out.println(queue);              // [1,2,3,4]
        // remove() retrieves and removes the head of this queue (throws exception if queue empty)
        // poll() retrieves and removes the head of this queue (returns null if this queue is empty)
        System.out.println(queue.remove());     // 1    head -> [2,3,4]
        System.out.println(queue.poll());       // 2    head -> [3,4]
        System.out.println(queue);              // [3,4]
    }

    public static void arrayDeque() {
        // Deque = "doubly ended que". Supports element insertion/removal at both ends.
        // ArrayDeque - resizeable-array implementation of the Deque interface (no capacity restrictions)
        Deque<Integer> deque = new ArrayDeque<>();
        // add at front (head)
        deque.add(1);
        deque.addFirst(2);      // addFirst throws exception if deque is full
        deque.offerFirst(3);    // offerFirst returns null/false if deque is full
        System.out.println("Head with getFirst(): " + deque.getFirst() + "\nHead with peek(): " + deque.peek());

        // add at end (tail)
        deque.addLast(4);
        deque.offerLast(5);
        // remove from both ends
        deque.removeFirst();
        deque.pollFirst();
        deque.removeLast();
        deque.pollLast();

        System.out.println(deque); // [1]
    }

    public static void priorityQueueNaturalOrdering() {
        Queue<String> queueStrings = new PriorityQueue<>(); // alphabetical ordering
        queueStrings.add("V");
        queueStrings.add("P");
        queueStrings.add("A");

        Iterator iterator = queueStrings.iterator();
        while(iterator.hasNext()) {
            System.out.println(queueStrings.poll() + " "); // A P V
        }

        Queue<Integer> queueNums = new PriorityQueue<>(); // numberic ordering
        queueNums.add(11);
        queueNums.add(5);
        queueNums.add(2);

        Iterator<Integer> itNums = queueNums.iterator();
        while(itNums.hasNext()){
            System.out.println(queueNums.poll() + " "); // 2 5 11
        }
    }

    public static void priorityQueueDifferentOrdering(){
        // Ordering specified by a comparator at construction time
        // 1. Order by the title of the book
        // Comparator.comparing(Function)
        //  API: "Accepts a function that extracts a comparable sort key from a type T,
        //       and returns a Comparator<T> that compares by that sort key."
        //  Function<T, R>
        //      R apply(T t)
        Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());

        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle); // provide comparator to order by title
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        System.out.println("Ordering by title:");
        Iterator<Book> iterator = booksByTitle.iterator();

        while(iterator.hasNext()){
            Book poll = booksByTitle.poll();
            System.out.println(poll);
        }
    }
}
