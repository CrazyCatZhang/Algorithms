package com.catzhang.search;

import java.util.ArrayList;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 9:46 AM
 * @description: Simple implementation of interpolation search
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        ArrayList<Integer> integers = interpolationSearch(arr, 0, arr.length - 1, 1);
        System.out.println(integers);
    }

    //Define InterpolationSearch method
    public static ArrayList<Integer> interpolationSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return new ArrayList<Integer>();
        }
        //Adaptive mid
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue) {
            return interpolationSearch(arr, mid + 1, right, findValue);
        } else if (findValue < midValue) {
            return interpolationSearch(arr, left, mid - 1, findValue);
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
