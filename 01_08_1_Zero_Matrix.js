/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let rowZeros = [];
    let colZeros = [];
    
    
    for (let i = 0;i < matrix.length;i++) {
        for (let j = 0;j < matrix[0].length;j++) {
            if (matrix[i][j] == 0) {
                rowZeros[i] = true;
                colZeros[j] = true;
            }
        }
    }
    console.log(rowZeros);
    console.log(colZeros);
    
    
    for (let i = 0;i < matrix.length;i++) {
        for (let j = 0;j < matrix[0].length;j++) {
            if (rowZeros[i] || colZeros[j]) {
                matrix[i][j] = 0;
            }
        }
    }
};
