package dataStructures.linkedList;

import java.util.Objects;


// In Java and Python, automatic garbage collection happens, so deleting a linked node/list is easy.


public class LinkedListCrud {
    public static Node head;
    public static Node left;
    public static class Node {
        public int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node next;
    }

    public static void main(String[] args) {
        // insert at head
        insertFront(5);
        insertFront(4);
        insertFront(3);
        printLL();

        // insert at end
        insertAtEnd(2);
        insertAtEnd(1);
        printLL();

        // delete node
        deleteNode(5);
        deleteNode(1);
        printLL();

        insertFront(5);
        insertFront(1);
        printLL();

        // node at middle
        // odd
        printMiddle();
        insertFront(6);
        printLL();
        // even
        printMiddle();

        // detect loop
        detectLoop();
        Node last = makeLoop();
        detectLoop();
        calculateCycleLength();
        last.setNext(null); // removing cycle
        detectLoop();

        printLL();
        // swap two nodes without swapping data
        swapNodes(5, 4);

        // check if linkedList is palindrome or not   - VVI
        left = head;
        if(checkIfPalindrome(head)) {
            System.out.println("LL is palindrome");
        } else {
            System.out.println("LL is not palindrome");
        }
        head = null;
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(2);
        insertAtEnd(1);
        printLL();
        left = head;
        if(checkIfPalindrome(head)) {
            System.out.println("LL is palindrome");
        } else {
            System.out.println("LL is not palindrome");
        }

        // intersection point of two Linked Lists
        findIntersectionPoint();

        // Segregate even and odd nodes in a Linked List - VVI
        segregateOddEvenNodes();

        // reverse a LL - VVVVVVVI
        head = null;
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);
        System.out.println("Reversing LL...");
        printLL();
        reverse();
        printLL();

    }

    private static void reverse() {
        // Approach : Reverse Link and make head as last of the LL
        Node prev = null;
        Node current = head;
        Node nextNode;
        while(Objects.nonNull(current)) {
            nextNode = current.getNext();
            current.setNext(prev);
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    private static void segregateOddEvenNodes() {
//        The idea is to get pointer to the last node of list.
//        And then traverse the list starting from the head node and move the odd valued nodes from their current position to end of the list.
    }

    private static void findIntersectionPoint() {
        // find lengths of both LL, say l1 >= l2
//        if(l1 == l2) head is intersection point
//        else, say k = l1 - l2, ignore first k nodes of longest LL, and then start iterating both LLs, first node which are same is the intersection point


//        or
//        Using Two pointers :
//
//        Initialize two pointers ptr1 and ptr2  at the head1 and  head2.
//        Traverse through the lists,one node at a time.
//        When ptr1 reaches the end of a list, then redirect it to the head2.
//                similarly, when ptr2 reaches the end of a list, redirect it the head1.
//        Once both of them go through reassigning, they will be equidistant from
//        the collision point
//        If at any node ptr1 meets ptr2, then it is the intersection node.
//        After second iteration if there is no intersection node it returns NULL.
    }

    private static boolean checkIfPalindrome(Node right) {
        // 1. Store elements in stack and then check.
        // 2. Reverse second half of LL and then compare first and second half, then restore by reversing second half again
        // 3. Check recursively
        if(Objects.isNull(right)) return true;

        boolean checkSubList = checkIfPalindrome(right.next);

        if(!checkSubList) return false;

        boolean valueMatched = left.getVal() == right.getVal();

        left = left.getNext();

        return valueMatched;
    }

    private static void swapNodes(int i, int i1) {
        //
    }

    private static void calculateCycleLength() {
        Node cycleNode = detectLoop();
        Node temp = cycleNode.getNext();
        int length = 1;
        while(temp != cycleNode) {
            length++;
            temp = temp.getNext();
        }

        System.out.println("Length of cycle : " + length);
    }

    private static Node makeLoop() {
        Node temp = head, last = head;
        while(Objects.nonNull(last.getNext())) {
            if(last.getVal() == 5) {
                temp = last;
            }
            last = last.getNext();
        }
        last.setNext(temp);
        return last;
    }

    private static Node detectLoop() {
        Node slow = head, fast = head.getNext();
        while(Objects.nonNull(slow) && Objects.nonNull(fast) && Objects.nonNull(fast.getNext())
            && slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if(slow == fast) {
            System.out.println("Cycle found...");
            return slow;
        } else {
            System.out.println("Cycle not found...");
            return null;
        }
    }

    private static void printMiddle() {
        Node slow = head, fast = head;
        while(Objects.nonNull(slow) && Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println("Middle node is : " + slow.getVal());
    }

    private static void deleteNode(int i) {
        Node temp = head;
        Node prev = null;
        while(Objects.nonNull(temp) && temp.getVal() != i) {
            prev = temp;
            temp = temp.getNext();
        }
        if(Objects.isNull(prev)) {
            head = head.getNext();
        } else {
            prev.setNext(temp.getNext());
        }

    }

    private static void insertAtEnd(int i) {
        if(Objects.isNull(head)) {
            head = new Node();
            head.setVal(i);
            head.setNext(null);
            return;
        }
        Node temp = head;
        while(Objects.nonNull(temp.getNext())) {
            temp = temp.getNext();
        }
        Node newNode = new Node();
        newNode.setVal(i);
        newNode.setNext(null);
        temp.next = newNode;
    }

    private static void printLL() {
        Node temp = head;
        while(Objects.nonNull(temp)) {
            System.out.print(temp.getVal() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    private static void insertFront(int i) {
        Node newNode = new Node();
        newNode.setVal(i);
        newNode.setNext(null);
        if(Objects.isNull(head)) {
            head = newNode;
            return;
        }
        newNode.setNext(head);
        head = newNode;
    }
}