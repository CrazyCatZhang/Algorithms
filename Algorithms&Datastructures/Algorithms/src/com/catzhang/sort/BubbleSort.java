package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 9:01 AM
 * @description: Simple implementation of bubble sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Define BubbleSort Method
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
