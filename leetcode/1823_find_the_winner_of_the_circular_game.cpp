#include <leetcode.h>

class Solution {
  public:
    int findTheWinner(int n, int k) {
        queue<int> q;
        for (int i = 0; i < n; i++) {
            q.push(i + 1);
        }

        // skip=0,remove=1
        int state = 0;
        vector<int> ans;
        ans.reserve(n);

        while (!q.empty()) {
            if (state == 0) {
                for (int i = 0; i < k - 1; i++) {
                    int cur = q.front();
                    q.pop();
                    q.push(cur); // skip
                }
                state = 1;
            } else {
                int cur = q.front();
                q.pop();
                ans.push_back(cur); // remove
                state = 0;
            }
        }

        return ans[n - 1]; // last element in the queue
    }
};

int main() {
    std::cout << Solution().findTheWinner(5, 2) << std::endl;
    std::cout << Solution().findTheWinner(6, 5) << std::endl;
}