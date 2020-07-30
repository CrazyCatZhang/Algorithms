package com.catzhang.sort;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/30 3:17 PM
 * @description: Simple implementation of insertion sort
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] arr = {101,34,119,1,-1,89};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Define InsertSort method
    public static void insertSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
