#include <leetcode.h>

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    string resultingString(string s) {
        stack<char> stk;

        for (char c : s) {
            if (stk.empty()) {
                stk.push(c);
                continue;
            }
            char c2 = stk.top();
            if ((c - 'a') - 1 == (c2 - 'a')    // left neighbor
                || (c - 'a') + 1 == (c2 - 'a') // right neighbor
                || (c2 == 'a' && c == 'z')     // az
                || (c2 == 'z' && c == 'a')     // za
            ) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        string res;
        res.reserve(stk.size());

        while (!stk.empty()) {
            res += stk.top();
            stk.pop();
        }

        std::reverse(res.begin(), res.end());

        return res;
    }
};

int main() {
    std::cout << Solution().resultingString("abc") << std::endl;
    std::cout << Solution().resultingString("adcb") << std::endl;
    std::cout << Solution().resultingString("zadb") << std::endl;
}