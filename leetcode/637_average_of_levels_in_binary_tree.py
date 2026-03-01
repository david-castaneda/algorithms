from collections import deque

class TreeNode:

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    
# Time: O(n)
# Space: O(n)
# Intuition: BFS keeping track of how many nodes in each level.
# Use inner for loop to process each level.
class Solution:
    def averageOfLevels(self, root):
        answer = []
        q = deque([root])

        while q:
            lvl_sum = 0
            n = len(q)  # track how many nodes in this level

            for _ in range(n):  # run for one level of the tree
                cur = q.popleft()
                lvl_sum += cur.val

                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)

            answer.append(lvl_sum / n)

        return answer
    
if __name__ == "__main__":
    Root = TreeNode(1, TreeNode(2), TreeNode(3))
    print(Solution().averageOfLevels(Root))
