package com.catzhang.search;

import java.util.ArrayList;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 9:12 AM
 * @description: Simple implementation of binary search
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList<Integer> integers = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(integers);
    }

    //Define BinarySearch method
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue > midValue) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findValue) {
                    break;
                }
                integerArrayList.add(temp);
                temp--;
            }
            integerArrayList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findValue) {
                    break;
                }
                integerArrayList.add(temp);
                temp++;
            }
            return integerArrayList;
        }
    }
}
