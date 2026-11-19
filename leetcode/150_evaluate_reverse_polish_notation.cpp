#include <leetcode.h>

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    int evalRPN(vector<string> &tokens) {
        stack<int> stk;

        for (string &t : tokens) {
            if (std::isdigit(t.back())) {
                stk.push(std::stoi(t));
                continue;
            }

            int a = stk.top();
            stk.pop();
            int b = stk.top();
            stk.pop();

            if (t == "+") {
                stk.push(b + a);
            } else if (t == "-") {
                stk.push(b - a);
            } else if (t == "*") {
                stk.push(b * a);
            } else if (t == "/") {
                stk.push(b / a);
            }
        }

        return stk.top();
    }
};

int main() {
    vector<string> a = {"2", "1", "+", "3", "*"};
    std::cout << Solution().evalRPN(a) << std::endl;

    vector<string> b = {"4", "13", "5", "/", "+"};
    std::cout << Solution().evalRPN(b) << std::endl;
}