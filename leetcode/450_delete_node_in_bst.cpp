#include <utility>

using namespace std;

class Solution {
  public:
    class TreeNode {
      public:
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode();
        TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
    };

    TreeNode *deleteNode(TreeNode *root, int key) {
        if (!root) {
            return nullptr;
        }

        TreeNode *prev = nullptr;
        TreeNode *cur = root;

        while (cur) {
            if (cur->val == key) {
                // found target node
                break;
            }

            prev = cur;
            if (cur->val > key) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }

        if (cur == nullptr) {
            // target not found
            return root;
        }

        // 2-children
        if (cur->left && cur->right) {
            auto [parent, successor] = ios(cur);
            cur->val = successor->val;
            if (parent->left == successor) {
                parent->left = successor->right;
            } else {
                parent->right = successor->right;
            }
            successor->right = nullptr;
            delete successor;
            return root;
        }

        if (!cur->left && !cur->right) {
            // no children
            if (prev == nullptr) {
                root = nullptr;
            } else if (prev->left == cur) {
                prev->left = nullptr;
            } else {
                prev->right = nullptr;
            }
        } else if (cur->left && !cur->right) {
            // 1-child (left)
            if (prev == nullptr) {
                root = cur->left;
            } else if (prev->left == cur) {
                prev->left = cur->left;
            } else {
                prev->right = cur->left;
            }
            cur->left = nullptr;
        } else if (!cur->left && cur->right) {
            // 1-child (right)
            if (prev == nullptr) {
                root = cur->right;
            } else if (prev->right == cur) {
                prev->right = cur->right;
            } else {
                prev->left = cur->right;
            }
            cur->right = nullptr;
        }

        delete cur;

        return root;
    }

    static pair<TreeNode *, TreeNode *> ios(TreeNode *node) {
        // ios (in-order successor): go right once, then left all the way
        TreeNode *prev = node;
        TreeNode *cur = node->right;

        while (cur->left) {
            // go left all the way
            prev = cur;
            cur = cur->left;
        }

        return {prev, cur};
    }
};