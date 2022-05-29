package dataStructures.linkedList;

public class LinkedListCrud {
    public static Node head;
    public static class Node {
        public int data;
        public Node nextNode;
    }

    public static void main(String[] args) {
        printLL(head);

        // inserting data at the beginning
        insertDataAtBeginning(5);
        insertDataAtBeginning(4);
        insertDataAtBeginning(7);
        printLL(head);

        // inserting data at the end
        insertDataAtEnd(10);
        insertDataAtEnd(12);
        printLL(head);

        // inserting data in between
        insertData(5, 20);
        printLL(head);

        // reverse LL
        reverseLL();
        printLL(head);

        // find Middle
        findMiddle();
        deleteNode(5);
        findMiddle();
        printLL(head);

        // delete a node
        deleteNode(12);
        printLL(head);
        deleteNode(7);
        printLL(head);

        // inserting more element and then we'll make a loop in LL
        insertDataAtEnd(15);
        insertDataAtEnd(20);
        insertDataAtEnd(25);
        insertDataAtEnd(30);
        insertDataAtEnd(35);
        insertDataAtEnd(40);
        insertDataAtEnd(45);
        printLL(head);
        Node fifthNode = findExistingNode(20);
        Node lastNode = findExistingNode(45);
        initiateLoop(fifthNode, lastNode);
        Node nodeInLoop = detectLoopInLL();
        findLengthOfLoop(nodeInLoop);
    }

    private static void findLengthOfLoop(Node nodeInLoop) {
        if(nodeInLoop != null) {
            int length = 1;
            Node current = nodeInLoop.nextNode;
            while(current != nodeInLoop) {
                current = current.nextNode;
                length++;
            }
            System.out.println("Length of loop : " + length);
        }
    }

    private static Node detectLoopInLL() {
        Node slow = head;
        Node fast = head.nextNode;
        while(slow != null && fast != null && fast.nextNode!= null && slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        if(slow != null && slow == fast) {
            System.out.println("Loop detected.");
            return slow;
        } else {
            System.out.println("Loop not exists.");
            return null;
        }
    }

    private static void initiateLoop(Node fifthNode, Node lastNode) {
        lastNode.nextNode = fifthNode;
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

    private static void deleteNode(int dataToBeDeleted) {
        Node current = head;
        Node prev = null;
        if(current != null && current.data == dataToBeDeleted) {
            head = current.nextNode;
            return;
        }
        while(current != null && current.data != dataToBeDeleted) {
            prev = current;
            current = current.nextNode;
        }

        if(current == null) {
            System.out.println("No such element exists in LL");
            return;
        }
        prev.nextNode = current.nextNode;
    }

    private static void reverseLL() {
        Node prev = null;
        Node nextOfCurrentNode;
        Node current = head;
        while(current != null) {
            nextOfCurrentNode = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = nextOfCurrentNode;
        }
        head = prev;
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