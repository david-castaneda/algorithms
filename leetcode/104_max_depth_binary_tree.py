class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque

# Time: O(n)
# Space: O(n)
# Intuition: Level order traversal with a counter
class Solution:
    def maxDepth(self, root):
        if not root:
            return 0
        
        count = 0
        queue = deque([root]) 

        while queue:
            n = len(queue)
            
            for _ in range(n):
                cur = queue.popleft()
                
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                
            count += 1
        
        return count
    
    def iterativeMaxDepth(self, root):
        def dfs(node):
            if not node:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)

            return 1 + max(left, right)
            
        return dfs(root)
