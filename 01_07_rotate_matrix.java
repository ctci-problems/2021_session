class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0;i < matrix.length / 2;i++) {
            
            for (int j = i;j < matrix[0].length - 1 - i;j++) {
                int top = matrix[i][j];
                int right = matrix[j][matrix[0].length - 1 - i];
                int bottom = matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j];
                int left = matrix[matrix[0].length - 1 - j][i];
                
                
                matrix[i][j] = left;
                matrix[j][matrix[0].length - 1 - i] = top;
                matrix[matrix[0].length - 1 - i][matrix[0].length - 1 - j] = right;
                matrix[matrix[0].length - 1 - j][i] = bottom;
                
                System.out.println(top + " " + right + " " + bottom + " " + left);
            }
            System.out.println("New layer!");
        }
    }
    
}


class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0;i < matrix.length/2;i++) {
            for (int j = i;j < matrix.length - 1 - i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
