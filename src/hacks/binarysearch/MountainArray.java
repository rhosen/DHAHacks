package hacks.binarysearch;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/

    public class MountainArray
    {
        public static void Test()
        {
            int[] arr = new int[] { 1, 15, 25, 45, 42, 21, 17, 12, 11 };
            var target = 17;
            var array = new MountainArray();
            var result = array.findIndex(arr, target);
            System.out.println(result);
        }

        // Initially array element is increasing and then decreasing
        // That means we need to find the max element index
        // Then run binary search from 0 to peak element index
        // if not found try peakIndex + 1 to array length -1
        int findIndex(int[] arr, int target)
        {
            var peakIndex = findMaximum(arr);
            var result = binarySearchAsc(arr, target, 0, peakIndex);
            if (result != -1) return result;
            else return binarySearchDsc(arr, target, peakIndex + 1, arr.length - 1);
        }

        int findMaximum(int[] arr)
        {
            var start = 0;
            var end = arr.length - 1;
            while (start <= end)
            {
                var mid = start + (end - start) / 2;
                // before breaking the loop start and end both will point to the largest element
                if (start == end) return mid;
                // we are in descending part of the array, arr[mid] could be the biggest element but look at the left part
                else if (arr[mid] > arr[mid + 1]) end = mid;
                // it's obvious that arr[mid+1] is bigger that arr[mid] so we ignore arr[mid]
                else if (arr[mid] < arr[mid + 1]) start = mid + 1;
            }
            return -1;
        }

        int binarySearchAsc(int[] array, int target, int start, int end)
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

        int binarySearchDsc(int[] array, int target, int start, int end)
        {
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                if (array[mid] == target) return mid;
                else if (array[mid] < target) end = mid - 1;
                else start = mid + 1;
            }
            return -1;
        }
    }