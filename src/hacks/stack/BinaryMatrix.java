package hacks.stack;

import hacks.stack.helper.Pair;

import java.util.Stack;

// https://binarysearch.com/problems/Largest-Rectangle-Submatrix
// https://leetcode.com/problems/maximal-rectangle/

public class BinaryMatrix {

    public static void main(String[] args) {
        var rect = new BinaryMatrix();
        var mat = new char[][]{
                new char[]{'1', '1', '1', '0'},
                new char[]{'1', '0', '1', '1'},
                new char[]{'1', '0', '1', '1'},
                new char[]{'1', '1', '1', '0'}
        };
        var res = rect.maximalRectangle(mat);
        System.out.println(res); // 4
    }

    public int maximalRectangle(char[][] matrix) {
        // add rows and check for max area, keep doing it till last array
        // if current row element is 0 we are going to ignore it
        var maxArea = 0;
        var n = matrix[0].length;
        var matrixSum = new int[n];
        for (int row = 0; row < matrix.length; row++) {
            var currentRow = matrix[row];
            for (int col = 0; col < currentRow.length; col++) {
                if (matrix[row][col] == '0') matrixSum[col] = 0;
                else matrixSum[col] += matrix[row][col] - '0';
            }
            maxArea = findMaxRect(matrix, matrixSum, row, maxArea);
        }
        return maxArea;
    }

    int findMaxRect(char[][] matrix, int[] matrixSum, int row, int maxArea) {
        // find the smallest element index to right
        int[] rb = findSmallestElementIndexToRight(matrixSum);
        int[] lb = findSmallestElementIndexToLeft(matrixSum);
        maxArea = findMaxArea(matrix, matrixSum, rb, lb, row, maxArea);
        return maxArea;
    }

    int[] findSmallestElementIndexToRight(int[] matrixSum) {
        var n = matrixSum.length;
        var result = new int[n];
        var st = new Stack<Pair>();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek().getElement() >= matrixSum[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = st.peek().getIndex();
            }
            st.push(new Pair(matrixSum[i], i));
        }
        return result;
    }

    int[] findSmallestElementIndexToLeft(int[] matrixSum) {
        var n = matrixSum.length;
        var result = new int[n];
        var st = new Stack<Pair>();
        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && st.peek().getElement() >= matrixSum[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek().getIndex();
            }
            st.push(new Pair(matrixSum[i], i));
        }
        return result;
    }

    int findMaxArea(char[][] matrix, int[] matrixSum, int[] rb, int[] lb, int row, int maxArea) {
        for (int i = 0; i < matrixSum.length; i++) {
            if (matrix[row][i] == '1') {
                var count = rb[i] - lb[i] - 1;
                var area = count * matrixSum[i];
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

}
