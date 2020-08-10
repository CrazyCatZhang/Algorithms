# Binary Search 

## 1. Basic Introduction

 - ##### Binary Search is a searching algorithm for finding an element's position in a sorted array

 - ##### In this approach, the element is always searched in the middle of a portion of an array

 - ##### Binary search can be implemented only on a sorted list of items. If the elements are not sorted already, we need to sort them first

## 2. [Idea Digram](https://www.programiz.com/dsa/binary-search)

 - ##### Binary Search Algorithm can be implemented in two ways which are discussed below

    - ###### Iterative Method

   	- ###### Recursive Method

   ###### The recursive method follows [the divide and conquer](https://www.programiz.com/dsa/divide-and-conquer) approach

- ##### The general steps for both methods are discussed below

  1. ###### The array in which searching is to be performed is:

     ![initial array Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxly485hj30i604wglg.jpg)

     ###### Let `x = 4` be the element to be searched

  2. ###### Set two pointers low and high at the lowest and the highest positions respectively

     ![setting pointers Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxm5whc6j30i607k0sn.jpg)

  3. ###### Find the middle element mid of the array ie. `(arr[low + high]) / 2 = 6`

     ![mid element Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxmdsplkj30i607k3ye.jpg)

  4. ###### If x == mid, then return mid.Else, compare the element to be searched with m

  5. ###### If `x > mid`, compare x with the middle element of the elements on the right side of mid. This is done by setting low to `low = mid + 1`

  6. ###### Else, compare x with the middle element of the elements on the left side of mid. This is done by setting high to `high = mid - 1`

     ![finding mid element Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxms3dyfj30i607kdfw.jpg)

  7. ###### Repeat steps 3 to 6 until low meets high

     ![mid element Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxn0cg94j309a07kmwz.jpg)

  8. ###### `x = 4` is found

     ![found Binary Search](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlxn8drqpj309a07k3yc.jpg)

## 3. Achieve

 - ##### When left > right, it means that the entire array is recursively completed, but not found

   ```java
   if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
       return new ArrayList<Integer>();
   }
   ```

   

 - ##### Define a variable to receive the index of the central axis

   ```java
   int mid = (left + right) / 2;
   ```

   

 - ##### Define a variable to receive the axis value

   ```java
   int midValue = arr[mid];
   ```

   

 - ##### If the value to be queried is greater than the central axis value, recurse to the right

   ```java
   if (findValue > midValue) {
       return binarySearch(arr, mid + 1, right, findValue);
   }
   ```

   

 - ##### If the value to be queried is less than the central axis value, recurse to the left

   ```java
    else if (findValue < midValue) {
       return binarySearch(arr, left, mid - 1, findValue);
   }
   ```

   

 - ##### When the middle axis value is equal to the value to be queried:

    - ###### Scan to the left of the central axis value, and add the subscripts of all elements that satisfy the value to be found to the collection ArrayList

      ```java
      int temp = mid - 1;
      while (true) {
          if (temp < 0 || arr[temp] != findValue) {
              break;
          }
          integerArrayList.add(temp);
          temp--;
      }
      integerArrayList.add(mid);
      ```

      

    - ###### Scan to the right of the central axis value, and add the subscripts of all elements satisfying the value to be found into the collection ArrayList

      ```java
      temp = mid + 1;
      while (true) {
          if (temp > arr.length - 1 || arr[temp] != findValue) {
              break;
          }
          integerArrayList.add(temp);
          temp++;
      }
      ```

      

    - ###### Return ArrayList collection

      ```java
      return integerArrayList;
      ```

      

