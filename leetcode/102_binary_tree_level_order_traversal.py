class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque

# Time: O(n)
# Space: O(n)
class Solution:
    def levelOrder(self, root):
        if not root:
            return []

        queue = deque([root])
        answer = []

        while queue:
            n = len(queue)
            level = []

            for _ in range(n):
                cur = queue.popleft()
                level.append(cur.val)

                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

            answer.append(level)

        return answer