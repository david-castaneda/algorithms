#include <iostream>
#include <vector>

using namespace std;

class TreeNode {
  public:
    int data;
    vector<TreeNode *> children;
    TreeNode(int data) : data(data), children({}) {};
    ~TreeNode() {
        cout << "cleaning up TreeNode: " << data << endl;
        for (TreeNode *child : children) {
            delete child;
        }
    }
};

void dfs(TreeNode *node) {
    if (!node) {
        return;
    }

    // in-order
    cout << node->data << endl;
    for (auto child : node->children) {
        dfs(child);
    }
}

void bfs(TreeNode *node) {
    if (!node) {
        return;
    }

    queue<TreeNode *> q;
    q.push(node);

    while (!q.empty()) {
        TreeNode *cur = q.front();
        q.pop();

        cout << cur->data << endl;

        for (auto child : cur->children) {
            q.push(child);
        }
    }
}

int main() {
    TreeNode *root = new TreeNode(0);

    TreeNode *one = new TreeNode(1);
    root->children.push_back(one);
    one->children.push_back(new TreeNode(3));
    one->children.push_back(new TreeNode(4));

    TreeNode *two = new TreeNode(2);
    root->children.push_back(two);
    two->children.push_back(new TreeNode(5));

    cout << "DFS: " << endl;
    dfs(root);

    cout << "BFS: " << endl;
    bfs(root);

    delete root;
}