package hacks.stack;

import java.util.Stack;

class Pair {
    int element;
    int index;

    Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}

// https://leetcode.com/problems/largest-rectangle-in-histogram/

public class Histogram {

    public static void main(String[] args) {
        var histogram = new Histogram();
        var arr = new int[]{2, 1, 5, 6, 2, 3};
        var res = histogram.largestRectangleArea(arr);
        System.out.println(res); // 10
    }

    public int largestRectangleArea(int[] heights) {
        // find next smallest element to right
        int[] rightIndexes = FindSmallestElementIndexToRight(heights);
        // find next smallest element on left
        int[] leftIndexes = FindSmallestElementIndexToLeft(heights);
        int maxArea = FindMaxArea(heights, rightIndexes, leftIndexes);
        return maxArea;
    }

    private int FindMaxArea(int[] heights, int[] rightIndexes, int[] leftIndexes) {
        var maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // between left index and right index we have the histogram which has same or greater heights
            var count = rightIndexes[i] - leftIndexes[i] - 1;
            var area = count * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    private int[] FindSmallestElementIndexToLeft(int[] heights) {
        var st = new Stack<Pair>();
        var indexes = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (st.size() > 0 && st.peek().element >= heights[i]) st.pop();
            if (st.isEmpty()) {
                indexes[i] = -1;
            } else {
                indexes[i] = st.peek().index;
            }
            st.push(new Pair(heights[i], i));
        }
        return indexes;
    }

    private int[] FindSmallestElementIndexToRight(int[] heights) {
        var st = new Stack<Pair>();
        var n = heights.length;
        var indexes = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // keep removing from stack until smallest element is found
            while (st.size() > 0 && st.peek().element >= heights[i]) st.pop();
            if (st.isEmpty()) {
                // no smallest element is found, so will use the array length to calculate the same or greater histogram
                indexes[i] = n;
            } else {
                // found next smallest element
                indexes[i] = st.peek().index;
            }
            st.push(new Pair(heights[i], i));
        }
        return indexes;
    }

}
