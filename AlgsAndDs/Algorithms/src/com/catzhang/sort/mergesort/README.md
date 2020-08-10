# Merge Sort

## 1. Basic Introduction

 - ##### Merge sorting is a sorting method that uses the idea of merging. The algorithm uses the classic divide-and-conquer (Divide-And-Conquer) strategy (the divide-and-conquer method divides the problem into small problems and then solves it recursively. In the stage of ), the answers obtained in the different stages are "fixed" together, that is, divide and conquer)

   ![merge sort example](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghluc8y3djj30u00uiabb.jpg)

## 2. [Idea Diagram](https://www.programiz.com/dsa/merge-sort)

 - #### Divide and Conquer Strategy

   ###### Using the [Divide and Conquer technique](https://www.programiz.com/dsa/divide-and-conquer), we divide a problem into subproblems. When the solution to each subproblem is ready, we 'combine' the results from the subproblems to solve the main problem

   ###### Suppose we had to sort an array A. A subproblem would be to sort a sub-section of this array starting at index p and ending at index r, denoted as A[p..r]

   - ##### Devide

     ###### If q is the half-way point between p and r, then we can split the subarray A[p..r] into two arrays A[p..q] and A[q+1, r]

   - ##### Conquer

     ###### In the conquer step, we try to sort both the subarrays A[p..q] and A[q+1, r]. If we haven't yet reached the base case, we again divide both these subarrays and try to sort them

   - ##### Combine

     ###### When the conquer step reaches the base step and we get two sorted subarrays A[p..q] and A[q+1, r] for array A[p..r], we combine the results by creating a sorted array A[p..r] from two sorted subarrays A[p..q] and A[q+1, r]

- #### The MergeSort Algorithem

  ###### The MergeSort function repeatedly divides the array into two halves until we reach a stage where we try to perform MergeSort on a subarray of size 1 i.e. p == r

  ###### After that, the merge function comes into play and combines the sorted arrays into larger arrays until the whole array is merged

  ###### To sort an entire array, we need to call `MergeSort(A, 0, length(A)-1)`

  ###### As shown in the image below, the merge sort algorithm recursively divides the array into halves until we reach the base case of array with 1 element. After that, the merge function picks up the sorted sub-arrays and merges them to gradually sort the entire array

  ![merge sort algorithm visualization](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv3dvwi1j30ym0le0tb.jpg)

  - ##### The merget Step of Merge Step

    ###### Every recursive algorithm is dependent on a base case and the ability to combine the results from base cases. Merge sort is no different. The most important part of the merge sort algorithm is, you guessed it, merge step

    ###### The merge step is the solution to the simple problem of merging two sorted lists(arrays) to build one large sorted list(array)

    ###### The algorithm maintains three pointers, one for each of the two arrays and one for maintaining the current index of the final sorted array

    ![merge two sorted arrays](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv3qga8hj30xw0u0dhh.jpg)

- #### Merge() Function Explained Step-By-Step

  ###### A lot is happening in this function, so let's take an example to see how this would work

  ###### As usual, a picture speaks a thousand words

  ![Merging two consecutive subarrays of array](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv3z8pccj30im068q2v.jpg)

  ###### The array A[0..5] contains two sorted subarrays A[0..3] and A[4..5]. Let us see how the merge function will merge the two arrays

  - ##### Step 1: Create duplicate copies of sub-arrays to be sorted

    ![Create copies of subarrays for merging](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv47p244j30ha0b40sq.jpg)

  - ##### Step 2: Maintain current index of sub-arrays and main array

    ![Maintain indices of copies of sub array and main array](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv4fk73dj30zw08s3ym.jpg)

  - ##### Step 3: Until we reach the end of either L or M, pick larger among elements L and M and place them in the correct position at A[p..r]

    ![Comparing individual elements of sorted subarrays until we reach end of one](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv4reze3j30xd0u0abe.jpg)

  - ##### Step 4: When we run out of elements in either L or M, pick up the remaining elements and put in A[p..r]

    ![Copy the remaining elements from the first array to main subarray](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv54euu5j30uo0k0gm9.jpg)

    ![Copy remaining elements of second array to main subarray](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlv5f96a3j30qa08sjrh.jpg)

  ###### This step would have been needed if the size of M was greater than L

  ###### At the end of the merge function, the subarray A[p..r] is sorted

## 3. Achieve

 - #### Merge Function

    - ##### Define an array to temporarily store data in the sorting process

      ```java
      int[] temp = new int[high - low + 1];
      ```

      

    - ##### Define a variable to receive the initial index of the ordered sequence on the left

      ```java
      int left = low;
      ```

      

    - ##### Define a variable to receive the initial index of the ordered sequence on the right

      ```java
      int right = mid + 1;
      ```

      

    - ##### Store the ordered sequence of data on the left and right sides in the temp array according to the rules, until one side is processed

       - ###### If the current element of the left ordered sequence is less than or equal to the current element of the right ordered sequence, the current element on the left is filled into the temp array, and then the index of the left ordered sequence and the index of the temp array are moved one bit backward

         ```java
         if (arr[left] <= arr[right]) {
             temp[index++] = arr[left++];
         }
         ```

         

       - ###### If the current element of the ordered sequence on the left is greater than the current element of the ordered sequence on the right, the current element on the right is filled into the temp array, and then the index of the ordered sequence on the right and the index of the temp array are moved one bit backward

         ```java
         else {
             temp[index++] = arr[right++];
         }
         ```

         

   - ##### Fill the remaining data of the left or right ordered sequence into the temp array in turn

     - ###### If the ordered sequence on the left has remaining data

       ```java
       while (left <= mid) {
           temp[index++] = arr[left++];
       }
       ```

       

     - ###### If the ordered sequence on the right has remaining data

       ```java
       while (right <= high) {
           temp[index++] = arr[right++];
       }
       ```

   - ##### Fill the data of the temp array to the original array

     ```java
     for (int i = 0; i < temp.length; i++) {
         arr[i + low] = temp[i];
     }
     ```

     

- #### MergeSort Function

  - ##### Recursive decomposition to the left

    ```java
    mergeSort(arr, low, mid);
    ```

    

  - ##### Recursive decomposition to the right

    ```java
    mergeSort(arr, mid + 1, high);
    ```

    

  - ##### Merge

    ```java
    merge(arr, low, high, mid);
    ```

    























































