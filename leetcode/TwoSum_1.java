package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers `nums` and an integer `target`, return indices of
 * the two numbers such that they add up to target.
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 10, 5};
        int target = 8;

        int[] result = solve(nums, target);

        System.out.println(Arrays.toString(result));
    }

    static int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            int dif = target - nums[i];
            map.put(dif, i);
        }

        return new int[]{};
    }
}
