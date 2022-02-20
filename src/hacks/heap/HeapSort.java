package hacks.heap;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/

public class HeapSort {

    // solution doesn't work

    public static void main(String[] args) {
        var arr = new int[]{64, 65, 65, 72, 77, 80, 85, 86, 86, 92, 91, 92, 93, 95, 98};
        buildMaxHeap(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void buildMaxHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            siftUp(array, i);
        }
    }

    static void siftUp(int[] array, int childIndex) {
        // if we are at pos 0 that means we reached the root and there is no other parent to compare with
        while (childIndex > 0) {
            var parentIndex = childIndex / 2;
            if (array[parentIndex] < array[childIndex]) {
                swap(array, childIndex, parentIndex);
                childIndex = parentIndex; // update the current node
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            shiftDown(array, 0, i);
        }
    }

    static void shiftDown(int[] array, int maxElementIndex, int size) {
        var left = maxElementIndex * 2 + 1;
        var right = maxElementIndex * 2 + 2;
        while (left < size) {
            var maxChildIndex = left;
            if (right < size && array[right] > array[left]) {
                maxChildIndex = right;
            }
            if (array[maxElementIndex] < array[maxChildIndex]) {
                swap(array, maxElementIndex, maxChildIndex);
                maxElementIndex = maxChildIndex;
                left = maxElementIndex * 2 + 1;
                right = maxElementIndex * 2 + 2;
            } else {
                break;
            }
        }
    }

}
