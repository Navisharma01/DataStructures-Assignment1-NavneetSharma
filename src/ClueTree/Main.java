package ClueTree;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ClueTree
        ClueTree tree = new ClueTree();

        // Insert clues
        tree.insert("Golden Idol");
        tree.insert("Ancient Scroll");
        tree.insert("Sacred Gem");

        // Perform traversals
        System.out.println("\nIn-order Traversal:");
        tree.inOrder();

        System.out.println("\nPre-order Traversal:");
        tree.preOrder();

        System.out.println("\nPost-order Traversal:");
        tree.postOrder();

        // Find a clue in the tree
        System.out.println("\nFind 'Sacred Gem': " + tree.find("Sacred Gem"));
    }
}

class ClueTree {
    private Node root;

    public ClueTree() {
        this.root = null;
    }

    // Insert a new clue into the tree
    public void insert(String clue) {
        root = insertRec(root, clue);
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }

        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }

        return root;
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a clue in the tree
    public boolean find(String clue) {
        return findRec(root, clue);
    }

    private boolean findRec(Node root, String clue) {
        if (root == null) return false;
        if (root.clue.equals(clue)) return true;

        if (clue.compareTo(root.clue) < 0) {
            return findRec(root.left, clue);
        } else {
            return findRec(root.right, clue);
        }
    }

    // Node class for the tree
    private static class Node {
        String clue;
        Node left, right;

        Node(String clue) {
            this.clue = clue;
            this.left = this.right = null;
        }
    }
}
