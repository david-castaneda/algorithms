#include <leetcode.h>

// Time: O(nlogn + mlogn)
// Space: O(1)
// Two pointer
class Solution {
  public:
    int findContentChildren(vector<int> &g, vector<int> &s) {
        std::sort(g.begin(), g.end());
        std::sort(s.begin(), s.end());

        int ans = 0;
        int i = 0;
        int j = 0;

        while (i < g.size() && j < s.size()) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
                j++;
            } else if (g[i] < s[j]) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
};

int main() {
    vector<int> g = {1, 2, 3};
    vector<int> s = {1, 1};
    std::cout << Solution().findContentChildren(g, s) << std::endl;

    vector<int> g2 = {1, 2};
    vector<int> s2 = {1, 2, 3};
    std::cout << Solution().findContentChildren(g2, s2) << std::endl;
}