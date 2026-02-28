# Time: O(nlogn)
# Space: O(n)
# Intuition: Sort intervals by their starting time, then merge.
class Solution:
    def merge(self, intervals):
        sorted_intervals = sorted(intervals)  # O(nlogn)
        answer = []

        # O(n)
        for i in range(len(sorted_intervals)):
            # check if the last interval overlaps with current interval
            if answer and answer[-1][1] >= sorted_intervals[i][0]:
                # when theres an overlap keep starting interval and choose max for the end interval
                answer[-1] = [answer[-1][0], max(answer[-1][1], sorted_intervals[i][1])]
            else:
                answer.append(sorted_intervals[i])

        return answer

if __name__ == "__main__":
    matrix = [[1,3],[2,6],[8,10],[15,18]]
    print(Solution().merge(matrix))
