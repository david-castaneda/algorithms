package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
//
// Time: O(n * mlogm)
// Space: O(m * n)
// Intuition: Sort each word, use the sorted word as the key in a map.
// The value will be a list of every string that maps to the sorted key.
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = new HashMap<>();

        // O(n)
        for (String s : input) {
            char[] c = s.toCharArray();
            Arrays.sort(c); // O(mlogm)
            String key = new String(c);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        System.out.printf("output: %s", result);

    }
}
