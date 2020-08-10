# Insert Sort

## 1. Basic Introduction

 - ##### Insertion sorting belongs to the internal sorting method, which is to find the appropriate position of the element to be sorted by inserting it to achieve the purpose of sorting

 - ##### The basic idea of Insertion Sorting is to treat n elements to be sorted as an ordered list and an unordered list. At the beginning, the ordered list contains only one element, and the unordered list contains n-1 Elements, each time the first element is taken from the unordered list during the sorting process, its sort code is compared with the sort code of the ordered list elements in turn, and it is inserted into the appropriate position in the ordered list to make Become a new ordered list

## 2. [Idea Diagram](https://www.programiz.com/dsa/insertion-sort)

 - ##### Suppose we need to sort the following array.

   ![Insertion Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrcdpqtbj30ky05gq30.jpg)

 - ##### The first element in the array is assumed to be sorted. Take the second element and store it separately in `key`.

   ##### Compare `key` with the first element. If the first element is greater than `key`, then key is placed in front of the first element.

   ![Insertion Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrcn27oej30p20mg3zi.jpg)

- ##### Now, the first two elements are sorted.

  ##### Take the third element and compare it with the elements on the left of it. Placed it just behind the element smaller than it. If there is no element smaller than it, then place it at the beginning of the array.

  ![Insertion Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrcvg9xnj30p20rmta2.jpg)

- ##### Similarly, place every unsorted element at its correct position.

  ![Insertion Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrda1ffdj30p20rsq4a.jpg)

  ![Insertion Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlrdiu35ij30p20x80uh.jpg)

## 3. Achieve

 - ##### Define a temporary variable `insertVal` to save the value to be inserted in this round of sorting, which is equal to the value corresponding to the starting subscript of this round of sorting

   ```java
   int insertVal = arr[i];
   ```

   

 - ##### Define a temporary variable `insertIndex` to store the subscript of the ordered list of values to be inserted

   ```java
   int insertIndex = i - 1;
   ```

   

 - ##### If the subscript of the ordered list is greater than 0, and the value to be inserted is less than the value corresponding to the subscript of the ordered list, then the value corresponding to the subscript of the ordered list is moved backward, and then the subscript of the ordered list is moved forward , Until the value to be inserted is greater than or equal to the value corresponding to the subscript of the ordered list

   ```java
   while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
       arr[insertIndex + 1] = arr[insertIndex];
       insertIndex--;
   }
   ```

   

 - ##### Finally, if the subscript of the ordered list plus 1 is not equal to the subscript of the value to be inserted at the beginning, put the value to be inserted in the position of the ordered list plus 1

   ```java
   if (insertIndex + 1 != i) {
       arr[insertIndex + 1] = insertVal;
   }
   ```

   

