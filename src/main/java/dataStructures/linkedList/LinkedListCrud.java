package dataStructures.linkedList;

import java.util.Objects;


// In Java and Python, automatic garbage collection happens, so deleting a linked node/list is easy.


public class LinkedListCrud {
    public static Node head;
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