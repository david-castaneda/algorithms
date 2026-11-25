#include <leetcode.h>

// Time: O(n)
// Space: O(n)
// Double queue pattern
class Solution {
  public:
    string predictPartyVictory(string senate) {
        int n = senate.length();
        queue<int> qR;
        queue<int> qD;

        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                qR.push(i);
            } else {
                qD.push(i);
            }
        }

        while (!qR.empty() && !qD.empty()) {
            int idxR = qR.front();
            qR.pop();
            int idxD = qD.front();
            qD.pop();

            if (idxR < idxD) {
                qR.push(idxR + n);
            } else {
                qD.push(idxD + n);
            }
        }

        return qR.empty() ? "Dire" : "Radiant";
    }
};

int main() {
    std::cout << Solution().predictPartyVictory("RD") << std::endl;
    std::cout << Solution().predictPartyVictory("RDD") << std::endl;
}