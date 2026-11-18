#include <leetcode.h>

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    bool isValid(string s) {
        unordered_map<char, char> pairs = {{'}', '{'}, {')', '('}, {']', '['}};

        stack<char> stk;

        for (char c : s) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if (stk.empty()) {
                    return false;
                }

                char val = stk.top();
                if (val != pairs[c]) {
                    return false;
                }

                stk.pop();
            }
        }

        return stk.empty();
    }
};

int main() {
    std::cout << boolalpha << Solution().isValid("()") << std::endl;
    std::cout << boolalpha << Solution().isValid("()[]{}") << std::endl;
    std::cout << boolalpha << Solution().isValid("([)]") << std::endl;
}