#include <leetcode.h>

class Solution {
  public:
    bool containsDuplicate(vector<int> &nums) {
        unordered_set<int> m;

        for (int num : nums) {
            if (m.contains(num)) {
                return true;
            }
            m.insert(num);
        }

        return false;
    }
};

int main() {
    vector<int> a = {1, 2, 2, 3};
    vector<int> b = {1, 2, 3};
    std::cout << boolalpha << Solution().containsDuplicate(a) << std::endl;
    std::cout << boolalpha << Solution().containsDuplicate(b) << std::endl;
};