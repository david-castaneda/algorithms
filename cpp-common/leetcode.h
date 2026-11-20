#pragma once

// Common libraries needed in LeetCode style problems.
#include <algorithm>
#include <iostream>
#include <queue>
#include <set>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// Helper to print values of a vector.
template <typename T> ostream &operator<<(ostream &os, const vector<T> &v) {
    os << "[";
    for (size_t i = 0; i < v.size(); ++i) {
        if (i > 0)
            os << ", ";
        os << v[i];
    }
    return os << "]";
}

// Singly-linked list node as defined by LeetCode.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};