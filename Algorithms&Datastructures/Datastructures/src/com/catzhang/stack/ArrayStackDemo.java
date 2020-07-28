package com.catzhang.stack;

import java.util.Scanner;

/**
 * @author: crazycatzhang
 * @date: 2020/7/28 9:04 PM
 * @description: Array simple implementation stack
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        while (true){
            show();
            System.out.println("请选择：");
            int select = new Scanner(System.in).nextInt();
            switch (select){
                case 1:
                    arrayStack.list();
                    break;
                case 2:
                    System.out.println("请输入你要入栈的数据：");
                    arrayStack.push(new Scanner(System.in).nextInt());
                    break;
                case 3:
                    System.out.println(arrayStack.pop());
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public static void show(){
        System.out.println("1.显示栈");
        System.out.println("2.入栈");
        System.out.println("3.出栈");
        System.out.println("0.退出");
    }
}

//Define ArrayStack
class ArrayStack {
    private int capacity;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[this.capacity];
    }

    //Determines whether the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    //Determines whether the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    //Push Stack
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("The Stack is full....");
        }
        stack[++top] = value;
    }

    //Pop Stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The Stack is empty...");
        }
        return stack[top--];
    }

    //Through Stack
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("The Stack is empty...");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
