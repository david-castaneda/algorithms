package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        List<String> inputs = List.of("]", "[", "()", "([{}])", "][]", "{}{}{}(])");

        for (String input : inputs) {
            boolean isValid = solve(input);
            System.out.printf("Valid parens? %s : %s\n", input, isValid);
        }
    }

    static boolean solve(String input) {
        Map<String, String> CLOSE_OPEN = Map.of(
                "}", "{",
                ")", "(",
                "]", "[");

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            String curr = Character.toString(input.charAt(i));

            if (CLOSE_OPEN.containsKey(curr)) {
                // we may have a single closing paren, the input is invalid
                if (stack.isEmpty()) {
                    return false;
                }
                String s = stack.pop();
                // check for open match
                if (!CLOSE_OPEN.get(curr).equals(s)) {
                    // if not matching exit
                    return false;
                }
            } else {
                // is open paren add it to the stack
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
