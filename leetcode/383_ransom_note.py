from collections import Counter

# Time: O(n)
# Space: O(m)
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        # frequency map
        freq = Counter(magazine)

        # O(n)
        for c in ransomNote:
            if freq[c] <= 0:
                return False
            freq[c] -= 1

        return True
