function rotate(matrix) {

    matrix.reverse()

    for(let i = 0; i < matrix.length; i++){
        for(let j = i + 1; j < matrix.length; j++) {
            let temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    return matrix
}

//reverse the array
    //[[7,8,9],[4,5,6],[1,2,3]]

    
    /*
    for(let i = 0; i < matrix.length; i++){
    [[7,8,9]]
     *for(let j = i + 1; j < matrix.length; j++)
     *let temp = matrix[i[j]]
     matrix[i[j]] = matrix[j[i]]
     matrix[j[i]] = temp
    *}

    * i=0 j=i+1
    *matrix[j]
    *[ [7,4,9], [8,5,6], [1,2,3] ]

    *[[7,4,1], [8,5,6], [9,2,3] ]

    *[[7,4,1], [8,5,2], [9,6,3] ]
    *
    */