package com.catzhang.dynamicprogramming;

/**
 * @author: crazycatzhang
 * @date: 2020/8/5 5:01 PM
 * @description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *               Each element in the array represents your maximum jump length at that position.
 *               Determine if you are able to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jumpGame(arr));
    }

    //Define JumpGame method
    public static boolean jumpGame(int[] arr) {
        boolean[] opt = new boolean[arr.length];
        opt[0] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (opt[j] && j + arr[j] >= i) {
                    opt[i] = true;
                    break;
                }
            }
        }
        return opt[arr.length - 1];
    }
}
