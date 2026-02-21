package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity: O(n^2)
// Space complexity: O(n)
// Stable: No
public class BubbleSort {

    static List<Integer> arr = new ArrayList<>(Arrays.asList(7, 92, 15, 63, 28, 49, 82, 10, 55, 76));

    public static void main(String[] args) {
        System.out.printf("Input: %s\n", arr);

        // Left-to-right loop
        for (int i = 0; i < arr.size(); i++) {

            // Right-to-left loop
            for (int j = arr.size() - 1; j > i; j--) {

                // When the left number is greater than current (coming from right-to-left)
                // then we swamp/bubble/shift the number to the left
                if (arr.get(j - 1) > arr.get(j)) {
                    int tmp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, tmp);
                }

            }
        }

        System.out.printf("Output: %s\n", arr);
    }
}
