package hacks.binarysearch;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

    public class RotatedArrayII 
    {
        public static void Test() 
        {
            int[] nums = new int[] {2,2,2,0,1};
            var array = new RotatedArrayII();
            var result = array.search(nums, 0);
           System.out.println(result); // 0
        }

        public int search(int[] array, int target)
        {
            int n = array.length;
            if( n == 1 || array[0] < array[n-1]){ // not rotated
                return array[0];
            }
            int minIndex = findMinimumElement(array);
            return array[minIndex];
        }

        // find minimum element
        int findMinimumElement(int[] array)
        {
            var n = array.length;
            int start = 0, end = n-1;
            while(start < end){
                int mid = start + (end-start)/2;
                if(array[mid] > array[end]) start = mid + 1;
                else if(array[mid] == array[end]) {
                    if(end > start && array[end] < array[end-1]) return end; // check if array[end] is the minimum
                    end--;
                }
                else end = mid;
            }
            return start; // array[start] = array[end] = minimum element
        }
    }
