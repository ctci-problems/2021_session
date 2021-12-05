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
        
        for (int i = 0;i < colZeros.length;i++) {
            if (colZeros[i]) {
                for (int j = 0;j < matrix.length;j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        for (int i = 0;i < rowZeros.length;i++) {
            if (rowZeros[i]) {
                for (int j = 0;j < matrix[0].length;j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
