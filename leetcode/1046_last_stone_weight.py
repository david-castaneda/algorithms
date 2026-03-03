import heapq 
       
# Time: O(nlogn)
# Space: O(1)
# Intuition: Use a max heap.
class Solution:
    
    def lastStoneWeight(self, stones):
        # create a max heap - O(n)
        for i in range(len(stones)):
            stones[i] = -stones[i]
        heapq.heapify(stones)

        # destroy stones until 1 or 0 stones left - O(n)
        while len(stones) > 1:
            lg = -heapq.heappop(stones) # O(logn)
            second_lg = -heapq.heappop(stones) # O(logn)
            
            if lg != second_lg:
                heapq.heappush(stones, -(lg - second_lg)) # O(logn)

        return -stones[0] if len(stones) == 1 else 0
        
if __name__ == "__main__":
    input = [2,7,4,1,8,1] # output = 1
    print(Solution().lastStoneWeight(input))
