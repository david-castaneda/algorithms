#include "leetcode.h"

class Solution {
  public:
    vector<int> topKFrequent(vector<int> &nums, int k) {
        unordered_map<int, int> freq;
        for (int num : nums) {
            freq[num] += 1;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>,
                       greater<pair<int, int>>>
            min_heap;
        for (auto &[num, count] : freq) {
            min_heap.push({count, num});
            if (min_heap.size() > k) {
                min_heap.pop();
            }
        }

        vector<int> res;
        while (!min_heap.empty()) {
            res.push_back(min_heap.top().second);
            min_heap.pop();
        }

        return res;
    }
};

int main() {
    vector<int> arr = {1, 1, 1, 2, 2, 3, 3, 3};
    vector<int> res = Solution().topKFrequent(arr, 2);

    std::cout << res << "\n";

    return 0;
}