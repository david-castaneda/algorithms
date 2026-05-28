# Time: O(n)
# Space: O(m)
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewel_set = set(j for j in jewels) # Space: O(m)
        num_jewels = 0

        # O(n) - n is stones
        for i in range(len(stones)):
            # O(1)
            if stones[i] in jewel_set:
                num_jewels += 1

        return num_jewels