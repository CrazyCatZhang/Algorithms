package com.catzhang.search.linersearch;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 8:40 AM
 * @description: Simple implementation of linear search
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = linearSearch(arr, 11);
        if (index == -1) {
            System.out.println("The value is not existed...");
        } else {
            System.out.println(index);
        }
    }

    //Define LinearSearch method
    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
