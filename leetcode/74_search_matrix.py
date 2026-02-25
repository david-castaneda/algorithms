# Binary search
# Time: O(log(m*n))
# Space: O(1)
class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        t = m * n
        l = 0
        r = t - 1
        
        while l <= r:
            mid = (l + r) // 2
            mid_i = mid // n
            mid_j = mid % n
            mid_num = matrix[mid_i][mid_j] 
            
            if target == mid_num:
                return True
            if target < mid_num:
                r = mid - 1
            else:
                l = mid + 1    
        
        return False
        
if __name__ == "__main__":
    matrix = [[1,3,4], [5,6,7], [8,9,10]]
    target = 3
    print(Solution().searchMatrix(matrix, target))
