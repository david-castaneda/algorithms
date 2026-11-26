#include <leetcode.h>

// Time: O(n + m)
// Space: O(m) where m is unique letters in magazine
class Solution {
  public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> freq;
        for (char c : magazine) {
            freq[c] += 1;
        }

        for (char c : ransomNote) {
            if (freq[c] == 0) {
                return false;
            }
            freq[c] -= 1;
        }

        return true;
    }
};

int main() {
    std::cout << boolalpha << Solution().canConstruct("a", "b") << std::endl;
    std::cout << boolalpha << Solution().canConstruct("aa", "ab") << std::endl;
    std::cout << boolalpha << Solution().canConstruct("aa", "aab") << std::endl;
}