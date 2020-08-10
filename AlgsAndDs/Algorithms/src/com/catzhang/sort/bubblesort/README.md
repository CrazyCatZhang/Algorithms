# Bubble Sort

## 1. Basic Introduction

 - ##### The basic idea of Bubble Sorting is: by treating the sorting sequence from front to back (starting from the element with the smaller subscript), comparing the values of adjacent elements in turn, and swapping if the reverse order is found to make the element with the larger value Gradually move from the front to the back, and gradually rise upwards like bubbles under the water

## 2. Optimization

 - ##### Because each element keeps approaching its position during the sorting process, if there is no exchange in a comparison, the sequence is in order. Therefore, a flag flag must be set during the sorting process to determine whether the element has been exchanged. Thereby reducing unnecessary comparisons

## 3. Idea Diagram

![img](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghljozsmd6g30my075wqv.gif)

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

   

