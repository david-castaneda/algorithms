#include <iostream>
#include <queue>

using namespace std;

class TreeNode {
  public:
    int data;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data) : data(data), left(nullptr), right(nullptr) {};

    ~TreeNode() {
        cout << "cleaning up " << data << endl;
        delete left;
        delete right;
    }
};

class BinaryTree {
  public:
    TreeNode *head;
    BinaryTree() : head(nullptr) {};

    BinaryTree(const BinaryTree &other) {
        cout << "copying BinaryTree" << endl;
        head = clone(other.head);
    }

    ~BinaryTree() {
        cout << "cleaning up BinaryTree" << endl;
        delete head;
    }

    TreeNode *find(int data) {
        if (!head) {
            return nullptr;
        }

        TreeNode *cur = head;

        while (cur) {
            if (cur->data == data) {
                return cur;
            } else if (cur->data > data) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }

        return nullptr;
    }

    void insert(int data) {
        if (!head) {
            head = new TreeNode(data);
            return;
        }

        TreeNode *prev = nullptr;
        TreeNode *cur = head;
        while (cur) {
            prev = cur;
            cur = cur->data > data ? cur->left : cur->right;
        }

        cur = new TreeNode(data);
        if (prev->data > data) {
            prev->left = cur;
        } else {
            prev->right = cur;
        }
    }

    void remove(int data) {
        if (!head) {
            return;
        }

        TreeNode *prev = nullptr;
        TreeNode *cur = head;

        // find target node
        while (cur) {
            if (cur->data == data) {
                // found target node
                break;
            }

            prev = cur;
            if (cur->data > data) {
                cur = cur->left;
            } else {
                cur = cur->right;
            }
        }

        if (cur == nullptr) {
            // target not found
            return;
        }

        // 2-children
        if (cur->left && cur->right) {
            auto [parent, successor] = ios(cur);
            cur->data = successor->data;
            if (parent->left == successor) {
                parent->left = successor->right;
            } else {
                parent->right = successor->right;
            }
            successor->right = nullptr;
            delete successor;
            return;
        }

        // target is root
        if (prev == nullptr) {
            if (!cur->left && !cur->right) {
                // no children
                head = nullptr;
            } else if (cur->left && !cur->right) {
                // 1-child (left)
                head = cur->left;
                cur->left = nullptr;
            } else if (!cur->left && cur->right) {
                // 1-child (right)
                head = cur->right;
                cur->right = nullptr;
            }
            delete cur;
            return;
        }

        // target is non-root
        if (!cur->left && !cur->right) {
            // no children
            if (prev->left == cur) {
                prev->left = nullptr;
            } else {
                prev->right = nullptr;
            }
            delete cur;
            return;
        } else if (cur->left && !cur->right) {
            // 1-child (left)
            if (prev->left == cur) {
                prev->left = cur->left;
            } else {
                prev->right = cur->left;
            }
            cur->left = nullptr;
            delete cur;
            return;
        } else if (!cur->left && cur->right) {
            // 1-child (right)
            if (prev->right == cur) {
                prev->right = cur->right;
            } else {
                prev->left = cur->right;
            }
            cur->right = nullptr;
            delete cur;
            return;
        }
    }

    void print() {
        if (!head) {
            return;
        }

        queue<TreeNode *> q;
        q.push(head);

        while (!q.empty()) {
            int lvlSize = q.size();

            while (lvlSize > 0) {
                TreeNode *node = q.front();
                q.pop();
                cout << node->data << " ";

                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }

                lvlSize--;
            }
            cout << endl;
        }
    }

  private:
    static TreeNode *clone(const TreeNode *node) {
        if (!node) {
            return nullptr;
        }

        TreeNode *newNode = new TreeNode(node->data);
        newNode->left = clone(node->left);
        newNode->right = clone(node->right);

        return newNode;
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

int main() {
    BinaryTree *t = new BinaryTree();

    t->insert(3);
    t->insert(1);
    t->insert(2);
    t->insert(4);
    t->insert(6);
    t->insert(5);
    t->insert(7);
    t->insert(8);

    t->print();

    cout << "Found 0 " << boolalpha << (t->find(0) != nullptr) << endl;
    cout << "Found 1 " << boolalpha << (t->find(1) != nullptr) << endl;

    t->remove(2);
    t->remove(7);

    t->print();

    delete t;
}