package leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    public static void main(String[] args) {
        List<Integer> input = List.of(10, 22, 19, 3);
        int k = 2;

        Queue<Integer> minHeap = new PriorityQueue<>(); // min-heap by default

        for (int num : input) {
            minHeap.add(num);

            if (minHeap.size() > k) { // remove smallest to keep kth largest
                minHeap.poll();
            }
        }

        System.out.println("Kth largest: " + minHeap.peek());
    }
}
