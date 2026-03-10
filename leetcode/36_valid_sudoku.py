from collections import defaultdict

# Time: O(n^2)
# Space: O(n)
# Intuition: Use a set mapped to rows, columns, sub-boxes to keep track 
# of the values you have already seen.
class Solution:
    def isValidSudoku(self, board):
        m = len(board)
        n = len(board[0])

        row_map = defaultdict(set)
        column_map = defaultdict(set)
        subboxes_map = defaultdict(set)
        for i in range(m):
            for j in range(n):
                # validate rows
                if board[i][j] != "." and board[i][j] in row_map[i]:
                    return False
                row_map[i].add(board[i][j])

                # validate columns
                if board[j][i] != "." and board[j][i] in column_map[i]:
                    return False
                column_map[i].add(board[j][i])

                # validate sub-boxes
                quadrant = (i // 3) * 3 + (j // 3)
                if board[i][j] != "." and board[i][j] in subboxes_map[quadrant]:
                    return False
                subboxes_map[quadrant].add(board[i][j])

        return True

if __name__ == "__main__":
    input = [["5","3",".",".","7",".",".",".","."]
            ,["6",".",".","1","9","5",".",".","."]
            ,[".","9","8",".",".",".",".","6","."]
            ,["8",".",".",".","6",".",".",".","3"]
            ,["4",".",".","8",".","3",".",".","1"]
            ,["7",".",".",".","2",".",".",".","6"]
            ,[".","6",".",".",".",".","2","8","."]
            ,[".",".",".","4","1","9",".",".","5"]
            ,[".",".",".",".","8",".",".","7","9"]]
    print(Solution().isValidSudoku(input))