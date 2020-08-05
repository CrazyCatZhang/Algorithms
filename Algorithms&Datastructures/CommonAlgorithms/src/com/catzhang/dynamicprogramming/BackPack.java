package com.catzhang.dynamicprogramming;

/**
 * @author: crazycatzhang
 * @date: 2020/8/5 8:10 PM
 * @description: Realize the 0 1 knapsack problem through dynamic programming
 */
public class BackPack {
    public static void main(String[] args) {
        int[] value = {1500, 3000, 2000};
        int[] weight = {1, 4, 3};
        System.out.println(backPack(value, weight, 4));
    }

    //Define BackPack method
    public static int backPack(int[] value, int[] weight, int M) {
        int[][] opt = new int[value.length + 1][M + 1];
        for (int i = 0; i < value.length; i++) {
            opt[i][0] = 0;
        }
        for (int j = 0; j < opt[0].length; j++) {
            opt[0][j] = 0;
        }
        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; j < opt[0].length; j++) {
                if (weight[i - 1] > j) {
                    opt[i][j] = opt[i - 1][j];
                } else {
                    opt[i][j] = Math.max(opt[i - 1][j], value[i - 1] + opt[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return opt[value.length][M];
    }
}
