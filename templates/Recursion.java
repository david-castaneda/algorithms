package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Recursion allows you to split up complex tasks into simpler tasks
// in order to solve the overall task.
// Requirements:
// - Base case - What is the smaller piece of work (think leaf node)
// - Reduce
// - Recurse and combine
public class Recursion {

    public static void main(String[] args) {

        List<String> input = new ArrayList<>(Arrays.asList("{", "(", ")", "}"));

        helper(input);

    }

    static void helper(List<String> input) {

        // base case - compute a simple solution without recursion
        // recursive case - divide and conquer OR decrease and conquer
    }
}
