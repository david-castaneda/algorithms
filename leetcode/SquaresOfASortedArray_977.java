package leetcode;

import java.util.Arrays;

// Time: O(n)
// Space: O(n)
// Intuition: Two pointers, create new sorted array using squeeze method.
// Keep in mind that negative numbers will become postive once squared.
public class SquaresOfASortedArray_977 {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, 2, 4, 6};

        int l = 0, r = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];

        while (l < r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                result[index] = nums[l] * nums[l];
                l++;
            } else {
                result[index] = nums[r] * nums[r];
                r--;
            }
            index--;
        }

        System.out.println(Arrays.toString(result));
    }
}
