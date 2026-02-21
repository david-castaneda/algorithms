// You will need to provide a package name (usually folder name) like the one below.

import java.util.ArrayDeque;
import java.util.Deque;

// A stack is a LIFO (last-in-first-out) data structure.
// It is simple and commonly used for things like keeping
// track of data, memory stacks, browser history, undo/redo,
// backtracking, syntax parsing, string reversals, parentheses matching,
// task management, and serves as a foundation for implementing algorithms.
// Prefer using `Deque` instead of `Stack` class in Java.
// Must know operations:
// push/addFirst: O(1) - push an element to the top of the stack
// pop/removeFirst: O(1) - remove an element from the top of the stack
// peek/peekFirst: O(1) - view the element at the top of the stack
public class Stack {

    // A `main` function is required.
    public static void main(String[] args) {

        // Instantiate a stack with no size limit.
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.printf("Is stack empty? %s\n", stack.isEmpty());
        System.out.printf("The top element is %s\n", stack.peek());

        stack.pop();
        stack.pop();

        System.out.printf("Is stack empty? %s\n", stack.isEmpty());
        System.out.printf("The top element is %s\n", stack.peek());

        stack.pop();
        System.out.printf("Is stack empty? %s\n", stack.isEmpty());
    }
}
