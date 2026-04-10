
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right
        
# Time: O(m*n)
# Space: O(n)
class Solution:
    def isSubtree(self, root, subRoot):
        def isSame(a, b):
            # both null
            if not a and not b:
                return True

            # one is missing
            if (a and not b) or (not a and b):
                return False

            # values are not equal
            if a.val != b.val:
                return False

            return isSame(a.left, b.left) and isSame(a.right, b.right)

        def dfs(node):
            if not node:
                return False

            if isSame(node, subRoot):
                return True

            return dfs(node.left) or dfs(node.right)

        return dfs(root)