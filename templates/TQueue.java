package templates;

import java.util.Queue;
import java.util.ArrayDeque;

public class TQueue {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();

        queue.add("banana");
        queue.add("apples");
        queue.add("mangos");

        System.out.println("Queue: " + queue);

        System.out.println("Poll1: " + queue.poll());
        System.out.println("Poll2: " + queue.poll());

        System.out.println("Queue: " + queue);
    }
}
