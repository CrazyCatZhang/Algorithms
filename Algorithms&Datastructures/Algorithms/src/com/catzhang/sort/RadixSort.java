package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 11:34 PM
 * @description: Simple implementation of radix sort
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Define RadixSort method
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketElementCounts[j] = 0;
            }
        }
    }
}
