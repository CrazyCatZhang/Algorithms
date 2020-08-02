package com.catzhang.stack.calculator;

/**
 * @author: crazycatzhang
 * @date: 2020/7/29 7:55 AM
 * @description: Use the stack to implement a simple calculator
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println(calculator("7*2*2-5+1-5+3-4"));
    }

    public static int calculator(String str) {
        ArraysStack numStack = new ArraysStack(10);
        ArraysStack operatorStack = new ArraysStack(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        String temp = "";
        char ch;
        while (true) {
            ch = str.substring(index, index + 1).charAt(0);
            if (operatorStack.isOperator(ch)) {
                if (!operatorStack.isEmpty()) {
                    if (operatorStack.priority(ch) <= operatorStack.priority((char) operatorStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(numStack.operator(num1, num2, (char) operatorStack.peek()));
                        operatorStack.pop();
                    }
                }
                operatorStack.push(ch);
            } else {
                temp += ch;
                if (index == str.length() - 1) {
                    numStack.push(Integer.parseInt(temp));
                } else {
                    if (operatorStack.isOperator(str.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(temp));
                        temp = "";
                    }
                }
            }
            index++;
            if (index >= str.length()) {
                break;
            }
        }
        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            numStack.push(numStack.operator(num1, num2, (char) operatorStack.peek()));
            operatorStack.pop();
        }
        return numStack.pop();
    }
}

class ArraysStack {
    private int capacity;
    private int[] stack;
    private int top = -1;

    public ArraysStack(int capacity) {
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

    //Get the top data of the stack
    public int peek() {
        return stack[top];
    }

    //Determines whether the char is operator
    public boolean isOperator(char ch) {
//        return (ch == '+' || ch == '-' || ch = '*' || ch == '/');
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

    //Define the priority of the operator
    public int priority(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        }
        return -1;
    }

    //Operator the numbers
    public int operator(int num1, int num2, char ch) {
        int result = 0;
        switch (ch) {
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            default:
                break;
        }
        return result;
    }
}
