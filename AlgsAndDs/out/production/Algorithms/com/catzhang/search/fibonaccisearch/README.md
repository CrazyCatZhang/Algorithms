# Fibonacci Search

## 1. Basic Introduction

 - ##### The golden section point is to divide a line segment into two parts so that the ratio of one part to the total length is equal to the ratio of the other part to this part. The approximate value of the first three digits is 0.618. Because the shape designed according to this ratio is very beautiful, it is called the golden ratio, also known as the ratio of China to foreign countries. This is a magical number, which will have little intentional effect

 - ##### The Fibonacci sequence {1,1,2,3,5,8,13,21,34,55} found that the ratio of two adjacent numbers in the Fibonacci sequence is infinitely close to the golden section value 0.618

 - ##### The Fibonacci search principle is similar to the first two, only changing the position of the middle node (mid), mid is no longer in the middle or interpolated, but is located near the golden section point, that is, `mid=low+F(k- 1)-1` (F stands for Fibonacci sequence)

## 2. Achieve

 - ##### Create a method to obtain the Fibonacci sequence

   ```java
   public static int[] fibonacci() {
       int[] F = new int[maxSize];
       F[0] = 1;
       F[1] = 1;
       for (int i = 2; i < maxSize; i++) {
           F[i] = F[i - 1] + F[i - 2];
       }
       return F;
   }
   ```

   

 - ##### Get the subscript of the Fibonacci division value

   ```java
   while (arr.length > F[key] - 1) {
       key++;
   }
   ```

   

 - ##### Because the value of f[k] may be greater than the length of a, we need to use the Arrays class to construct a new array and point to the temp array

   ```java
   int[] temp = Arrays.copyOf(arr, F[key] - 1);
   for (int i = high + 1; i < temp.length; i++) {
       temp[i] = arr[high];
   }
   ```

   

 - ##### Use the while loop to find the value key you want to find

    - ###### The central axis subscript is equal to `mid=low+F(k- 1)-1`

    - ###### If the value you are looking for is less than the central axis value, search to the left

      ```java
      if (value < temp[mid]) {
          high = mid - 1;
          key--;
      }
      ```

      

    - ###### If the value you are looking for is greater than the central axis value, search to the right

      ```java
      else if (value > temp[mid]) {
          left = mid + 1;
          key -= 2;
      }
      ```

      

    - ###### If the value you are looking for is equal to the axis value, it means you have found it. Need to determine the returned subscript

      ```java
      else {
          if (mid <= high) {
              return mid;
          } else {
              return high;
          }
      }
      ```

      

