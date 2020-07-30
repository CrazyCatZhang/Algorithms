package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 8:52 PM
 * @description: Simple implementation of merge sort
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //Define MergeSort method
    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (high + low) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }

    //Define Merge method
    public static void merge(int[] arr, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + low] = temp[i];
        }
    }
}
