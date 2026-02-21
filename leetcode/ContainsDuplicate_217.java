package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate/description/
//
// Time: O(n)
// Space: O(1)
// Intuition: Keep track of seen elements using a set
public class ContainsDuplicate_217 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.printf("Contains duplicate? %s", Solution(nums));
    }

    static boolean Solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
