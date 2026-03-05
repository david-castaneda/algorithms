# Time: O(2^n)
# Space: O(n)
class Solution:
    
    def subsets(self, nums):
        answer = []
        solution = []
        
        def backtracking(i):
            if i == len(nums):
                answer.append(solution.copy())
                return
            
            # exclude
            backtracking(i + 1)
            
            # include
            solution.append(nums[i])
            backtracking(i + 1)
            solution.pop()
            
        backtracking(0)
        
        return answer
        
if __name__ == '__main__':
    input = [1,2,3]
    print(Solution().subsets(input))