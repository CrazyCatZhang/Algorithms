package com.catzhang.binarysearchnorecursion;

/**
 * @author: crazycatzhang
 * @date: 2020/8/4 6:35 PM
 * @description: Simple implementation of binary search no recursion
 */
public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(binarySearch(arr,1000));
    }

    //Define BinarySearch method
    public static int binarySearch(int[] arr,int value){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (value == arr[mid]){
                return mid;
            }else if (value < arr[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
