#include <leetcode.h>

// Time: O(n)
// Space: O(1)
class Solution {
  public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
        ListNode *dummy = new ListNode();
        ListNode *cur = dummy;

        while (list1 && list2) {
            if (list1->val < list2->val) {
                cur->next = list1;
                cur = list1;
                list1 = list1->next;
            } else {
                cur->next = list2;
                cur = list2;
                list2 = list2->next;
            }
        }

        if (list1) {
            cur->next = list1;
        }

        if (list2) {
            cur->next = list2;
        }

        return dummy->next;
    }
};

int main() {
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(3);
    ListNode *l2 = new ListNode(2);
    l2->next = new ListNode(4);

    ListNode *cur = Solution().mergeTwoLists(l1, l2);
    while (cur) {
        std::cout << cur->val << std::endl;
        cur = cur->next;
    }
}