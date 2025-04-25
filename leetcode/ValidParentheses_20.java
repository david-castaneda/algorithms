package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class ValidParentheses_20 {

    public static final Map<String, String> OPEN_CLOSE = Map.of(
            "{", "}",
            "(", ")",
            "[", "]");

    public static final Map<String, String> CLOSE_OPEN = Map.of(
            "}", "{",
            ")", "(",
            "]", "[");

    public static void main(String[] args) {

        List<String> inputs = List.of("]", "[", "()", "([{}])", "][]", "{}{}{}(])");

        for (String input : inputs) {
            boolean result = solve(input);
            System.out.printf("Valid parens? %s : %s\n", input, result);
        }
    }

    static boolean solve(String s) {

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            String curr = Character.toString(s.charAt(i));

            if (OPEN_CLOSE.containsKey(curr)) {
                // is open paren add it to the stack
                stack.push(curr);
            } else {
                // we have a closing paren

                // if there is nothing in the stack and we have
                // a closing paren than the input is invalid.
                if (stack.isEmpty()) {
                    return false;
                }

                String top = stack.pop();

                // check if has matching open paren
                if (!CLOSE_OPEN.get(curr).equals(top)) {
                    // if not matching exit
                    return false;
                }
            }
        }

        // if the stack isn't empty we didn't finish
        // matching parens so invalid input.
        return stack.isEmpty();
    }
}
