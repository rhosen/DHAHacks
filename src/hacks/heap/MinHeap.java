package hacks.heap;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class MinHeap {

    public static void main(String[] args) {
        var arr = new int[]{3,2,1,5,6,4};
        var k = 2;
        var res = minHeap(arr, 2);
        System.out.println(res); // 5
    }

    // delete all except k large element
    static int minHeap(int[] array, int k) {
        var pq = new PriorityQueue<Integer>();
        for(int i = 0; i < array.length; i++){
            pq.add(array[i]);
            if( pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}