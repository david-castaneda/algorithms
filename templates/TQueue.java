package templates;

import java.util.ArrayDeque;
import java.util.Queue;

public class TQueue {

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();

        queue.offer("banana");
        queue.offer("apples");
        queue.offer("mangos");

        System.out.println("Queue: " + queue);

        System.out.println("Poll1: " + queue.poll());
        System.out.println("Poll2: " + queue.poll());

        System.out.println("Queue: " + queue);
    }
}
