# Time: O(n)
# Space: O(1)
class Solution:
    def findClosestNumber(self, nums):
        ans = nums[0]
        
        for num in nums:
            if abs(num) < abs(ans):
                ans = num

        if ans < 0:
            for num in nums:
                if num == abs(ans):
                    return abs(num)

        return ans
