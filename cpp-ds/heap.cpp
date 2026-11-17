#include <iostream>
#include <queue>

using namespace std;

int main() {
    //
    // Max heap
    //
    priority_queue<int> max_heap;
    max_heap.push(1);
    max_heap.push(2);
    max_heap.push(3);

    std::cout << "max heap" << std::endl;
    while (!max_heap.empty()) {
        std::cout << max_heap.top();
        max_heap.pop();
    }
    std::cout << std::endl;

    //
    // Min heap
    //
    priority_queue<int, vector<int>, greater<int>> min_heap;
    min_heap.push(1);
    min_heap.push(2);
    min_heap.push(3);

    std::cout << "min heap" << std::endl;
    while (!min_heap.empty()) {
        cout << min_heap.top();
        min_heap.pop();
    }
    std::cout << std::endl;
}