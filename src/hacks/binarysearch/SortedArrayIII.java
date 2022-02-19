package hacks.binarysearch;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class SortedArrayIII
    {
        public static void Test()
        {
            var arr = new int[] { 5, 7, 7, 8, 8, 10 };
            //var arr1 = new int[]{2,2};
            var target = 8;
            //var target1 = 2;
            var array = new SortedArrayIII();
            var result = array.findFirstAndLastPosition(arr, target);
            System.out.println(Arrays.toString(result));
        }

        int[] findFirstAndLastPosition(int[] arr, int target)
        {
            int first = findFirstOccurrence(arr, target);
            int last = findLastOccurrence(arr, target);
            return new int[] { first, last };
        }

        int findFirstOccurrence(int[] array, int target)
        {
            int start = 0, end = array.length - 1;
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                // if array[mid] is greater than array[mid-1] then it is the first occurrence
                // checking mid == start, so that we don't get index out of bound
                if ((mid == start || array[mid] > array[mid - 1]) && array[mid] == target) return mid;
                else if (array[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return -1;
        }

        int findLastOccurrence(int[] array, int target)
        {
            int start = 0, end = array.length - 1;
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                if ((mid == end || array[mid] < array[mid + 1]) && array[mid] == target) return mid;
                // if array[mid] element and array[mid+1] element is same then we need to move on right side
                else if (array[mid] <= target) start = mid + 1; // case [2,2] t = 2
                else end = mid - 1;
            }
            return -1;
        }
    }
