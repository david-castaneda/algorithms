package leetcode;

// https://leetcode.com/problems/reverse-string/description/
// 
// Time: O(n)
// Space: O(1)
// Intuition: Two pointer squeeze method.
public class ReverseString_344 {

    public static void main(String[] args) {
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd'};

        int l = 0, r = input.length - 1;
        while (l < r) {
            char tmp = input[l];
            input[l] = input[r];
            input[r] = tmp;
            l++;
            r--;
        }

        System.out.printf("Reverse string: %s", new String(input));
    }
}
