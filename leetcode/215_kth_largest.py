import heapq

#  Time: O(nlogk)
# Space: O(k)
# Intuition: Use a min heap of size k.
class Solution:
    
    def findKthLargest(self, nums, k):
        min_heap = [] # keep size k
    
        for n in nums: # O(n)
            if len(min_heap) < k:
                heapq.heappush(min_heap, n) # O(logk)
            else:
                heapq.heappush(min_heap, n) # O(logk)    
                heapq.heappop(min_heap) # O(logk)
        
        return min_heap[0]
        
    
if __name__ == "__main__":
    input = [3,2,1,5,6,4]
    k = 2
    print(Solution().findKthLargest(input, k))