package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//
// Time: O(n)
// Space: O(1)
// Intuition: Use two pointers, each starting at opposite ends of the array (l = 0 and r = input.length - 1).
// If the sum of l + r is greater than target, increment the left pointer and otherwise increment
// the right pointer. If sum is equal that is your target.
public class TwoSum_II_InputArraySorted_167 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 10, 15};
        int target = 12;

        int[] result = solve(nums, target);

        System.out.println(Arrays.toString(result));
    }

    static int[] solve(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1}; // LC wants 1-indexed arrays 
            }

            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{};
    }
}
