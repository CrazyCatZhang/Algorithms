package com.catzhang.sparsearrays;

/**
 * @author: crazycatzhang
 * @date: 2020/7/27 3:31 下午
 * @description: Conversion between sparse and two-dimensional arrays
 */
public class SparseArrays {
    public static void main(String[] args) {
        //1.Two-dimensional Arrays -> SparseArrays
        //Creat 11*11 chessArray1
        int[][] chessArray1 = new int[11][11];
        //Assign values to certain positions in the array
        chessArray1[2][3] = 1;
        chessArray1[3][5] = 2;
        chessArray1[4][6] = 3;
        //Through the chessArray1 And Gets the number of data
        int sum = 0;
        for (int[] data :
                chessArray1) {
            for (int values :
                    data) {
                System.out.print(values + "\t");
                if (values != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println();
        //Creat SparseArrays
        int[][] sparseArrays = new int[sum + 1][3];
        //Assign a value to a sparse array
        sparseArrays[0][0] = chessArray1.length;
        sparseArrays[0][1] = chessArray1[0].length;
        sparseArrays[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArrays[count][0] = i;
                    sparseArrays[count][1] = j;
                    sparseArrays[count][2] = chessArray1[i][j];
                }
            }
        }

        //Through the sparseArrays
        for (int[] data :
                sparseArrays) {
            for (int values :
                    data) {
                System.out.print(values + "\t");
            }
            System.out.println();
        }
        System.out.println();
        //2.SparseArrays -> Two-dimensional Arrays
        //Creat new chessArray
        int[][] chessArray2 = new int[sparseArrays[0][0]][sparseArrays[0][1]];

        //Through the sparseArrays And assign value to chessArray2
        for (int i = 1; i < sparseArrays.length; i++) {
            chessArray2[sparseArrays[i][0]][sparseArrays[i][1]] = sparseArrays[i][2];
        }

        //Through the chessArray2
        for (int[] data :
                chessArray2) {
            for (int values :
                    data) {
                System.out.print(values + "\t");
            }
            System.out.println();
        }
    }
}
