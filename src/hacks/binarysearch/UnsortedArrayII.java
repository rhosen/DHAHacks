package hacks.binarysearch;//

// https://leetcode.com/problems/split-array-largest-sum/

public class UnsortedArrayII {

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4, 5};
        var count = 2;
        var array = new UnsortedArrayII();
        var result = array.findMinimizedMaximumSum(arr, count);
        System.out.println(result);
    }

    // We don't know what can be the minimized maximum sum
    // However, we know that the largest element in the array can be the lowest maximum if we split the array into n part where n = array.Length
    // Again, if we split the array into 1 part, the maximum sum will be the sum of all the element in the array
    // Now, we have a range and applying binary search in this range we can find the number that fulfills given conditions
    int findMinimizedMaximumSum(int[] array, int count) {
        var range = getRange(array);
        var start = range[0];
        var end = range[1];
        int maxSum = 0;
        while (start <= end) {
            var mid = start + (end - start) / 2;
            var currentCount = getSplitCount(array, count, mid);
            if (currentCount > count) { // we need to take larger sum
                start = mid + 1;
            } else {
                maxSum = mid; // got our sum
                end = mid - 1; // let's see if we can do batter
            }
        }
        return maxSum; // or start
    }

    int getSplitCount(int[] array, int count, int allowedSum) {
        int sum = 0;
        var currentCount = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > allowedSum) {
                sum = array[i]; // new array sum
                currentCount++; // split the array
            }
            if (currentCount > count) return currentCount;
        }
        return currentCount;
    }

    int[] getRange(int[] array) {
        int start = 0, end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > start) start = array[i];
            end += array[i];
        }
        return new int[]{start, end};
    }
}

