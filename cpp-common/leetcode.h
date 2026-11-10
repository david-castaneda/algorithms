#pragma once

// Common libraries needed in LeetCode style problems.
#include <iostream>
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