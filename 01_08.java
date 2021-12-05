class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean[] rowZeros = new boolean[matrix.length];
        boolean[] colZeros = new boolean[matrix[0].length];
        
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (matrix[i][j] == 0) {
                   rowZeros[i] = true;
                   colZeros[j] = true;
                }
            }
        }
        
        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (rowZeros[i] || colZeros[j]) {
                   matrix[j][i] = 0;
                }
            }
        }
    }
}
