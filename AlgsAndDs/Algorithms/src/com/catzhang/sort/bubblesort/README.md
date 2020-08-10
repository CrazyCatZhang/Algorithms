# Bubble Sort

## 1. Basic Introduction

 - ##### The basic idea of Bubble Sorting is: by treating the sorting sequence from front to back (starting from the element with the smaller subscript), comparing the values of adjacent elements in turn, and swapping if the reverse order is found to make the element with the larger value Gradually move from the front to the back, and gradually rise upwards like bubbles under the water

## 2. Optimization

 - ##### Because each element keeps approaching its position during the sorting process, if there is no exchange in a comparison, the sequence is in order. Therefore, a flag flag must be set during the sorting process to determine whether the element has been exchanged. Thereby reducing unnecessary comparisons

## 3. [Idea Diagram](https://www.programiz.com/dsa/bubble-sort)

 - ##### Starting from the first index, compare the first and the second elements.If the first element is greater than the second element, they are swapped.

   ##### Now, compare the second and the third elements. Swap them if they are not in order.

   ##### The above process goes on until the last element.

   ![Bubble Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr0hbe7rj30bz0g2t9b.jpg)

- ##### The same process goes on for the remaining iterations. After each iteration, the largest element among the unsorted elements is placed at the end.

  ##### In each iteration, the comparison takes place up to the last unsorted element.

  ##### The array is sorted when all the unsorted elements are placed at their correct positions.

  ![Bubble Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr0u9ou0j30bz0d8gm1.jpg)

  ![Bubble Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr16xg1fj30bz0aeaab.jpg)

  ![Bubble Sort steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr1ei39ej30bz07kdfx.jpg)

## 4. Achieve

 - ##### Define temporary variables to store exchanged values

   ```java
   int temp = 0;
   ```

   

 - ##### Definition means variable, used to indicate whether exchange

   ```java
   boolean flag = false;
   ```

   

 - ##### In the traversal process, the elements are compared in pairs. If the current element is greater than the next element, the two elements are exchanged, and so on. Each round of sorting can find the maximum value of the current array. In the sorting process If the position has been exchanged, the identification variable is set to true; if the identification variable is false, the identification sorting is successful

   ```java
   for (int i = 0; i < arr.length - 1; i++) {
       for (int j = 0; j < arr.length - i - 1; j++) {
           if (arr[j] > arr[j + 1]) {
               flag = true;
               temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
           }
       }
       if (!flag) {
           break;
       } else {
           flag = false;
       }
   }
   ```

   

