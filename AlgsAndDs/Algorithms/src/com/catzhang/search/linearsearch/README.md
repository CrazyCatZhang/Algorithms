# Linear Search

## 1. Basic Introduction

 - ##### Linear search is the simplest searching algorithm that searches for an element in a list in sequential order. We start at one end and check every element until the desired element is not found.

## 2. [Idea Digram](https://www.programiz.com/dsa/linear-search)

 - ##### The following steps are followed to search for an element `k = 1` in the list below

   ![Initial array](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlx7aye09j30ky05gjrg.jpg)

   - ###### Start from the first element, compare k with each element x

     ![Element not found](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlx7ibjnjj30ky0oq3zf.jpg)

   - ###### If `x == k`, return the index

     ![Element found](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlx7r25opj30ky08ewel.jpg)

   - ###### Else, return not found

## 3. Achieve

 - ##### Traverse the entire array, compare one by one, and return the subscript if the same value is found

   ```java
   for (int i = 0; i < arr.length; i++) {
       if (arr[i] == value) {
           return i;
       }
   }
   return -1;
   ```

   

