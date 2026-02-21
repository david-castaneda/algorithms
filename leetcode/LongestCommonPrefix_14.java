package leetcode;

// https://leetcode.com/problems/longest-common-prefix/description/
//
// Time: O(m * n)
// Space: O(1)
// Intuition: Find min length string. Keep a pointer and traverse each string 
// comparing the i'th character. If the i'th character is equal increase pointer.
// At the end the substring of 0 - i is the LCP.
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] input = new String[]{"flower", "flow", "flight"};
        String result = solution(input);
        System.out.printf("LCP: %s", result);
    }

    static String solution(String[] input) {
        int min = input[0].length();
        for (String s : input) {
            min = Math.min(min, s.length());
        }

        int i = 0;
        // O(m)
        while (i < min) {
            // O(n)
            for (String s : input) {
                if (s.charAt(i) != input[0].charAt(i)) {
                    return s.substring(0, i);
                }
            }
            i++;
        }

        return input[0].substring(0, i);
    }
}
