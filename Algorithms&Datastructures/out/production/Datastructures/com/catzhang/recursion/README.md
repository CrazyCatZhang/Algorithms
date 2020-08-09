# Recursion

## 1. Basic Introduction

 - ##### Recursion is a method that calls itself, passing in different variables each time it is called. Recursion helps programmers solve complex problems, and at the same time makes the code concise

## 2. Applications

 - ##### Various mathematical problems such as: 8 Queens problem, Tower of Hanoi, factorial problem, maze problem, ball and basket problem

 - ##### Recursion is also used in various algorithms, such as fast sorting, merge sort, binary search, divide and conquer algorithm, etc.

 - ##### Problems that will be solved with the stack --> The recursive code is more concise

## 3. Rules

 - ##### When a method is executed, a new protected independent space (stack space) is created

 - ##### The local variables of the method are independent and will not affect each other, such as n variables

 - ##### If the method uses a reference type variable (such as an array), the data of the reference type will be shared.

 - ##### Recursion must approach the condition of exiting recursion, otherwise it is infinite recursion, and `StackOverflowError` appears

 - ##### When a method is executed, or when it encounters return, it will return. Whoever calls it will return the result to whoever. At the same time, when the method is executed or returns, the method will also be executed.