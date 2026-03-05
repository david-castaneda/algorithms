# Time: O(n!)
# Space: O(n)
class Solution:
    
    def permute(self, nums):
        answer = []
        solution = []
        
        def backtrack():
            if len(solution) == len(nums):
                answer.append(solution.copy())
                return
            
            for num in nums:
                if num not in solution:
                    solution.append(num)
                    backtrack()
                    solution.pop()
        
        backtrack()
        
        return answer

if __name__ == "__main__":
    input = [1,2,3]
    print(Solution().permute(input))