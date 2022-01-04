// Remove the duplicates from a given array. Do not alter the original array, return a new one! Keep the results 'stable' (retain the original order);

// Example: [2,1,2,1,3,4,4,5] ==> [2,1,3,4,5]

// Slightly more difficult! Work 'in-place' in the given array. For this one you can mess with the order if you need too!


function removeDuplicates(arr) {
    let newArr = []
    let dict = {}
    for (var i = 0; i < arr.length; i++) {
        if (!dict[arr[i]]) { //If the number isn't in the dictionary already
            dict[arr[i]] = 1
            newArr.push(arr[i])
        }
    }
    return newArr
}

console.log(removeDuplicates([1, 2, 1, 3, 4, 4, 5])); // [1,2,3,4,5]
console.log(removeDuplicates([1, 2, 1, 3, 4, 4, 5, 4, 4, 4, 4, 6, 6, 6, 6, 78, 7])) // [1, 2, 3, 4, 5, 6, 78, 7]

//===========================================
// Kadane's Algo
//===========================================

// Given an array comprised of numbers that  is potentially very long, return the maximum sum of values from a subarray. Any consecutive seuqence of indices in the array is considered a subarray. Create a function that returns the highest sum possible from these subarrays, and prints the subarray.

// [1,2,-4,3,-2,3,-1] return 4 and print [3,-2,3]

function maxOfSubarray(arr) {
    let sum = 0 //Keeps track of highest sum
    let tempSum = 0
    let bounds = [0, arr.length] //Keeps track of subarray
    for (var i = 0; i < arr.length; i++) {
        tempSum = 0
        for (var j = i; j < arr.length; j++) {
            tempSum += arr[j]
            if (tempSum > sum) {
                bounds[0] = i
                bounds[1] = j
                sum = tempSum
            }
        }
    }
    console.log(arr.slice(bounds[0], bounds[1] + 1))
    return sum
}

console.log(maxOfSubarray([1, 2, -4, 3, -2, 3, -1])); //return 4; prints [3,-2,3]