#include <leetcode.h>

// Time: O(n)
// Space: O(1)
// Two pointer
class Solution {
  public:
    bool isPalindrome(string s) {
        int p1 = 0;
        int p2 = s.length();

        while (p1 < p2) {
            if (!std::isalnum(s[p1])) {
                p1++;
                continue;
            }
            if (!std::isalnum(s[p2])) {
                p2--;
                continue;
            }

            if (std::tolower(s[p1]) == std::tolower(s[p2])) {
                p1++;
                p2--;
            } else {
                return false; // not equal, no chance of palindrome
            }
        }

        return true;
    }
};

int main() {
    std::cout << boolalpha
              << Solution().isPalindrome("A man, a plan, a canal: Panama")
              << std::endl;
    std::cout << boolalpha << Solution().isPalindrome("race a car")
              << std::endl;
    std::cout << boolalpha << Solution().isPalindrome(" ") << std::endl;
}