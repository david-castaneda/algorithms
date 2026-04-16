import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Time: O(nlogk)
# Space: O(k)
class Solution:
    def mergeKLists(self, lists):
        # size O(k)
        min_heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(min_heap, (node.val, i, node))

        dummy = ListNode()
        cur = dummy

        # O(n log k)
        while min_heap:
            _, i, node = heapq.heappop(min_heap)
            cur.next = node
            cur = node
            if node.next:
                heapq.heappush(min_heap, (node.next.val, i, node.next))

        return dummy.next
