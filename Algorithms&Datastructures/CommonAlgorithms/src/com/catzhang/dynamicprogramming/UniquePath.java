package com.catzhang.dynamicprogramming;

/**
 * @author: crazycatzhang
 * @date: 2020/8/5 4:27 PM
 * @description: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below)
 */
public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePath(1, 3));
    }

    //Define UniquePath method
    public static int uniquePath(int m, int n) {
        int[][] opt = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    opt[i][j] = 1;
                } else {
                    opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
                }
            }
        }
        return opt[m - 1][n - 1];
    }
}
