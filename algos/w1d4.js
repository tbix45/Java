// Matrix Search

// Jenny digs image and wants to make a JavaScript imaging library like PIL for python. She is given 2 different two-dimensional arrays, containing integers between 0 and 65535. Each two dimensional array represents a grey-scale image, where each integer value is a pixel. The second image might be somewhere inside the larger one. Return whether it is.

// Given Matrix: [ [12, 34, 45, 56],    And Matrix: [ [67, 78],      return: true
//                [98, 87, 76, 65],                  [43, 32] ];   
//                [56, 67, 78, 89],
//                [54, 43, 32, 21] ];

// If finding the submatrix is too hard, try and find just 1 number in the matrix first! Then try and find a few numbers in the same line, then the submatrix

// console.log(matrixSearch([ 
// [12, 34, 45, 56],
// [98, 87, 76, 65],
// [56, 67, 78, 89],
// [54, 43, 32, 21] ], 
// 67)); --> true

// console.log(matrixSearch([ 
// [12, 34, 45, 56],
// [98, 87, 76, 65],
// [56, 67, 78, 89],
// [54, 43, 32, 21] ], 
// [ 67, 78 ])); --> true

function matrixSearch(arr, subArr) {
    let x = 0;
    let y = 0;
    let finder = subArr[y][x]; // 67
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            if (arr[i][j] == finder) {
                y = i;
                x = j;
                console.log("y: ", y, "x: ", x)
            }
        }
    }
    for (let i = 0; i < subArr.length; i++) {
        for (let j = 0; j < subArr[0].length; j++) {
            console.log(arr[y + i][x + j]);
            console.log(subArr[i][j]);
            if (arr[y + i][x + j] == subArr[i][j]) {
                console.log("loop ran");
                console.log("")
            } else { return false }
        }
    }
    return true + "Holy cow!"
}
console.log(matrixSearch([[12, 34, 45, 56], [98, 87, 76, 65], [56, 67, 78, 89], [54, 43, 32, 21]], [[67, 78], [43, 32]])); // true
console.log(matrixSearch([[12, 34, 45, 56], [98, 87, 76, 65], [56, 67, 78, 89], [54, 43, 32, 21]], [[67, 78], [43, 21]])); // false