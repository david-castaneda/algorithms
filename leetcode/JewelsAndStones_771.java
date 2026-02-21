package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/jewels-and-stones/description/
// 
// Time: O(m + n)
// Space: O(m)
// Intuition: Store jewels in a set for O(1) look up.
public class JewelsAndStones_771 {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        Set<Character> set = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for (Character c : stones.toCharArray()) {
            if (set.contains(c)) {
                count += 1;
            }
        }

        System.out.printf("How many stones are jewels? %d", count);
    }
}
