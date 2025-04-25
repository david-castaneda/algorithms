package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers `nums` and an integer `target`,
 * return indices of the two numbers such that they add up to target.
 */
public class TwoSum_1 {

    static List<Integer> nums = List.of(1, 2, 3);
    static Integer target = 2;

    public static void main(String[] args) {
        List<Integer> result = solve(nums, target);
        System.out.println(result.size());
        assert result.size() == 2 : "Array length is not 2.";
    }

    static List<Integer> solve(List<Integer> nums, Integer target) {
        return List.of(1, 2, 3);
    }
}