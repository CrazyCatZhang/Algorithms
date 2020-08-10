package com.catzhang.tree.arraybinarytree;

/**
 * @author: crazycatzhang
 * @date: 2020/8/1 9:27 AM
 * @description: Simple implementation of sequential storage binary tree
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
        System.out.println();
        arrayBinaryTree.middleOrder();
        System.out.println();
        arrayBinaryTree.postOrder();
    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void middleOrder() {
        this.middleOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    //Define PreOrder method
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("The tree is empty...");
            return;
        }
        System.out.print(arr[index] + " ");
        if ((index * 2 + 1) < arr.length) {
            preOrder((index * 2 + 1));
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder((index * 2 + 2));
        }
    }

    //Define MiddleOrder method
    public void middleOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("The tree is empty...");
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            middleOrder((index * 2 + 1));
        }
        System.out.print(arr[index] + " ");
        if ((index * 2 + 2) < arr.length) {
            middleOrder((index * 2 + 2));
        }
    }

    //Define PostOrder method
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("The tree is empty...");
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            postOrder((index * 2 + 1));
        }
        if ((index * 2 + 2) < arr.length) {
            postOrder((index * 2 + 2));
        }
        System.out.print(arr[index] + " ");
    }
}
