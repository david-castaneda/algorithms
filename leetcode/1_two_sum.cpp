#include "leetcode.h"

// Time: O(n)
// Space: O(n)
class Solution {
  public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> m;

        for (int i = 0; i < nums.size(); i++) {
            int it = target - nums[i];
            if (m.contains(it)) {
                return {m[it], i};
            }
            m[nums[i]] = i;
        }

        return {};
    }
};

int main() {
    vector<int> arr = {1, 2, 3};
    vector<int> res = Solution().twoSum(arr, 5);

    std::cout << res << "\n";

    return 0;
}