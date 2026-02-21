package leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// Intuition: Use a min-heap of size k. 
// After processing the input the kth largest is the top element.
public class KthLargest {

    public static void main(String[] args) {
        List<Integer> input = List.of(10, 22, 19, 3);
        int k = 2;

        // min-heap by default
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int num : input) {
            minHeap.add(num);

            // remove smallest to keep kth largest
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.println("Kth largest: " + minHeap.peek());
    }
}
