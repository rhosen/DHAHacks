package hacks.binarysearch;

// https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1/#
// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

    public class SortedArrayII
    {
        public static void Test()
        {

            SortedArrayII floorCeiling = new SortedArrayII();
            var num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13 };
            var result = floorCeiling.find(num, 11, true);
            System.out.println(result);//9
        }

        // Find the greatest element smaller than target / find floor of target
        // Find the smallest element greater than target / find ceil of target / find insert position of target
        int find(int[] array, int target, boolean isFloor)
        {
            //if(target < array[0]) return -1; // if there is no element smaller than target
            int start = 0;
            int end = array.length - 1;

            // if target is not present in the input, at one point start and end index will be same
            // in last iteration start will be greater than end
            // that means arr[end] is smaller than target and array[start] is grater than target
            while (start <= end)
            {
                int mid = start + (end - start) / 2;
                //if(array[mid] == target) return mid; // if target is present, and it is a candidate
                if (array[mid] < target) start = mid + 1;
                else end = mid - 1;
            }
            return isFloor ? end : start;
            // Scenario: Find the smallest element greater than target
            // What if the target is the last element in the array?
            // In that case we will get "Index was outside the bounds of the array."
            // This is a great question to ask interviewer, and chances are that the interviewer will tell you to wrap around the element
            // To achieve it we can mod start by array length to move to the first index
            // So we
            // return array[start%array.Length];
        }
    }

