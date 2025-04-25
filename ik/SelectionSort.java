package ik;

import java.util.ArrayList;
import java.util.Arrays;

// For each element iterate the list and keep track of the min. 
// Swap the min with the current element.
//
// Time complexity: O(n^2)
// Space complexity: O(1)
// Stable: No
public class SelectionSort {

    static ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(37, 92, 15, 63, 28, 49, 82, 10, 55, 76));

    public static void main(String[] args) {
        System.out.printf("Input: %s\n", arr);

        // Outer pointer
        for (int i = 0; i < arr.size(); i++) {
            // Keep track of min
            int min = i;

            // Inner pointer
            for (int j = i + 1; j < arr.size(); j++) {

                // Check if encountered new min
                if (arr.get(j) < arr.get(min)) {
                    min = j;
                }
            }

            // swap i with min
            int tmp = arr.get(i);
            arr.set(i, arr.get(min));
            arr.set(min, tmp);
        }

        System.out.printf("Output: %s\n", arr);
    }
}
