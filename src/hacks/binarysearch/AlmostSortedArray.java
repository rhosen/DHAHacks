package hacks.binarysearch;

// https://www.geeksforgeeks.org/search-almost-sorted-array/

    public class AlmostSortedArray
    {
        public static void Test()
        {
            var array = new AlmostSortedArray();
            var arr = new int[] { 10, 3, 40, 20, 50, 80, 70 };
            var target = 40;
            var result = array.binarySearch(arr, target);
            System.out.println(result); // 2
        }

        int binarySearch(int[] array, int target)
        {
            int start = 0;
            int end = array.length - 1;

            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                if (array[mid] == target) return mid;
                else if (array[mid + 1] == target) return mid + 1; // check next element
                else if (array[mid - 1] == target) return mid - 1; // check previous element
                else if (array[mid] < target) start = mid + 2; // since we checked the next element as well
                else end = mid - 2; // since we check the prev element as well
            }
            return -1;
        }
    }