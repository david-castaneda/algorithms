#include <leetcode.h>

// Time: O(M)
// Space: (M)
class Solution {
  public:
    string decodeString(string s) {
        stack<int> counts;
        stack<string> prefixes;
        int count = 0;
        string current;

        for (char c : s) {
            if (std::isdigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(count);     // how many times to repreat
                prefixes.push(current); // what came before
                count = 0;
                current = ""; // inner block
            } else if (c == ']') {
                int times = counts.top();
                counts.pop();
                string pref = prefixes.top();
                prefixes.pop();

                string cur = pref;
                for (int i = 0; i < times; i++) {
                    cur += current;
                }
                current = cur;
            } else {
                current += c;
            }
        }

        return current;
    }
};

int main() {
    std::cout << Solution().decodeString("3[a]2[bc]") << std::endl;
    std::cout << Solution().decodeString("3[a2[c]]") << std::endl;
    std::cout << Solution().decodeString("2[abc]3[cd]ef") << std::endl;
}
