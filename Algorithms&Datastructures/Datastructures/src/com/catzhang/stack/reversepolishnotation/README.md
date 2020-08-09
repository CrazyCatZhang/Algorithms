# ReversePolishNotation

## 1. Problem Description

 - ##### Enter a reverse Polish expression (postfix expression) and use the stack to calculate the result

 - ##### Convert infix expression to postfix expression

## 2. Solutions

 - ##### For example: ==(3+4)×5-6== corresponds to the suffix expression ==3 4 + 5 × 6 -==, the evaluation steps for the suffix expression are as follows:

    - ###### Scan from left to right, push 3 and 4 onto the stack

    - ###### Encountered the ==+== operator, so pop 4 and 3 (4 is the top element on the stack, 3 is the next top element), calculate the value of ==3+4==, get 7, and then push 7 onto the stack

    - ###### Push 5 onto the stack

    - ###### Next is the ==x== operator, so pop 5 and 7, calculate ==7x5=35==, and put 35 on the stack

    - ###### Push 6 into the stack

   	- ###### The last is the ==-== operator, which calculates the value of ==35-6==, which is 29, which gives the final result

## 3. Achieve

 - ##### Store the data and operators of the infix expression in the ArrayList in turn

    - ###### Define ArrayList collection, used to store infix expression elements

      ```java
      ArrayList<String> infixExpressionList = new ArrayList<>();
      ```

      

    - ###### Define auxiliary variables, traverse the infix expression

      ```java
      int index = 0;
      ```

      

    - ###### Define auxiliary string variables for splicing multiple digits

      ```java
      String str = "";
      ```

      

    - ###### In the process of traversal, if the index points to a non-number, it is directly added to the collection

      ```java
      if ((ch = infixExpression.charAt(index)) < 48 || (ch = infixExpression.charAt(index)) > 57) {
          infixExpressionList.add("" + ch);
          index++;
      } 
      ```

      

    - ###### If the index points to a number, multi-digit splicing is performed until index points to a non-number or points to the last element

      ```java
      else {
          str = "";
          while (index < infixExpression.length() && (ch = infixExpression.charAt(index)) >= 48 && (ch = infixExpression.charAt(index)) <= 57) {
              str += ch;
              index++;
          }
          infixExpressionList.add(str);
      }
      ```

- ##### Convert the infix expression to a postfix expression and store the postfix expression in the ArrayList collection

  - ###### Define an ArrayList collection to store suffix expression elements

    ```java
    List<String> postfixExpressionList = new ArrayList<>();
    ```

    

  - ###### Define an operator stack

    ```java
    Stack<String> stack = new Stack<>();
    ```

    

  - ###### Traverse the set of infix expressions

    ```java
    for (String item :
            infixExpression)
    ```

    

  - ###### If the scanned element is a number, it is directly added to the ArrayList collection

    ```java
    if (item.matches("\\d+")) {
        postfixExpressionList.add(item);
    }
    ```

    

  - ###### If the scanned element is an operator, compare its priority with the top element of the symbol stack:

    - If the symbol stack is empty, or the top element of the stack is a left parenthesis "(", this operator is pushed onto the stack

      ```java
      else if (stack.isEmpty() || item.equals("(")) {
          stack.push(item);
      }
      ```

      

    - If the priority of the operator is higher than the priority of the top element in the symbol stack, the operator is directly pushed onto the stack

      ```java
      stack.push(item);
      ```

      

    - If the priority of the operator is less than or equal to the priority of the top element in the symbol stack, pop the top element in the symbol stack and put it into the ArrayList collection, and then the operator and the new top of the symbol stack Element comparison

      ```java
      else {
          while (stack.size() != 0 && Operation.getValue(item) <= Operation.getValue(stack.peek())) {
              postfixExpressionList.add(stack.pop());
          }
          stack.push(item);
      }
      ```

      

  - ###### If the scanned element is parentheses:

    - If it is a left bracket "(", put it directly into the symbol stack

    - If it is the right parenthesis ")", pop the top operators in the symbol stack and add them to the ArrayList collection until the left parenthesis "(" is encountered, and then discard this pair of parentheses

      ```java
      else if (item.equals(")")) {
          while (stack.size() != 0 && !stack.peek().equals("(")) {
              postfixExpressionList.add(stack.pop());
          }
          stack.pop();
      }
      ```

      

  - ###### After traversing, pop the remaining elements in the symbol stack and add them to the ArrayList

    ```java
    while (stack.size() != 0) {
        postfixExpressionList.add(stack.pop());
    }
    ```

    

 - ##### Create stack

   ```java
   Stack<String> stack = new Stack<>();
   ```

   

 - ##### Traverse the ArrayList collection

    - ###### If the match is a multi-digit number, it will be directly pushed onto the stack

      ```java
      if (item.matches("\\d+")){
          stack.push(item);
      }
      ```

      

    - ###### If the match is an operator, take out the top element and the next top element of the stack, and use the operator to perform the operation, and then put the result into the stack

      ```java
      else {
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
      ```

      

- ##### The last thing left in the stack is the final result

  ```java
  return Integer.parseInt(stack.pop());
  ```

  

