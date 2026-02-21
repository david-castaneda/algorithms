package arrays;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    public static void main(String[] args) {
        String[] input = new String[]{"a", "b", "c"};
        List<List<String>> slate = new ArrayList<>();

        // initiate
        backtrack(0, input, slate, new ArrayList<>());

        System.out.println(slate.toString());

    }

    static void backtrack(int i, String[] input, List<List<String>> slate, List<String> cur) {
        // 1. base case - add snapshot
        if (i == input.length) {
            slate.add(new ArrayList<>(cur)); // make sure to clone
            return;
        }

        // 2. recurse down this path - usually not adding the value
        backtrack(i + 1, input, slate, cur);

        // 3. modify state - append the value
        cur.add(input[i]);

        // 4. recurse down this new path - usually adding the new value
        backtrack(i + 1, input, slate, cur);

        // 5. modify state - remove the value
        cur.remove(cur.size() - 1);
    }
}
