package com.catzhang.divideandconquer;

/**
 * @author: crazycatzhang
 * @date: 2020/8/4 7:26 PM
 * @description: Realize the Tower of Hanoi through divide and conquer
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
        System.out.println(count);
    }

    private static int count = 0;

    //Define the DAC method
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("The 1 plate from " + a + " to " + c);
            count++;
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("The " + num + " plate from " + a + " to " + c);
            count++;
            hanoiTower(num - 1, b, a, c);
        }
    }
}
