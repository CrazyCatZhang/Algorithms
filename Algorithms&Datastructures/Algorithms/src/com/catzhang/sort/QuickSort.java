package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 6:44 PM
 * @description: Simple implementation of quick sort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //Define QuickSort method
    public static void quickSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[(high + low) / 2];
        while (left < right) {
            while ((left < right) && arr[right] > pivot) {
                right--;
            }
            while ((left < right) && arr[left] < pivot) {
                left++;
            }
            if (arr[left] == arr[right] && left < right) {
                left++;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if (left - 1 > low) {
            quickSort(arr, low, left - 1);
        }
        if (right + 1 < high) {
            quickSort(arr, right + 1, high);
        }
    }
}
