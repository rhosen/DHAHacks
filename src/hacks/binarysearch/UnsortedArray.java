package hacks.binarysearch;

// https://leetcode.com/problems/find-peak-element/

    public class UnsortedArray
    {
        public static void Test()
        {
            var array = new UnsortedArray();
            var nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
            var result = array.findPeak(nums);
            System.out.println(result);// 5
        }

        int findPeak(int[] arr)
        {
            var start = 0;
            var end = arr.length - 1;
            while (start <= end)
            {
                var mid = start + (end - start) / 2;
                if (start == end) return mid;
                else if (arr[mid] > arr[mid + 1]) end = mid;
                else if (arr[mid] < arr[mid + 1]) start = mid + 1;
            }
            return -1;
        }
    }
