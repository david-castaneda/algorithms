# Time: O(n^2)
# Space: O(n)
# Intuition: Iterate every number and apply a variation of two sum.
class Solution:
    def threeSum(self, nums):
        nums.sort()
        answer = []

        # iterate over all nums, then apply two sum
        for i in range(len(nums)):

            # skip already processed starting points
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # classic two sum with a twist
            left = i + 1
            right = len(nums) - 1

            while left < right:
                three_sum = nums[i] + nums[left] + nums[right]

                if three_sum == 0:
                    answer.append([nums[i], nums[left], nums[right]])
                    left += 1

                    # dont process same left number
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1
                elif three_sum < 0:
                    left += 1
                else:
                    right -= 1

        return answer
    
if __name__ == "__main__":
    input = [-1,0,1,2,-1,-4]
    print(Solution().threeSum(input))