from collections import defaultdict

# Time: O(n*m)
# Space: O(n*m)
class Solution:
    def groupAnagrams(self, strs):
        ans = defaultdict(list)

        # O(n) where n is the input size
        for word in strs:
            arr = [0] * 26
            # O(m)
            for c in word:
                idx = ord(c) - ord('a')
                arr[idx] = arr[idx] + 1

            ans[tuple(arr)].append(word) # O(1)

        return list(ans.values())
