class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(n)
# Space: O(n)
class Solution:
    def isSymmetric(self, root):
        def dfs(a, b):
            if not a and not b:
                return True

            if (not a and b) or (a and not b):
                return False

            if a.val != b.val:
                return False

            return dfs(a.left, b.right) and dfs(a.right, b.left)

        return dfs(root, root)

if __name__ == '__main__':
    root = TreeNode(1)
    print(Solution().isSymmetric(root))