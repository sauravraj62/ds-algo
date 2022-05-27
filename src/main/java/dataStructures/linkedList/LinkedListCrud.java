package dataStructures.linkedList;

public class LinkedListCrud {
    public static Node head;
    public static class Node {
        public int data;
        public Node nextNode;
    }

    public static void main(String[] args) {
        printLL(head);
        insertDataAtBeginning(5);
        insertDataAtBeginning(4);
        insertDataAtBeginning(7);
        printLL(head);
        insertDataAtEnd(10);
        insertDataAtEnd(12);
        printLL(head);
        insertData(5, 20);
        printLL(head);
    }

    private static void insertData(int existingData, int insertingData) {
        Node existingNode = findExistingNode(existingData);
        Node newNode = new Node();
        newNode.data = insertingData;
        newNode.nextNode = null;
        if(existingNode == null) {
            System.out.println("No such data exist in LL");
            return;
        }
        Node nextNode = existingNode.nextNode;
        existingNode.nextNode = newNode;
        newNode.nextNode = nextNode;
    }

    private static Node findExistingNode(int existingData) {
        Node current = head;
        while(current != null && current.data != existingData) {
            current = current.nextNode;
        }
        return current;
    }

    private static void insertDataAtEnd(int dataToBeInsertedAtEnd) {
        Node lastNode = getLastNode();
        Node newNode = new Node();
        newNode.data = dataToBeInsertedAtEnd;
        newNode.nextNode = null;

        if(lastNode == null) {
            head = newNode;
            return;
        }

        lastNode.nextNode = newNode;
    }

    private static Node getLastNode() {
        Node current = head;
        while(current != null && current.nextNode != null) {
            current = current.nextNode;
        }
        return current;
    }

    private static void insertDataAtBeginning(int insertingData) {
        Node newNode = new Node();
        newNode.data = insertingData;

        newNode.nextNode = head;
        head = newNode;
    }

    private static void printLL(Node head) {
        if(head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
        }
        System.out.println();
    }
}