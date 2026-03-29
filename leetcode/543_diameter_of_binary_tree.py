
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right
        
# Time: O(n)
# Space: O(n)
# Inutuition: Use DFS with global max diameter value. Calculate keft and right at each
# step of the recursion.
class Solution:
    def diameterOfBinaryTree(self, root):
        max_diameter = [0]
        
        def height_dfs(node):
            if not node:
                return 0

            left = height_dfs(node.left)
            right = height_dfs(node.right)
            
            diameter = left + right
            
            if diameter > max_diameter[0]:
                max_diameter[0] = diameter
            
            return 1 + max(left, right)

        height_dfs(root)
        
        return max_diameter[0]

if __name__ == '__main__':
    root = TreeNode(1)
    print(Solution().diameterOfBinaryTree(root))