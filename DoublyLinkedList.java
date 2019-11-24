import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * This class contains the methods of Doubly Linked List.
 *
 * @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data:
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 *
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode {
        public final T data; // this field should never be updated. It gets its
        // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;

        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
            data = theData;
            prev = prevNode;
            next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    public int listLength;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        listLength = 0;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta (1)
     *
     * Justification:
     *  This function only consists of a few small operations which all have a run time of Theta(1)
     */
    public boolean isEmpty() {
        if (this.head == null && this.tail == null) {
            return true;
        }
        return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: Theta (N)
     *
     * Justification:
     *  In the worst case this function will have the run to the very end of the list which is the Nth term.
     *  All other times it will run constant operations less than N times and when we add all this up N will be the highest
     *  order term and we can drop the rest.
     */
    public void insertBefore(int pos, T data) {
        if (pos <= 0) {
            if (head == null) {
                head = new DLLNode(data, null, tail);
                tail = head;
                listLength++;
            }
            else {
                if (head == tail) {
                    head = new DLLNode(data, null, tail);
                    tail.prev = head;
                    listLength++;
                }
                else {
                    DLLNode newHead = new DLLNode(data, null, head);
                    DLLNode oldHead = new DLLNode(head.data, newHead, head.next);
                    head.next.prev = oldHead;
                    head = newHead;
                    head.next = oldHead;
                    listLength++;
                }
            }
        } else {
            if (pos >= listLength) {
                if (tail == null) {
                    tail = new DLLNode(data, head, null);
                    head = tail;
                    listLength++;
                } else {
                    if (head == tail) {
                        tail = new DLLNode(data, head, null);
                        head.next = tail;
                        listLength++;
                    } else {
                        DLLNode newTail = new DLLNode(data, tail, null);
                        DLLNode oldTail = new DLLNode(tail.data, tail.prev, newTail);
                        tail.prev.next = oldTail;
                        tail = newTail;
                        tail.prev = oldTail;
                        listLength++;
                    }
                }
            } else {
                DLLNode newNode = new DLLNode(data, null, head);
                for (int i = 0; i < pos - 1; i++) {
                    newNode.next = newNode.next.next;
                }
                newNode.prev = newNode.next;
                newNode.next = newNode.prev.next;
                newNode.prev.next = newNode;
                newNode.next.prev = newNode;
                listLength++;

            }
        }
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: Theta (N)
     *
     * Justification:
     *  Worst case this function will go through all N elements in the list
     *
     */
    public T get(int pos) {
        if (isEmpty() || pos < 0 || pos >= listLength) {
            return null;
        }
        DLLNode newNode = head;
        for(int i = 0; i < pos; i++)
        {
            newNode = newNode.next;
            if(newNode == null)
            {
                return null;
            }
        }
        if(newNode == null)
        {
            return null;
        }
        else
            return newNode.data;
    }


    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  Worst case must go through all N elements to find what to delete
     */
    public boolean deleteAt(int pos) {
        if (isEmpty() || pos < 0 || pos >= listLength)
        {
            return false;
        }
        else {
            DLLNode newNode = head;
            for (int i = 0; i < pos; i++) {
                newNode = newNode.next;
                if(newNode == null)
                {
                    return false;
                }
            }
            DLLNode prev = newNode.prev;
            DLLNode next = newNode.next;
            if(newNode == head)
            {
                head = next;
                if(listLength == 1)
                {
                    head = null;
                    tail = null;
                }
            }
            else if (newNode == tail)
            {
                tail = prev;
                if(listLength == 1)
                {
                    head = null;
                    tail = null;
                }
            }
            if(prev != null)
            {
                newNode.prev.next = next;
            }
            if(next != null)
            {
                newNode.next.prev = prev;
            }
            listLength--;
        }
        return true;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  In order the reverse the list we must go through all N elements and reverse each node
     */
    public void reverse() {
        if (!isEmpty() && listLength > 1) {
            DLLNode start = head;
            DLLNode temp = new DLLNode(head.data, null, head.next);
            for (int i = 0; i < listLength; i++) {
                start.next = start.prev;
                start.prev = temp.next;
                if (i < listLength - 1) {
                    start = temp.next;
                    temp = new DLLNode(null, temp.next, temp.next.next);
                }
            }
            temp = head;
            head = tail;
            tail = temp;
        }
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: Theta(N^2)
     *
     * Justification:
     *  We have two for loops and in the worst case we must loop through all N elements in each loop
     */
    public void makeUnique() {
        DLLNode start = head;
        for (int i = 0; i < listLength; i++) {
            for (int j = i + 1; j < listLength; j++) {
                if(get(j) != null) {
                    if (get(j).equals(start.data)) {
                        deleteAt(j);
                       j--;
                    }
                }
            }
            start = start.next;
        }
    }


    /*----------------------- STACK API
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  No looping, constant operations on the item to be pushed
     */
    public void push(T item) {

        if (item != null) {
            if (isEmpty()) {
                head = new DLLNode(item, null, null);
                tail = head;
            } else
                {
                DLLNode newNode = new DLLNode(item, null, head);
                DLLNode tempNode = new DLLNode(head.data, newNode, head.next);

                head = newNode;
                head.next = tempNode;
                tempNode.prev = head;
            }
            listLength++;
        }

    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  Operations in pop have a run time of 1 but this function calls deleteAt which has a runtime of N
     */
    public T pop() {
        if (!isEmpty()) {
            DLLNode temp = new DLLNode(head.data, null, head.next);
            T toReturn = head.data;
            deleteAt(0);
            if (temp.next != null) {
                head = temp.next;
            } else {
                head = null;
                tail = null;
            }
            return toReturn;
        }

        return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification:
     *  No looping or expensive calls, just updating the top node
     */
    public void enqueue(T item) {
        DLLNode newNode = new DLLNode(item, null, head);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else
            {
           head.prev = newNode;
           head = newNode;
        }
        listLength++;
    }

    /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: Theta(N)
     *
     * Justification:
     *  deleteAt has a runtime of N which is the highest order term.
     */
    public T dequeue() {
        if (!isEmpty()) {
            DLLNode temp = new DLLNode(tail.data, tail.prev, null);
            T toReturn = tail.data;
            deleteAt(listLength -1);
            if (temp.prev != null) {
                tail = temp.prev;
            }
            else {
                head = null;
                tail = null;
            }
            return toReturn;
        }
        return null;
    }


    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        boolean isFirst = true;

        // iterate over the list, starting from the head
        for (DLLNode iter = head; iter != null; iter = iter.next) {
            if (!isFirst) {
                s.append(",");
            } else {
                isFirst = false;
            }
            s.append(iter.data.toString());
        }

        return s.toString();
    }


}


