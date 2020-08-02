package com.catzhang.tree.heapsort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/8/2 4:38 PM
 * @description: Simple implementation of heap sort
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    //Define the method of HeapSort
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            constructHeap(arr, i, arr.length);
        }
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            constructHeap(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    //Define the method of construct Heap
    public static void constructHeap(int[] arr, int index, int length) {
        int temp = arr[index];
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }
}
