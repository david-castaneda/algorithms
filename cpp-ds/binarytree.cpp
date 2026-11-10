#include <iostream>

class TreeNode {
  public:
    int data;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int data) : data(data), left(nullptr), right(nullptr) {};
};

class BinaryTree {
  public:
    TreeNode *head;

    void insert(int data) {
        if (!head) {
            head = new TreeNode(data);
            return;
        }
    }
};

int main() { BinaryTree t; }