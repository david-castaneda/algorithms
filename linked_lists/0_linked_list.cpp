#include <iostream>

class Node {
  public:
    Node *next = nullptr;
    int data;
    Node(int);
};

Node::Node(int val) : data(val) {}

class LinkedList {
  public:
    void insert(int);
    void print() const;
    ~LinkedList();

  private:
    Node *head_ = nullptr;
};

void LinkedList::insert(int data) {
    Node *cur = head_;

    while (cur && cur->next != nullptr) {
        cur = cur->next;
    }

    if (cur == nullptr) {
        head_ = new Node(data);
    } else {
        cur->next = new Node(data);
    }
}

void LinkedList::print() const {
    Node *cur = head_;

    while (cur != nullptr) {
        std::cout << cur->data << "\n";
        cur = cur->next;
    }
}

LinkedList::~LinkedList() {
    Node *cur = head_;

    while (cur != nullptr) {
        Node *tmp = cur->next;
        delete cur;
        cur = tmp;
    }
}

int main() {
    LinkedList ll;
    ll.insert(1);
    ll.insert(2);
    ll.insert(3);
    ll.print();
}