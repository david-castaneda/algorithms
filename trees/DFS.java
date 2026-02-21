package trees;

/**
 * Depth-First Search (DFS) is used to explore edges and nodes of a graph.
 * Starting at the root, explores as far as possible along a branch before
 * backtracking — like going deep down a path before checking the next.
 *
 * Types of traversals: - Pre-order (root, left, right) - Post-order (left,
 * right, root) - In-order (left, root, right)
 */
class TreeNode {

    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class DFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("--------Pre-order--------");
        preOrder(root);

        System.out.println("--------Post-order--------");
        postOrder(root);

        System.out.println("--------In-order--------");
        inOrder(root);
    }

    static void preOrder(TreeNode node) {
        System.out.println("Visited: " + node.value);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    static void postOrder(TreeNode node) {
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.println("Visited: " + node.value);
    }

    static void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println("Visited: " + node.value);
        if (node.right != null) {
            inOrder(node.right);
        }
    }
}
