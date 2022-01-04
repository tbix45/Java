// Here, a balance index is ON an index, not BETWEEN indicies. Return the balance index where sums are equeal on either side (exclude its own value). Return -1 if none exist.
// Example 1: [-2, 5, 7, 0, 3]  --> 2 
// The balance index is 2 because on either side of that index the sums are equal:  [-2, 5,  |7| , 0, 3] --> -2+5 == 0+3
// Example 2: [9, 9]  -->  -1
// There is no balance index because there are fewer than 3 indices! As a result, we return -1 to maintain a consistent datatype

function balanceIndex(arr) {
    // your code here
    let left = 0;
    let right = arr.length - 1;
    let sumLeft = 0;
    let sumRight = 0;
    while (left < right) {
        sumLeft += arr[left];
        sumRight += arr[right];
        if (sumLeft === sumRight) {
            if (right - left === 2) {
                return left + 1;
            } else {
                return -1;
            }
        }
        left++
        right--
    }
    return -1;
}
//     var sumTotal = 0
//     for (let i=0; i<arr.length; i++) {
//         sumTotal += arr[i];
//     }
//     var sumWorking = 0;
//     for (let j=0; j<arr.length; j++) {
//         sumTotal = sumTotal - arr[j];
//         if (sumTotal == sumWorking) {
//             return j;
//         }
//         sumWorking += arr[j];
//     }
//     return -1;
// }


console.log(balanceIndex([-2, 5, 7, 0, 3])); // 2
console.log(balanceIndex([9, 9])); // -1


// Write a function that returns whether the given array has a balance point between indices, where one side's sum is equal to the other's. 
// Example: [1,2,3,4,10] --> True
// the belenace point happens b/w indices 3 & 4 where the left side equals the right:  [1, 2, 3, 4  |  10]  ==> 1+2+3+4 = 10

function balancePoint(arr) {
    if (arr.length < 2) {
        return false;
    }

    let leftSum = arr[0];
    let rightSum = 0;

    for (let i = 1; i < arr.length; i++) {
        rightSum += arr[i];
    }

    for (let i = 1; i < arr.length; i++) {
        if (leftSum === rightSum) {
            return true;
        }
        leftSum += arr[i];
        rightSum -= arr[i];
    }

    return false
}

console.log(balancePoint([4, 3, 7, 4, 10])); // true
console.log(balancePoint([4, 3, 7, 4, 11, 2])); // false