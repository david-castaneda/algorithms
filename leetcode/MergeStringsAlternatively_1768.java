package leetcode;

// https://leetcode.com/problems/merge-strings-alternately/description/ 
//
// Time: O(n + m)
// Space: O(n + m)
// Intuition: Use a string builder, avoid string copies which would make the solution quadratic.
public class MergeStringsAlternatively_1768 {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "def";

        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }

        while (p1 < word1.length()) {
            sb.append(word1.charAt(p1));
            p1++;
        }

        while (p2 < word2.length()) {
            sb.append(word2.charAt(p2));
            p2++;
        }

        System.out.println(sb.toString());
    }
}
