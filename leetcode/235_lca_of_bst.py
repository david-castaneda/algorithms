class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(h)
# Space: O(h)
class Solution:
    def lowestCommonAncestor(self, root, p, q):
        lca = [root]

        def dfs(node):
            if not node: 
                return
            
            lca[0] = node

            if node.val == p.val or node.val == q.val:
                return 

            if node.val < p.val and node.val < q.val:
                dfs(node.right)
            elif node.val > p.val and node.val > q.val:
                dfs(node.left)
            else:
                return
                
        dfs(root)

        return lca[0]
        