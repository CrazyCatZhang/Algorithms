# Quick Sort

## 1. Basic Introduction

 - ##### Quick sort is an improvement to bubble sort. The basic idea is: divide the data to be sorted into two independent parts by sorting, and all the data in one part is smaller than all the data in the other part, and then quickly sort the two parts of the data according to this method. The entire sorting process can be carried out recursively, so that the entire data becomes an ordered sequence

## 2. [Idea Digram](https://www.programiz.com/dsa/quick-sort)

 - ##### A pivot element is chosen from the array. You can choose any element from the array as the pivot element.

   ##### Here, we have taken the rightmost (ie. the last element) of the array as the pivot element.

   ![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrz7jy1mj30sc05gwel.jpg)

- ##### The elements smaller than the pivot element are put on the left and the elements greater than the pivot element are put on the right.

  ![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrzkgx2ij30sc05gwel.jpg)

  ##### The above arrangement is achieved by the following steps.

  - ###### A pointer is fixed at the pivot element. The pivot element is compared with the elements beginning from the first index. If the element greater than the pivot element is reached, a second pointer is set for that element.

  - ###### Now, the pivot element is compared with the other elements (a third pointer). If an element smaller than the pivot element is reached, the smaller element is swapped with the greater element found earlier.

    ![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrzvrwd2j30u00y9gns.jpg)

  - ###### The process goes on until the second last element is reached.

    ###### Finally, the pivot element is swapped with the second pointer.

    ![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghls04dkmcj30sc0uigne.jpg)

  - ###### Now the left and right subparts of this pivot element are taken for further processing in the steps below.

- ##### Pivot elements are again chosen for the left and the right sub-parts separately. Within these sub-parts, the pivot elements are placed at their right position. Then, step 2 is repeated.

  ![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghls0clwlaj30ra0lw408.jpg)

- ##### The sub-parts are again divided into smaller sub-parts until each subpart is formed of a single element.

- ##### At this point, the array is already sorted.

#### **Quicksort uses recursion for sorting the sub-parts.**

#### On the basis of [Divide and conquer approach](https://www.programiz.com/dsa/divide-and-conquer), quicksort algorithm can be explained as:

 - ##### Divide

   ###### The array is divided into subparts taking pivot as the partitioning point. The elements smaller than the pivot are placed to the left of the pivot and the elements greater than the pivot are placed to the right.

- ##### Conquer

  ###### The left and the right subparts are again partitioned using the by selecting pivot elements for them. This can be achieved by recursively passing the subparts into the algorithm.

- ##### Combine

  ###### This step does not play a significant role in quicksort. The array is already sorted at the end of the conquer step.

##### You can understand the working of quicksort with the help of the illustrations below.

![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghls0sfy4bj31m00q2di9.jpg)

![Quick Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghls1580aaj31gk0u041n.jpg)

## 3. Achieve

 - ##### Define variable to accept left subscript

   ```java
   int left = low;
   ```

   

 - ##### Define variable to accept right subscript

   ```java
   int right = high;
   ```

   

 - ##### Define the variable to accept the axis value

   ```java
   int pivot = arr[(high + low) / 2];
   ```

   

 - ##### Define temporary variables to store the value during exchange

   ```java
   int temp = 0;
   ```

   

 - ##### Through the while loop, the values smaller than the central axis are all on the left, and the values greater than the central axis are all on the right.

    - ###### Scan the left side of the middle axis value, and then exit until you find a value greater than or equal to the middle axis value

      ```java
      while ((left < right) && arr[left] < pivot) {
          left++;
      }
      ```

      

    - ###### Scan the right side of the central axis value, and then exit until a certain value is found to be less than or equal to the central axis value

      ```java
      while ((left < right) && arr[right] > pivot) {
          right--;
      }
      ```

      

    - ###### If the left subscript is less than the right subscript and the value corresponding to the left subscript is equal to the value corresponding to the right subscript, move the left subscript to the right

      ```java
      if (arr[left] == arr[right] && left < right) {
          left++;
      }
      ```

      

    - ###### Otherwise, swap the value of the left subscript with the value of the right subscript

      ```java
      else {
          int temp = arr[left];
          arr[left] = arr[right];
          arr[right] = temp;
      }
      ```

      

- ##### When the entire while loop is over, if the left subscript minus 1 is greater than the starting subscript of the array, then left recursive sorting

  ```java
  if (left - 1 > low) {
      quickSort(arr, low, left - 1);
  }
  ```

  

- ##### When the entire while loop ends, if the right subscript plus 1 is less than the end subscript of the array, the right recursive sorting is performed

  ```java
  if (right + 1 < high) {
      quickSort(arr, right + 1, high);
  }
  ```

  





























 