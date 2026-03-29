class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(n)
# Space: O(n)
class Solution:
    def invertTree(self, node):
        if not node:
            return

        node.left, node.right = node.right, node.left
    
        self.invertTree(node.left)
        self.invertTree(node.right)

        return node
        
if __name__ == '__main__':
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    print(Solution().invertTree(root))