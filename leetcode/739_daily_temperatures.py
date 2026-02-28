# Time: O(n)
# Space: O(n)
# Intuition: Use monotonic stack. Keep track of (temp, index).
class Solution:
    def dailyTemperatures(self, temperatures):
        stack = []
        answer = [0] * len(temperatures)

        for i, temp in enumerate(temperatures):
            while stack and stack[-1][0] < temp:
                _, stack_idx = stack.pop()
                answer[stack_idx] = i - stack_idx
            
            stack.append((temp, i))

        return answer
        
if __name__ == "__main__":
    input = [73,74,75,71,69,72,76,73]
    print(Solution().dailyTemperatures(input))
