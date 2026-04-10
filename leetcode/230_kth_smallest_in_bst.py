class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(n)
# Space: O(1)
class Solution:
    def kthSmallest(self, root, k):
        count = [k]
        answer = [0]

        def dfs(node):
            if not node:
                return

            dfs(node.left)

            if count[0] == 1:
                answer[0] = node.val

            count[0] -= 1
            
            if count[0] > 0:
                dfs(node.right)

        dfs(root)

        return answer[0]