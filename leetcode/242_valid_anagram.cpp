#include <leetcode.h>

class Solution {
  public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }

        int count[26] = {0};
        for (int i = 0; i < s.size(); i++) {
            count[s[i] - 'a'] += 1;
            count[t[i] - 'a'] -= 1;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
};

int main() {
    std::cout << boolalpha << Solution().isAnagram("eat", "tea") << std::endl;
    std::cout << boolalpha << Solution().isAnagram("tax", "book") << std::endl;
}