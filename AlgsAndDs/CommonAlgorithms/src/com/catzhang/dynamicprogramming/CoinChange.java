package com.catzhang.dynamicprogramming;

/**
 * @author: crazycatzhang
 * @date: 2020/8/5 4:03 PM
 * @description: Use dynamic programming to easily achieve X with the least kinds of coins
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        System.out.println(coinChange(arr, 27));
    }

    //Define coinChange method
    public static int coinChange(int[] arr, int M) {
        int[] opt = new int[M + 1];
        opt[0] = 0;
        for (int i = 1; i < opt.length; i++) {
            opt[i] = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j] && opt[i - arr[j]] != Integer.MAX_VALUE) {
                    opt[i] = Math.min(opt[i - arr[j]] + 1, opt[i]);
                }
            }
        }
        if (opt[M] == Integer.MAX_VALUE) {
            return -1;
        }
        return opt[M];
    }
}
