package dataStructure.trees;

public class BinarySearchTree {
    Node root;

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value <= root.data) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public boolean contains(int value) {
        return containsVal(root, value);
    }

    private boolean containsVal(Node root, int value) {
        if (root.data == value) {
            return true;
        } else if (value <= root.data) {
            if (root.left == null) {
                return false;
            } else {
                return containsVal(root.left, value);
            }
        } else {
            if (root.right == null) {
                return false;
            } else {
                return containsVal(root.right, value);
            }
        }
    }


    public void printInOrder() {
        inOrderPrint(root);
    }

    private void inOrderPrint(Node root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.println(root.data);
            inOrderPrint(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();
        bs.insert(10);
        bs.insert(5);
        bs.insert(20);
        bs.insert(6);
        bs.insert(4);

        System.out.println("BST contains: 5 " + bs.contains(5));
        bs.printInOrder();
    }
}
