#include <leetcode.h>

// Time: O(n)
// Space: O(1)
// Two pointer (left/right squeeze)
class Solution {
  public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        int p1 = 0;
        int p2 = numbers.size() - 1;

        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                return {p1 + 1, p2 + 1}; // found
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }

        return {};
    }
};

int main() {
    vector<int> nums1 = {2, 7, 11, 15};
    std::cout << Solution().twoSum(nums1, 9) << std::endl;

    vector<int> nums2 = {2, 3, 4};
    std::cout << Solution().twoSum(nums2, 6) << std::endl;
}