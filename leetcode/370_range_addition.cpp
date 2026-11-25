#include <leetcode.h>

// Time: O(n x k)
// Space: O(n)
class Solution {
  public:
    vector<int> getModifiedArray(int length, vector<vector<int>> &updates) {
        vector<int> nums(length, 0);
        for (const auto &op : updates) {
            int l = op[0];
            int r = op[1];
            int x = op[2];

            for (int j = l; j <= r; j++) {
                nums[j] += x;
            }
        }

        return nums;
    }
};

int main() {
    vector<vector<int>> updates = {
        {1, 3, 2},
        {2, 4, 3},
        {0, 2, -2},
    };

    std::cout << Solution().getModifiedArray(5, updates) << std::endl;
}