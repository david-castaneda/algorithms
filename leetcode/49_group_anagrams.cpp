#include <leetcode.h>

// Time: O(n*k)
// Space: O(n*k)
class Solution {
  public:
    vector<vector<string>> groupAnagrams(vector<string> &strs) {
        unordered_map<string, vector<string>> freq;

        for (int i = 0; i < strs.size(); i++) {
            // compute frequency key
            int letter_count[26] = {0};
            for (char &c : strs[i]) {
                letter_count[c - 'a'] += 1;
            }

            // stringify
            string key;
            key.reserve(26 * 2);
            for (int c : letter_count) {
                key += std::to_string(c) + "#";
            }

            // update frequency map
            freq[key].push_back(strs[i]);
        }

        vector<vector<string>> res;
        res.reserve(freq.size());
        for (auto &[key, val] : freq) {
            res.push_back(std::move(val));
        }

        return res;
    }
};

int main() {
    vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    vector<vector<string>> ans = Solution().groupAnagrams(strs);

    for (int i = 0; i < ans.size(); i++) {
        for (int j = 0; j < ans[i].size(); j++) {
            std::cout << ans[i][j] << ", ";
        }
        std::cout << std::endl;
    }
}