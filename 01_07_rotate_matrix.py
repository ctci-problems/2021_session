class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row , col = len(matrix), len(matrix[0])
        for i in range(row):
            for j in range(i, col):
                
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        for i  in range(row):
            for j in range(col//2):
                print(matrix[i][j], matrix[i][row- 1-j])
                matrix[i][j], matrix[i][row- 1-j] = matrix[i][row - 1-j], matrix[i][j]
        return matrix  
