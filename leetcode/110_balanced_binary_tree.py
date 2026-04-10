class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(n)
# Space: O(n)
class Solution:
    def isBalanced(self, root):
        balanced = [True] # global tracker
        
        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)
            
            if abs(left - right) > 1:
                balanced[0] = False
                return 0
            
            return 1 + max(left, right)

        dfs(root)
        
        return balanced[0]