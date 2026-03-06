# Time: O(n)
# Space: O(1)
class Solution:
    
    def maxArea(self, heights):
        left = 0
        right = len(heights) - 1
        max_area = 0
        
        while left < right:
            # find new area
            w = right - left
            h = min(heights[left], heights[right])
            new_area = w * h
            
            # maybe new max
            max_area = max(max_area, new_area)
            
            # keep the larger height column
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1
        
        return max_area
    
if __name__ == "__main__":
    input = [1,8,6,2,5,4,8,3,7]
    print(Solution().maxArea(input))