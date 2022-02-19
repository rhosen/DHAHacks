package hacks.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/
// https://leetcode.com/problems/search-a-2d-matrix-ii/
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/submissions/ [slight variation]

public class SortedMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        };
        var target = 3;
        var matrix = new SortedMatrix();
        boolean result = matrix.isElementFound(mat, target);
        System.out.println(result); // true
    }

    // Since all rows are sorted we can apply binary search on each row, and we will have our answer
    // However, the time complexity will be O(nlog(n)) and we can do better since the columns are also sorted
    // Instead of applying binary search we will use a pointer to search the element, obviously keeping in mind that the array is sorted
    // Time complexity for solution will be O(m+n) where m is numbers of row and n is number of columns
    boolean isElementFound(int[][] mat, int target) {
        // we will start from last index of first row
        // if our target is less than the current element we will go down in value that is col-1
        // else we will go up in value that is row+1
        var row = 0;
        var col = mat[row].length - 1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}

