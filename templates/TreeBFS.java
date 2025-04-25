package templates;

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * Breadth-First Search (BFS) is used to explore edges and nodes of a graph.
 * Starting at the root, explores all of it's neighbors level-by-level.
 * 
 * How it works:
 * 1. Start at source node (eg. root)
 * 2. Visit the node, and mark it as visited
 * 3. Add it to the queue
 * 4. While the queue is not empty
 *    a. Poll from the queue
 *    b. Visit all unvisited neighbors
 *    c. Mark them as visited, and add them to the queue
 * 
 * Key Concepts:
 * - Queue (FIFO): BFS uses a queue to keep track of which node to visit next.
 * - Visited set: To avoid visiting the same node multiple times.
 */

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class TreeBFS {

    public static void main(String[] args) {
        /**
         * Example tree:
         * __________1_________
         * _______2______3_____
         * _____4___5__6___7___
         * 
         * Expected traversal: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        bfs(root);
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root); // enqueue the root

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll(); // dequeue

            System.out.println("Visited: " + curr.value);

            if (curr.left != null) {
                queue.add(curr.left); // enqueue left child
            }
            if (curr.right != null) {
                queue.add(curr.right); // enqueue right child
            }
        }
    }
}
