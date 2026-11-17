#include <iostream>

class AVLTree {
  public:
    AVLTree() {}
    void insert(int data) { _insert(data); }

  private:
    class AVLNode {
      public:
        int data;
        AVLNode *left;
        AVLNode *right;
        int height;
        AVLNode(int data) : data(data), left(nullptr), right(nullptr) {}
    };

    AVLNode *head;

    void _insert(int data) { _find_and_insert(head, data); }

    void _find_and_insert(AVLNode *node, int data) {
        // base case
        if (!node) {
            node = new AVLNode(data);
            return;
        }

        // data already exist
        if (node->data == data) {
            return;
        }

        if (node->left->data > data) {
            // search left
            _find_and_insert(node->left, data);
        } else {
            // search right
            _find_and_insert(node->right, data);
        }

        _ensure_balance(node);
    }

    void _ensure_balance(AVLNode *node) {
        if (!node) {
            return;
        }

        int init_balance = _get_balance_factor(node);

        if (init_balance < -2 || init_balance > 2) {
            // invalid state
            return;
        }
    }

    int _get_balance_factor(AVLNode *node) {
        if (!node) {
            return 0;
        }
        return _get_height(node->left) - _get_height(node->right);
    }

    int _get_height(AVLNode *node) {
        if (!node) {
            return -1;
        }
        return node->height;
    }
};

int main() {
    AVLTree *t = new AVLTree();

    t.insert(1);

    delete t;

    return 0;
}