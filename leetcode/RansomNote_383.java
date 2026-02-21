package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ransom-note/description/
// 
// Time: O(m + n)
// Space: O(m)
// Intuition: Build a frequency map from the magazine string.
// Check that each letter in the ransom note is in the frequency map 
// and that there is enough remaining letters to use.
public class RansomNote_383 {

    public static void main(String[] args) {
        String ransomNote = "aaxassssddd";
        String magazine = "aabdsadasffasfssssdddx";

        boolean result = solution(ransomNote, magazine);

        System.out.printf("Can construct? %s", result);
    }

    static boolean solution(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
