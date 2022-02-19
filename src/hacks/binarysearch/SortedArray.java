package hacks.binarysearch;

// https://leetcode.com/problems/binary-search/

public class SortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 33, 55, 66, 78, 99, 101};
        var array = new SortedArray();

        var result = array.binarySearch(nums, 66);
        System.out.println(result); // 4

        var result1 = array.recursiveBinarySearch(nums, 101, 0, nums.length - 1);
        System.out.println(result1); // 7
    }

    // approach: divide the array in half and search the element, if not found keep dividing
    int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1; // 0 based index

        // if our start pointer is greater than end pointer that means we didn't find the target
        while (start <= end) {
            int mid = start + (end - start) / 2; // to avoid stack overflow for large int
            if (array[mid] == target) return mid;
                // if middle element in the range is less than target that means target lies on the right side
            else if (array[mid] < target) start = mid + 1;
            else end = mid - 1; // else on the left side
        }
        return -1;// means we didn't find the target
    }

    // using recursion
    int recursiveBinarySearch(int[] array, int target, int start, int end) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (array[mid] == target) return mid;
        else if (array[mid] < target) {
            return recursiveBinarySearch(array, target, mid + 1, end);
        } else {
            return recursiveBinarySearch(array, target, start, mid - 1);
        }
    }
}