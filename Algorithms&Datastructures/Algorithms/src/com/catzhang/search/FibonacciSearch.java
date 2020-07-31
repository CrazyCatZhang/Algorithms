package com.catzhang.search;

import java.util.Arrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 10:45 AM
 * @description: Simple implementation of Fibonacci search
 */
public class FibonacciSearch {

    private static final int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int fibonacciSearch = fibonacciSearch(arr, 1234);
        System.out.println(fibonacciSearch);
    }

    //Define FibonacciSearch method
    public static int fibonacciSearch(int[] arr, int value) {
        int left = 0;
        int high = arr.length - 1;
        int key = 0;
        int mid = 0;
        int[] F = fibonacci();
        while (arr.length > F[key] - 1) {
            key++;
        }
        int[] temp = Arrays.copyOf(arr, F[key] - 1);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (left <= high) {
            mid = left + F[key - 1] - 1;
            if (value < temp[mid]) {
                high = mid - 1;
                key--;
            } else if (value > temp[mid]) {
                left = mid + 1;
                key -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    //Define Fibonacci method
    public static int[] fibonacci() {
        int[] F = new int[maxSize];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F;
    }
}
