package hacks.binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/

  public class RotatedArray
    {
        public static void Test()
        {
            int[] numbers = new int[] { 4, 5, 6, 7, 0, 1, 2 };
            RotatedArray array = new RotatedArray();
            var result = array.searchElement(numbers, 0);
            System.out.println(result); // 4
        }

        // Approach find minimum element index
        // Search 0 to index of min element - 1
        // If not found search form min to array length - 1
        public int searchElement(int[] array, int target)
        {
            int n = array.length;
            if (n == 1 || array[0] < array[n - 1])
            { // not rotated
                return binarySearch(array, target, 0, n - 1);
            }
            int min = findMinimumElement(array);
            int result = binarySearch(array, target, 0, min - 1);
            if (result != -1) return result;
            return binarySearch(array, target, min, n - 1);
        }

        // find minimum element
        int findMinimumElement(int[] array)
        {
            var n = array.length;
            int start = 0, end = n - 1;
            while (start < end)
            {
                int mid = start + (end - start) / 2;
                // if middle element is greater than last element than min element will be found at right side
                if (array[mid] > array[end]) start = mid + 1;
                // mid is a candidate for minimum number so can't do mid-1
                else end = mid;
            }
            return start; // array[start] = array[end] = minimum element // times array is rotated
        }

        // typical binary search
        int binarySearch(int[] array, int target, int start, int end)
        {
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                if (array[mid] == target) return mid;
                else if (array[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return -1;
        }
    }