#include <leetcode.h>

// Time: O(h)
// Space: O(1)
class Solution {
  public:
    TreeNode *searchBST(TreeNode *root, int val) {
        TreeNode *cur = root;
        while (cur) {
            if (cur->val == val) {
                return cur;
            }
            if (cur->val > val) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }

        return nullptr;
    }
};

int main() {
    //       5
    //     3    7
    //   2   4
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(3);
    root->right = new TreeNode(7);
    root->left->left = new TreeNode(2);
    root->left->right = new TreeNode(4);

    std::cout << Solution().searchBST(root, 4)->val << std::endl;
}