# ArrayStack

## 1. Basic Introduction

	- ##### Use the array to simulate the use of the stack. Since the stack is an ordered list, of course, you can use the structure of the array to store the data content of the stack. Next, we will use the array to simulate the stacking and stacking operations.

## 2. Achieve

 - ##### Define an array to store data and simulate stack

   ```java
   private int[] stack;
   ```

   

 - ##### Define a top pointer to point to the top element of the stack, initialized to -1

   ```java
   private int top = -1;
   ```

   

 - ##### Determine if the stack is full

   ```java
   public boolean isFull() {
       return top == capacity - 1;
   }
   
   ```

   

 - ##### Determine if the stack is empty

   ```java
   public boolean isEmpty() {
       return top == -1;
   }
   ```

   

 - ##### Stack operation: When the stack is not full, first store ==top++==, and then store ==data== in the memory address with top as the subscript in the array ==(stack[top] = data)==

   ```java
   public void push(int value) {
       if (isFull()) {
           throw new RuntimeException("The Stack is full....");
       }
       stack[++top] = value;
   }
   ```

   

 - ##### Pop operation: When the stack is not empty, define a variable to store the value of the top element of the stack, and then set ==top--==

   ```java
   public int pop() {
       if (isEmpty()) {
           throw new RuntimeException("The Stack is empty...");
       }
       return stack[top--];
   }
   ```

   



