class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def hasPathSum(self, root, targetSum):

        def dfs(node, path_sum):
            if not node:
                return False

            path_sum += node.val

            if not node.left and not node.right:
                return path_sum == targetSum

            left = dfs(node.left, path_sum)
            right = dfs(node.right, path_sum)

            return left or right

        return dfs(root, 0)

if __name__ == '__main__':
    root = TreeNode(1)
    print(Solution().hasPathSum(root, 5))