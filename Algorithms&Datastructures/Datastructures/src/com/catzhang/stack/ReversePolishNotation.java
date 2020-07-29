package com.catzhang.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author: crazycatzhang
 * @date: 2020/7/29 11:19 AM
 * @description: Simple implementation of inverse Polish expression
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String infixExpression = new String("1+((2+3)*4)-5");
        List<String> toInfixExpressionList = toInfixExpressionList(infixExpression);
        System.out.println(toInfixExpressionList);
        System.out.println();
        List<String> postfixExpressionList = convertToPostfixExpression(toInfixExpressionList);
        System.out.println(postfixExpressionList);
        System.out.println();
        System.out.println("The calculate result is: " + calculate(postfixExpressionList));
    }

    //Store the infix expression in ArrayList
    public static List<String> toInfixExpressionList(String infixExpression) {
        ArrayList<String> infixExpressionList = new ArrayList<>();
        String str = "";
        char ch;
        int index = 0;
        do {
            if ((ch = infixExpression.charAt(index)) < 48 || (ch = infixExpression.charAt(index)) > 57) {
                infixExpressionList.add("" + ch);
                index++;
            } else {
                str = "";
                while (index < infixExpression.length() && (ch = infixExpression.charAt(index)) >= 48 && (ch = infixExpression.charAt(index)) <= 57) {
                    str += ch;
                    index++;
                }
                infixExpressionList.add(str);
            }
        } while (index < infixExpression.length());
        return infixExpressionList;
    }

    //Convert infix expression to postfix expression
    public static List<String> convertToPostfixExpression(List<String> infixExpression) {
        Stack<String> stack = new Stack<>();
        List<String> postfixExpressionList = new ArrayList<>();
        for (String item :
                infixExpression) {
            if (item.matches("\\d+")) {
                postfixExpressionList.add(item);
            } else if (stack.isEmpty() || item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (stack.size() != 0 && !stack.peek().equals("(")) {
                    postfixExpressionList.add(stack.pop());
                }
                stack.pop();
            } else {
                while (stack.size() != 0 && Operation.getValue(item) <= Operation.getValue(stack.peek())) {
                    postfixExpressionList.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (stack.size() != 0) {
            postfixExpressionList.add(stack.pop());
        }
        return postfixExpressionList;
    }

    //Calculate the value of the reverse Polish expression
    public static int calculate(List<String> postfixExpression){
        Stack<String> stack = new Stack<>();
        for (String item :
                postfixExpression) {
            if (item.matches("\\d+")){
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                if (item.equals("+")){
                    result = num2 + num1;
                }else if (item.equals("-")){
                    result = num2 - num1;
                }else if (item.equals("*")){
                    result = num2 * num1;
                }else if (item.equals("/")){
                    result = num2 / num1;
                }else {
                    throw new RuntimeException("Wrong operator...");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//Define a priority class
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
