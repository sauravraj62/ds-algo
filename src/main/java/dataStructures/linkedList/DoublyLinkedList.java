package dataStructures.linkedList;

public class DoublyLinkedList {
    public static Node head;

    public static class Node {
        public int data;
        public Node next;
        public Node prev;
    }

    public static void main(String[] args) {
        insertAtHead(5);
        insertAtHead(10);
        insertAtHead(15);
        insertAtHead(20);
        printDLL();
        insertAtEnd(25);
        insertAtEnd(30);
        insertAtEnd(35);
        printDLL();
        printDllInReverse();
        insertAfterNode(5, 100);
        printDLL();
        printDllInReverse();
        reverseDLL();
        printDLL();
    }

    private static void reverseDLL() {
        Node prev = null;
        Node current = head;
        while(current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        if(prev != null) {
            head = prev.prev;
        }
    }

    private static void insertAfterNode(int existingData, int newData) {
        Node existingNode = findExistingNode(existingData);
        Node newNode = new Node();
        newNode.data = newData;
        Node nextNode = existingNode.next;

        existingNode.next = newNode;
        newNode.prev = existingNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    private static Node findExistingNode(int existingData) {
        Node current = head;
        while(current != null && current.data != existingData) {
            current = current.next;
        }
        return current;
    }

    private static void printDllInReverse() {
        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        while (lastNode != null) {
            System.out.print(lastNode.data + " ");
            lastNode = lastNode.prev;
        }
        System.out.println();
    }

    private static void insertAtEnd(int newData) {
        Node newNode = new Node();
        newNode.data = newData;
        Node lastNode = head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
        newNode.prev = lastNode;
        newNode.next = null;
    }

    private static void printDLL() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static void insertAtHead(int newData) {
        Node newNode = new Node();
        newNode.data = newData;
        newNode.next = head;
        newNode.prev = null;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }
}
