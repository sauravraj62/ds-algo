package dataStructures.linkedList;

public class LinkedListCrud {
    public static Node head;
    public static class Node {
        public int data;
        public Node nextNode;
    }

    public static void main(String[] args) {
        // inserting data at beginning
        printLL(head);
        insertDataAtBeginning(5);
        insertDataAtBeginning(4);
        insertDataAtBeginning(7);
        printLL(head);

        // inserting data at end
        insertDataAtEnd(10);
        insertDataAtEnd(12);
        printLL(head);
        // inserting data in between
        insertData(5, 20);
        printLL(head);

        // deleting data
        deleteNode(7);
        printLL(head);
        deleteNode(20);
        printLL(head);
        deleteNode(100);
        printLL(head);
        insertDataAtEnd(14);
        insertDataAtEnd(16);
        insertDataAtEnd(18);


        // reverse a LL
        System.out.println("LL before reversing : ");
        printLL(head);
        reverseLL();
        System.out.println("LL after reversing : ");
        printLL(head);

        // find middle
        findMiddle();
        insertDataAtEnd(2);
        printLL(head);
        findMiddle();

        // find loop, remove loop, find length of loop

        Node lastNode = findExistingNode(2);
        Node middleNode = findExistingNode(12);

        initiateLoop(lastNode, middleNode);
        Node nodeInsideTheLoop = detectLoop();
        int lengthOfLoop = findLengthIfLoop(nodeInsideTheLoop);
        removeLoop(lengthOfLoop);
        printLL(head);
        Node currentNode = head;
        printReverseWithoutReversing(currentNode);
        System.out.println();
    }

    private static void printReverseWithoutReversing(Node currentNode) {
        if(currentNode == null) {
            return;
        }
        printReverseWithoutReversing(currentNode.nextNode);
        System.out.print(currentNode.data + " ");
    }

    private static void removeLoop(int lengthOfLoop) {
        Node firstPointer = head;
        Node secondPointer = findNodeAtDistance(lengthOfLoop);
        while(secondPointer.nextNode != firstPointer) {
            firstPointer = firstPointer.nextNode;
            secondPointer = secondPointer.nextNode;
        }
        secondPointer.nextNode = null;
    }

    private static Node findNodeAtDistance(int distance) {
        Node current = head;
        distance--;
        while (distance != 0) {
            distance--;
            current = current.nextNode;
        }
        return current;
    }

    private static int findLengthIfLoop(Node nodeInsideTheLoop) {
        if(nodeInsideTheLoop == null) {
            System.out.println("Loop doesn't exists.");
            return 0;
        }
        Node currentNode = nodeInsideTheLoop.nextNode;
        int length = 1;
        while(currentNode != nodeInsideTheLoop) {
            length++;
            currentNode = currentNode.nextNode;
        }
        System.out.println("Length of Loop : " + length);
        return length;
    }

    private static Node detectLoop() {
        if(head == null) {
            System.out.println("LinkedList is empty");
            return null;
        }
        Node slow = head;
        Node fast = head.nextNode;
        while(fast != null && fast.nextNode != null && slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        if(slow != null && slow == fast) {
            System.out.println("Loop detected in Linked List.");
            return slow;
        } else {
            System.out.println("Loop doesn't exists in LinkedList.");
            return null;
        }
    }

    private static void initiateLoop(Node lastNode, Node middleNode) {
        lastNode.nextNode = middleNode;
    }

    private static void findMiddle() {
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }

        Node slow = head;
        Node fast = head.nextNode;
        while(fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        System.out.println("Middle element : " + slow.data);
    }

    private static void reverseLL() {
        Node current = head;
        Node prev = null;
        Node nextOfCurrentNode;
        while(current != null) {
            nextOfCurrentNode = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = nextOfCurrentNode;
        }
        head = prev;
    }

    private static void deleteNode(int dataToBeDeleted) {
        Node currentNode = head;
        Node prevNode = null;
        if(currentNode != null && currentNode.data == dataToBeDeleted) {
            head = currentNode.nextNode;
            return;
        }
        while(currentNode != null && currentNode.data != dataToBeDeleted) {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if(currentNode == null) {
            System.out.println("No such node exists : " + dataToBeDeleted);
            return;
        }
        prevNode.nextNode = currentNode.nextNode;
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