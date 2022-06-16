package dataStructures.binaryTree;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {
    public static Node root = null;
    public static boolean found = false;
    public static int count = 0;
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node sevenNode = new Node(7, null, null);
        Node sixNode = new Node(6, null, null);
        Node eightNode = new Node(8, null, null);
        Node tenNode = new Node(10, null, null);
        Node threeNode = new Node(3, sevenNode, sixNode);
        Node nineNode = new Node(9, eightNode, tenNode);
        Node root = new Node(5, threeNode, nineNode);

        System.out.println("Inorder traversal : ");
        printInorder(root);
        System.out.println();

        System.out.println("PreOrder traversal : ");
        printPreOrder(root);
        System.out.println();

        System.out.println("PostOrder traversal : ");
        printPostOrder(root);
        System.out.println();

        System.out.println("Level Order traversal : ");
        printLevelOrder(root);
        System.out.println();

        // Search a node
        found = false;
        searchNode(root, 10);
        if(!found) {
            System.out.println("Node not found with data : " + 10);
        }
        searchNode(root, 9);
        found = false;
        searchNode(root, 17);
        if(!found) {
            System.out.println("Node not found with data : " + 17);
        }


        // Nth node of inOrder traversal
        findNthNodeOfInOrder(root, 5);
        count = 0;
        findNthNodeOfInOrder(root, 1);
        count = 0;
        findNthNodeOfInOrder(root, 6);

        // boundary traversal
        System.out.println("Boundary traversal : ");
        printBoundary(root);
        System.out.println();

        Node four1 = new Node(4, null, null);
        Node five1 = new Node(5, null, null);
        Node two1 = new Node(2, four1, five1);
        Node three1 = new Node(3, null, null);
        Node root1 = new Node(1, two1, three1);
        printInorder(root1);
        System.out.println();

        Node four2 = new Node(4, null, null);
        Node five2 = new Node(5, null, null);
        Node two2 = new Node(2, five2, four2);
        Node three2 = new Node(3, null, null);
        Node root2 = new Node(1, three2, two2);
        printInorder(root2);
        System.out.println();

        if(checkIfMirrorTree(root1, root2)) {
            System.out.println("Both trees are identical.");
        } else {
            System.out.println("Both trees are not identical.");
        }
    }

    private static boolean checkIfMirrorTree(Node root1, Node root2) {
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }
        else if(root1 == null) {
            return true;
        }
        else if(root1.data != root2.data) {
            return false;
        }
        return checkIfMirrorTree(root1.left, root2.right) && checkIfMirrorTree(root1.right, root2.left);
    }

    private static void findNthNodeOfInOrder(Node node, int position) {
        if(node == null || count > position) {
            return;
        }
        findNthNodeOfInOrder(node.left, position);
        count++;
        if(count == position) {
            System.out.println("Element " + node.data + " found at position : " + position);
            return;
        }
        findNthNodeOfInOrder(node.right, position);
    }

    private static void printBoundary(Node root) {
        System.out.print(root.data + " ");
        // print left boundary
        printLeftBoundary(root.left);
        // print leave boundary
        printLeaveNodes(root.left);
        printLeaveNodes(root.right);

        // print right boundary
        printRightBoundary(root.right);
    }

    private static void printRightBoundary(Node node) {
        if(node == null) {
            return;
        }
        if(node.right != null) {
            printRightBoundary(node.right);
            System.out.print(node.data + " ");
        } else if(node.left != null) {
            printRightBoundary(node.left);
            System.out.println(node.data + " ");
        }
    }

    private static void printLeaveNodes(Node node) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }
        printLeaveNodes(node.left);
        printLeaveNodes(node.right);
    }

    private static void printLeftBoundary(Node node) {
        if(node == null) {
            return;
        }

        if(node.left != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        }
        else if(node.right != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }
    }

    private static void searchNode(Node node, int X) {
        if(node == null) {
            return;
        }
        if(node.data == X) {
            found = true;
            System.out.println("Node found with data : " + node.data);
            return;
        }
        searchNode(node.left, X);
        searchNode(node.right, X);
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // q.front()
        // q.pop()
        // q.empty()
        while(!q.isEmpty()) {
            System.out.print(q.peek().data + " ");
            if(q.peek().left != null) {
                q.add(q.peek().left);
            }
            if(q.peek().right != null) {
                q.add(q.peek().right);

            }
            q.poll();
        }
    }

    private static void printPostOrder(Node currentNode) {
        if(currentNode == null) {
            return;
        }
        printInorder(currentNode.left);
        printInorder(currentNode.right);
        System.out.print(currentNode.data + " ");
    }

    private static void printPreOrder(Node currentNode) {
        if(currentNode == null) {
            return;
        }
        System.out.print(currentNode.data + " ");
        printInorder(currentNode.left);
        printInorder(currentNode.right);
    }

    private static void printInorder(Node currentNode) {
        if(currentNode == null) {
            return;
        }
        printInorder(currentNode.left);
        System.out.print(currentNode.data + " ");
        printInorder(currentNode.right);
    }
}
