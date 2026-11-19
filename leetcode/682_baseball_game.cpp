#include <leetcode.h>

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    int calPoints(vector<string> &operations) {
        stack<int> stk;

        for (string &op : operations) {
            if (std::isdigit(op.back())) {
                stk.push(std::stoi(op));
            } else if (op == "+") {
                int a = stk.top();
                stk.pop();
                int b = stk.top();
                stk.push(a);
                stk.push(a + b);
            } else if (op == "D") {
                stk.push(stk.top() * 2);
            } else if (op == "C") {
                stk.pop();
            }
        }

        int ans = 0;

        while (!stk.empty()) {
            ans += stk.top();
            stk.pop();
        }

        return ans;
    }
};

int main() {
    vector<string> ops1 = {"5", "2", "C", "D", "+"};
    std::cout << Solution().calPoints(ops1) << std::endl;

    vector<string> ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
    std::cout << Solution().calPoints(ops2) << std::endl;
}