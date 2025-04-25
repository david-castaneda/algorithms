package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// You’re given:

// A 2D array: each row is a list of choices, and you must pick one number from each row.
// A string of words: the number of words equals the number of rows.
// You need to check:
//
// Is there any combination of choices — one from each row — such that the mapping (number ↔ word) is valid?
//
// array=[ [1,2] , [1,4,5] , [6] string = “hello hello person” -> true 
// array=[ [1,3] , [1] , [3] string = “hello bye person” -> false 
// Fails since person must be 3 and bye must be 1. 

public class WordMapping2D {

    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(
                List.of(1, 2),
                List.of(1, 4, 5),
                List.of(1, 6));
        String str = "hello hello person";
        String[] words = str.split(" ");

        boolean result = helper(arr, words, 0, new HashMap<>(), new HashMap<>());

        System.out.println("Has mapping? " + result);
    }

    static boolean helper(List<List<Integer>> arr, String[] str, int row, Map<Integer, String> numToWord,
            Map<String, Integer> wordToNum) {
        if (row == str.length) {
            return true; // reached end of word
        }

        String curr = str[row];

        for (int num : arr.get(row)) {

            boolean numMapped = numToWord.containsKey(num);
            boolean wordMapped = wordToNum.containsKey(curr);

            String mappedWord = numToWord.get(num);
            Integer mappedNum = wordToNum.get(curr);

            if (numMapped && !mappedWord.equals(curr) ||
                    wordMapped && !mappedNum.equals(num)) {
                continue; // skip; word already mapped
            }

            boolean addedNum = false, addedWord = false;

            if (!numMapped) {
                numToWord.put(num, curr);
                addedNum = true;
            }
            if (!wordMapped) {
                wordToNum.put(curr, num);
                addedWord = true;
            }

            // Try next row
            if (helper(arr, str, row + 1, numToWord, wordToNum)) {
                return true;
            }

            // Backtrack
            if (addedNum) {
                numToWord.remove(num);
            }
            if (addedWord) {
                wordToNum.remove(curr);
            }
        }

        return false; // no valid picks in this row
    }
}
