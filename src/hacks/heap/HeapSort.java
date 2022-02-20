package hacks.heap;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/

public class HeapSort {

    public static void main(String[] args) {
        var arr = new int[]{5,2,0,3,1,4,8};
        HeapSort hp = new HeapSort();
        hp.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sortArray(int[] array) {
        var n = array.length;
        var middle = n/2;
        for(int i = middle; i >= 0 ; i--){
            shiftDown(array, i, n);
        }
        sort(array);
    }

    // build max heap
    void shiftDown(int[] array, int rootIndex, int size) {
        var left = getLeftChild(rootIndex);
        var right = getRightChild(rootIndex);
        while (left < size){
            var maxChildIndex = left;
            if(right < size && array[right] > array[left]){
                maxChildIndex = right;
            }
            if(array[maxChildIndex] > array[rootIndex]){
                swap(array, rootIndex, maxChildIndex);
                rootIndex = maxChildIndex;
                left = getLeftChild(rootIndex);
                right = getRightChild(rootIndex);
            }else{
                break;
            }
        }
    }

    void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // swap the largest element to last index
            swap(array, i, 0);
            // restore max heap
            shiftDown(array, 0, i);
        }
    }

    int getLeftChild(int rootIndex){
        return rootIndex*2+1;
    }

    int getRightChild(int rootIndex){
        return rootIndex*2+2;
    }

    void swap(int[] array, int i, int j) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
