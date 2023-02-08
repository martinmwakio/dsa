package fundamentals;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public static class Node {
        Node left = null;
        Node right = null;
        Integer data;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private void breadthFirstSearch(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.print(MessageFormat.format("{0} ", currentNode.data));
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    private void depthFirstSearch(Node root) {
        if (root == null) {
            return;
        }
        depthFirstSearch(root.left);
        depthFirstSearch(root.right);
        System.out.print(MessageFormat.format("{0} ", root.data));
    }

    /*lookup a key in a binary search tree*/
    private boolean lookup(Node node, Integer value) {
        if (node == null) {
            return false;
        }
        if (value < node.data && node.left != null) {
            return lookup(node.left, value);
        }
        if (value > node.data && node.right != null) {
            return lookup(node.right, value);
        }
        return value == node.data;
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BinarySearchTree.Node root = new BinarySearchTree.Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(7);

        System.out.println("Print depth first search");
        binarySearchTree.depthFirstSearch(root);
        System.out.println("\nPrint breadth first search");
        binarySearchTree.breadthFirstSearch(root);
        System.out.println("\nSearching elements in tree");

        int[] values = {5, 8, 15, 10, 1, 7, 4};
        for (int v : values) {
            System.out.println(MessageFormat.format("{0} exists in tree: {1}", v, binarySearchTree.lookup(root, v)));
        }
    }
}
