package hacks.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://binarysearch.com/problems/Kth-Smallest-Element
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/

public class MaxHeap {

    public static void main(String[] args) {
        var arr = new int[]{5, 3, 8, 2, 0};
        var k = 2;
        MaxHeap heap = new MaxHeap();
        var res = heap.find(arr, k);
        System.out.println(res); // 3
    }

    // delete all except k small element from max heap
    int find(int[] array, int k) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            pq.add(array[i]);
            if (pq.size() > k + 1) pq.poll();
        }
        return pq.poll();
    }
}