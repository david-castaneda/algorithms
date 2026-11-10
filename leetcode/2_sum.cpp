// TODO: this isn't solved yet, just testing somethings out
#include "leetcode.h"

class Solution {
  public:
    static vector<int> two_sum(vector<int> &, int);
};

vector<int> Solution::two_sum(vector<int> &arr, int target) { return {1, 0}; }

int main() {
    vector<int> arr = {1, 2, 3};
    vector<int> res = Solution::two_sum(arr, 5);

    std::cout << res << "\n";

    return 0;
}