#include <leetcode.h>

// this can be optimized further by only keeping the largest
// int in the map. For simplicty im just going to leave it
// here as is and come back to it later.
class Solution {
  public:
    int maximumSum(vector<int> &nums) {
        unordered_map<int, vector<int>> m;

        for (int &num : nums) {
            unsigned int n = std::abs(num);
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (m.contains(sum)) {
                m[sum].push_back(num);
            } else {
                m[sum] = {num};
            }
        }

        int max = 0;
        for (auto &[key, val] : m) {
            if (val.size() <= 1) {
                continue;
            }

            std::sort(val.begin(), val.end(),
                      [](int a, int b) { return a > b; });

            max = std::max(max, val[0] + val[1]);
        }

        if (max > 0) {
            return max;
        }

        return -1;
    }
};

int main() {
    vector<int> vec = {18, 43, 36, 13, 7};
    std::cout << Solution().maximumSum(vec) << std::endl;
}