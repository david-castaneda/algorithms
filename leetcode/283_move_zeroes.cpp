#include <leetcode.h>

// Time: O(n)
// Space: O(1)
// Two pointer (read/write)
class Solution {
  public:
    void moveZeroes(vector<int> &nums) {
        if (nums.size() == 1) {
            return;
        }

        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.size()) {
            if (nums[p1] == 0 && nums[p2] == 0) {
                p2++; // advance the second pointer
                continue;
            }
            if (nums[p1] == 0 && nums[p2] != 0) {
                nums[p1] = nums[p2]; // swap
                nums[p2] = 0;
            }
            p1++;
            p2++;
        }

        return;
    }
};

int main() {
    vector<int> nums = {0, 1, 0, 3, 12};
    Solution().moveZeroes(nums); // solve
    std::cout << nums << std::endl;
}