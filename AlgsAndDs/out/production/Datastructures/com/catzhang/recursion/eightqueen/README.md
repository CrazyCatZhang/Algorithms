# Eight Queen

## 1. Problem Description

 - ##### The eight queens problem is an old and well-known problem and a typical case of backtracking algorithms. The problem was raised by the chess player Max Bethel in 1848: place eight queens on an 8×8 chess board so that they cannot attack each other, that is: no two queens can be in the same row , In the same column or on the same diagonal line, ask how many pendulums there are (92)

 - ##### Visualize 8 queens with a two-dimensional array

## 2. Solutions

 - ##### Put the first queen first in the first row and first column

 - ##### Put the second queen in the first column of the second row, and then judge whether it can be put in. If not, put all the columns in order and find a suitable position

 - ##### Continue to the third queen, the first column, the second column... Until the eighth queen can be placed in a non-conflicting position, it is considered to have found a correct solution

 - ##### When a correct solution is obtained, when the stack rolls back to the previous stack, it will start to backtrack, that is, the first queen, all correct solutions placed in the first column are all obtained

 - ##### Then go back and continue with the first queen in the second column, and then continue to cycle through all the above steps

## 3. Achieve

 - ##### Define the number of rows and columns, and initialize a two-dimensional array to simulate a chessboard

   ```java
   private int rowMax = 8;
   private int columnMax = 8;
   private int[][] arrayQueen = new int[rowMax][columnMax];
   ```

   

 - ##### Define a counter to record all possible solutions of the eight queens

   ```java
   private int count = 0;
   ```

   

 - ##### Determine whether the queen is in the correct position

    - ###### Look up from the current position, if there is a queen in the same column, return false

      ```java
      for (int i = x - 1; i >= 0; i--) {
          if (arrayQueen[i][y] == 1) {
              return false;
          }
      }
      ```

      

    - ###### Find from the current position to the upper left, if there is a queen in the upper left, return false

      ```java
      for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
          if (arrayQueen[i][j] == 1) {
              return false;
          }
      }
      ```

      

    - ###### Find from the current position to the upper right, if there is a queen at the upper right, return false

      ```java
      for (int i = x - 1, j = y + 1; i >= 0 && j < this.columnMax; i--, j++) {
          if (arrayQueen[i][j] == 1) {
              return false;
          }
      }
      ```

      

    - ###### When the above conditions are not met, return true

      ```java
      return true;
      ```

      

- ##### Let the queen go from the lever row

  - ###### When the `level` is equal to the maximum number of rows, it means that the eight queens have been placed in the correct position, the counter is increased by one, and then backtracking to the previous level

    ```java
    if (level == rowMax || level == columnMax){
        count++;
        System.out.println("This is the " + count + " solution");
        print();
        return;
    }
    ```

    

  - ###### Otherwise, traverse each column of the current row and find the correct position through the verification method. If the correct position is found, first clear each column of the current row, and then assign the value at the position to 1, and then Continue to find the correct position on the next line

    ```java
    else {
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
    ```

    