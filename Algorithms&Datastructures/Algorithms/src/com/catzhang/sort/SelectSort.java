package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 12:34 PM
 * @description: Simple implementation of selection sort
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {101,34,119,1,-1,90,123};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Define SelectSort method
    public static void selectSort(int [] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minOrMaxIndex = i;
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                minOrMaxIndex = arr[minOrMaxIndex] > arr[j] ? j : minOrMaxIndex;
            }
            if (minOrMaxIndex != i){
                temp = arr[i];
                arr[i] = arr[minOrMaxIndex];
                arr[minOrMaxIndex] = temp;
            }
        }
    }
}
