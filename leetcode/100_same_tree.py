class TreeNode:

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
# Time: O(n + m)
# Space: O(n + m)
# Intuition: DFS over both trees at the same time checking equality.
class Solution:
    def isSameTree(self, p, q) -> bool:
        def dfs(a, b):
            # both null
            if not a and not b:
                return True

            # only one null
            if (not a and b) or (not b and a):
                return False

            # not equal in value
            if a.val != b.val:
                return False

            return dfs(a.left, b.left) and dfs(a.right, b.right)

        return dfs(p, q)
    
if __name__ == "__main__":
    RootA = TreeNode(1, TreeNode(2), TreeNode(3))
    RootB = TreeNode(1, TreeNode(2), TreeNode(4))
    
    print(Solution().isSameTree(RootA, RootB))
