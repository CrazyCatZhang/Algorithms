# SparseArrays

## 1. Basic Introduction

 - ### When most of the elements in an array are 0 or an array of the same value, a sparse array can be used to save the array

 - ### Approach：

    - #### The record array has a total of several rows and columns, and how many different values are there

    - #### Record the ranks and values of elements with different values in a small array to reduce the size of the program

## 2. Applications

 - ### Use sparse arrays to store two-dimensional arrays like chessboards, maps, etc.

## 3. Achieve

 - ### Traverse the original two-dimensional array to get the number of valid data -> sum

```java
int sum = 0;
for (int[] data :
        chessArray1) {
    for (int values :
            data) {
        System.out.print(values + "\t");
        if (values != 0) {
            sum++;
        }
    }
    System.out.println();
}
```



 - ### Create sparse array based on sum

```java
int[][] sparseArrays = new int[sum + 1][3];
```



 - ### Put valid data of two-dimensional array into sparse array

```java
sparseArrays[0][0] = chessArray1.length;
sparseArrays[0][1] = chessArray1[0].length;
sparseArrays[0][2] = sum;
int count = 0;
for (int i = 0; i < chessArray1.length; i++) {
    for (int j = 0; j < chessArray1[0].length; j++) {
        if (chessArray1[i][j] != 0) {
            count++;
            sparseArrays[count][0] = i;
            sparseArrays[count][1] = j;
            sparseArrays[count][2] = chessArray1[i][j];
        }
    }
}
```



