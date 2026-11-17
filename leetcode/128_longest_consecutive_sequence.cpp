#include <leetcode.h>

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    int longestConsecutive(vector<int> &nums) {
        set<int> values(nums.begin(), nums.end());

        int longest = 0;

        for (int num : values) {
            if (values.contains(num - 1)) {
                continue; // not the start of the sequence
            }

            int length = 0;
            while (values.contains(num + length)) {
                length += 1;
            }
            longest = std::max(longest, length);
        }

        return longest;
    }
};

int main() {
    vector<int> nums = {100, 4, 200, 1, 3, 2};
    std::cout << Solution().longestConsecutive(nums) << std::endl;
}