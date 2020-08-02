package com.catzhang.recursion.eightqueen;

/**
 * @author: crazycatzhang
 * @date: 2020/7/29 6:23 PM
 * @description: Simple realization of the eight queens problem
 */
public class EightQueenDemo {
    public static void main(String[] args) {
        new EightQueen().eightQueen(0);
    }
}

//Define EightQueen
class EightQueen {
    private int count = 0;
    private int rowMax = 8;
    private int columnMax = 8;
    private int[][] arrayQueen = new int[rowMax][columnMax];

    public EightQueen() {
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < columnMax; j++) {
                arrayQueen[i][j] = 0;
            }
        }
    }

    public void print() {
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < columnMax; j++) {
                System.out.print(arrayQueen[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Determine whether the placement of the eight queens is correct
    public boolean isCorrect(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (arrayQueen[i][y] == 1) {
                return false;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (arrayQueen[i][j] == 1) {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < this.columnMax; i--, j++) {
            if (arrayQueen[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    //Place eight queens
    public void eightQueen(int level){
        if (level == rowMax || level == columnMax){
            count++;
            System.out.println("This is the " + count + " solution");
            print();
            return;
        }else {
            for (int i = 0; i < columnMax; i++) {
                if (isCorrect(level,i)){
                    for (int j = 0; j < columnMax; j++) {
                        arrayQueen[level][j] = 0;
                    }
                    arrayQueen[level][i] = 1;
                    eightQueen(level + 1);
                }
            }
        }
    }
}
