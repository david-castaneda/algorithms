class TreeNode:

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
# Time: O(n)
# Space: O(n)
# Intuition: DFS passing along a min/max range for the allowed boundaries of the subtree.
class Solution:
    
    def isValidBST(self, root):
        stack = [(root, float('-inf'), float('inf'))]
        
        while stack:
            node, minn, maxx = stack.pop()
            
            if node.val <= minn or node.val >= maxx:
                return False
            
            if node.left:
                stack.append((node.left, minn, node.val))
                
            if node.right:
                stack.append((node.right, node.val, maxx))
            
        return True
    
if __name__ == '__main__':
    root = TreeNode(2, TreeNode(1), TreeNode(3))
    print(Solution().isValidBST(root))