
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right
        
# Time: O(n)
# Space: O(n)
class Solution:
    def getMinimumDifference(self, root):
        min_distance = [float("inf")]
        prev = [None]

        def dfs(node):
            if not node:
                return

            dfs(node.left)

            if prev[0] is not None:
                min_distance[0] = min(min_distance[0], abs(prev[0].val - node.val))

            prev[0] = node

            dfs(node.right)

        dfs(root)

        return min_distance[0]