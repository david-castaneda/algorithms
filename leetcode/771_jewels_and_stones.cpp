#include <leetcode.h>

// Time: O(n + m)
// Space: O(128) where 128 is size of possible ASCII chars
class Solution {
  public:
    int numJewelsInStones(string jewels, string stones) {
        set<char> seen;
        for (char c : jewels) {
            seen.insert(c);
        }

        int ans = 0;
        for (char c : stones) {
            if (seen.count(c) > 0) {
                ans++;
            }
        }

        return ans;
    }
};

int main() {
    std::cout << Solution().numJewelsInStones("aA", "aAAbbbb") << std::endl;
    std::cout << Solution().numJewelsInStones("z", "ZZ") << std::endl;
}