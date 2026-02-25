# time: O(n)
# space: O(1)
class Solution:
    def fib(self, n: int) -> int:
        if n < 2:
            return n
        
        prev = 0
        cur = 1
        
        for _ in range(2, n):
            next = prev+cur
            prev = cur
            cur = next
            
        return cur
        
if __name__ == "__main__":
    print(Solution().fib(10))
