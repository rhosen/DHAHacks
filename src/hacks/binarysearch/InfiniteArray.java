package hacks.binarysearch;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

    public class InfiniteArray
    {
        public static void Test()
        {
            int[] nums = new int[] { 1, 2, 33, 55, 66, 78, 99, 101, 102 };
            var target = 78;
            var array = new InfiniteArray();
            var result = array.Search(nums, target);
            System.out.println(result); // 5
        }

        // This is a tricky question, we have to search element in an infinite array
        // To be honest the array will not be infinite, it is just that we are not allowed to use array.Length method
        // So how can we find the upper limit?
        // We will see if target lies in between start = 0 to end = 1
        // If not found we will set start=end and end=2*end
        // Since input is infinite we assume there will be no case that will result in index out of bound
        int Search(int[] array, int target)
        {
            var indexes = findRange(array, target);
            return binarySearch(array, target, indexes[0], indexes[1]);
        }

        int[] findRange(int[] array, int target)
        {
            int start = 0;
            int end = 1;
            while (target > array[end])
            {
                start = end;
                end = end * 2;
            }
            return new int[] { start, end };
        }

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