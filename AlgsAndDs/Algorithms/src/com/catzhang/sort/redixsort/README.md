# Radix Sort

## 1. Basic Introduction

 - ##### Radix sort is a sorting technique that sorts the elements by first grouping the individual digits of the same **place value**. Then, sort the elements according to their increasing/decreasing order

 - ##### Suppose, we have an array of 8 elements. First, we will sort elements based on the value of the unit place. Then, we will sort elements based on the value of the tenth place. This process goes on until the last significant place

 - ##### Let the initial array be `[121, 432, 564, 23, 1, 45, 788]`. It is sorted according to radix sort as shown in the figure below

![Radix Sort Working](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlvwj2zb8j30jk0ikaao.jpg)

## 2. [Idea Digram](https://www.programiz.com/dsa/radix-sort)

 - ##### Find the largest element in the array, i.e. max. Let `X` be the number of digits in `max`. `X` is calculated because we have to go through all the significant places of all elements

   ###### In this array `[121, 432, 564, 23, 1, 45, 788]`, we have the largest number 788. It has 3 digits. Therefore, the loop should go up to hundreds place (3 times)

- ##### Now, go through each significant place one by one

  ###### Use any stable sorting technique to sort the digits at each significant place. We have used counting sort for this

  ###### Sort the elements based on the unit place digits (`X=0`)

  ![Radix Sort working with Counting Sort as intermediate step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlwkx4pwyj313o0o4q4p.jpg)

- ##### Now, sort the elements based on digits at tens place

  ![Radix Sort Step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlwl5eiulj30s805gglt.jpg)

- ##### Finally, sort the elements based on the digits at hundreds place

  ![Selection Sort Step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlwldwpe5j30s805gjrl.jpg)

## 3. Achieve

 - ##### Define a variable to store the largest element in the array, get the largest element by traversing the array, and get its length

   ```java
   int max = arr[0];
   for (int i = 0; i < arr.length; i++) {
       max = max > arr[i] ? max : arr[i];
   }
   int maxLength = (max + "").length();
   ```

   

 - ##### Define a two-dimensional array to represent ten buckets, each bucket is a one-dimensional array

   ```java
   int[][] bucket = new int[10][arr.length];
   ```

   

 - ##### Define a one-dimensional array to record the number of data put in each bucket each time

   ```java
   int[] bucketElementCounts = new int[10];
   ```

   

 - ##### Sort the corresponding bits of each element, the first time is the ones place, the second time is the tens place, the third time is the hundreds place... Take the value of the corresponding bit of each element and put it into the bucket

   ```java
   for (int j = 0; j < arr.length; j++) {
       int digitOfElement = arr[j] / n % 10;
       bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
       bucketElementCounts[digitOfElement]++;
   }
   ```

   

 - ##### Traverse each bucket and put the data in the bucket into the original array

   ```java
   int index = 0;
   for (int j = 0; j < bucket.length; j++) {
       if (bucketElementCounts[j] != 0) {
           for (int k = 0; k < bucketElementCounts[j]; k++) {
               arr[index++] = bucket[j][k];
           }
       }
       bucketElementCounts[j] = 0;
   }
   ```

   