# Calculator

## 1. Problem Description

 - ##### Use the stack to implement a simple comprehensive calculator

## 2. Achieve

 - ##### Create two stacks, a number stack to store data, and a symbol stack to store operators

   ```java
   ArraysStack numStack = new ArraysStack(10);
   ArraysStack operatorStack = new ArraysStack(10);
   ```

   

 - ##### Define a variable as an index traversal expression

   ```java
   int index = 0;
   ```

   

 - ##### Determine whether it is an operator

   ```java
   public boolean isOperator(char ch) {
       if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
           return true;
       }
       return false;
   }
   ```

   

 - ##### Determine the priority of operators

   ```java
   public int priority(char ch) {
       if (ch == '*' || ch == '/') {
           return 1;
       } else if (ch == '+' || ch == '-') {
           return 0;
       }
       return -1;
   }
   ```

   

 - ##### Methods of encapsulating operator operations

   ```java
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
   ```

   

 - ##### If during the traversal process, the index points to a number, the number is directly put into the number stack

    - ###### Define a string variable for multi-digit splicing

      ```java
      String temp = "";
      
      
      temp += ch;
      ```

      

    - ###### If the index pointer points to the last element, put this element directly on the stack

      ```java
      if (index == str.length() - 1) {
          numStack.push(Integer.parseInt(temp));
      }
      ```

      

    - ###### Determine whether the next element of the current element pointed to by index is a number, if it is, then continue scanning, if not, put the string variable on the stack, and make the variable empty

      ```java
      else {
          if (operatorStack.isOperator(str.substring(index + 1, index + 2).charAt(0))) {
              numStack.push(Integer.parseInt(temp));
              temp = "";
          }
      }
      ```

      

 - ##### If the index points to an operator, the operations are divided into the following cases:

    - ###### If the priority of the current operator is less than or equal to the priority of the operator in the symbol stack, you need to take two numbers from the number stack, use the operator of the top element of the symbol stack to perform the operation, and store the result into the number stack, and then Put the current operator into the symbol stack

      ```java
      if (!operatorStack.isEmpty()) {
          if (operatorStack.priority(ch) <= operatorStack.priority((char) operatorStack.peek())) {
              num1 = numStack.pop();
              num2 = numStack.pop();
              numStack.push(numStack.operator(num1, num2, (char) operatorStack.peek()));
              operatorStack.pop();
          }
      }
      operatorStack.push(ch);
      ```

      

    - ###### If the priority of the current operator is greater than the priority of the operator in the symbol stack, the current operator is directly put into the symbol stack

      ```java
      operatorStack.push(ch);
      ```

      

- ##### When the expression is scanned, the corresponding numbers and operators in the number stack and symbol stack are taken out, operated, and the result is put into the number stack

  ```java
  while (true) {
      if (operatorStack.isEmpty()) {
          break;
      }
      num1 = numStack.pop();
      num2 = numStack.pop();
      numStack.push(numStack.operator(num1, num2, (char) operatorStack.peek()));
      operatorStack.pop();
  }
  ```

  

- ##### The data in the final stack is the result we require

  ```java
  return numStack.pop();
  ```

  

