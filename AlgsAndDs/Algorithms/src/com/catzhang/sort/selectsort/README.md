# Select Sort

## 1. Basic Introduction

 - ##### Selective sorting is also an internal sorting method, which is to select an element from the data to be sorted according to the specified rules, and then exchange positions according to the regulations to achieve the purpose of sorting

 - ##### Select sorting is also a simple sorting method. Its basic idea is: first select the minimum value from `arr[0]~arr[n-1]`, exchange with `arr[0]`, and select from `arr[1]~arr[n-1]` for the second time Minimum value, exchange with `arr[1]`, select the minimum value from `arr[2]~arr[n-1]` for the third time, exchange with `arr[2]`,..., for the i-th time from `arr[i-1] ]~arr[n-1]` select the minimum value, exchange with `arr[i-1]`,..., select the minimum value from `arr[n-2]~arr[n-1]` for the n-1th time, Exchange with `arr[n-2]`, pass n-1 times in total, and get an ordered sequence arranged from small to large according to the sorting code

## 2. [Idea Diagram](https://www.programiz.com/dsa/selection-sort)

 - ##### Set the first element as `minimum`.

   ![Selection Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr4g2p4fj30ky05gq31.jpg)

 - ##### Compare `minimum` with the second element. If the second element is smaller than `minimum`, assign the second element as `minimum`.

   ##### Compare `minimum` with the third element. Again, if the third element is smaller, then assign `minimum` to the third element otherwise do nothing. The process goes on until the last element.

   ![Selection Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr4p12f7j30ky0ig0tm.jpg)

- ##### After each iteration, `minimum` is placed in the front of the unsorted list

  ![Selection Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr51i7ssj30ky07sgls.jpg)

- ##### For each iteration, indexing starts from the first unsorted element. Step 1 to 3 are repeated until all the elements are placed at their correct positions.

  ![Selection Sort Steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr8guufyj30u00yk76q.jpg)

  ![Selection sort steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr5koe6bj30u00ssdhr.jpg)

  ![Selection sort steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr69j7c4j30u00ngjsr.jpg)

  ![Selection sort steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlr6gjfbmj30u00hs3zc.jpg)

## 3. Achieve

 - ##### Define a variable to store the minimum index in the array sorting process, and initialize it to the starting index of the current array (note that the starting index of the array is different in each round of sorting)

 - ##### Compare the array value pointed to by the variable subscript with all the values behind the array. If a subscript smaller than its value is found, then this subscript is assigned to the variable subscript

 - ##### When a round of sorting is completed, if the variable subscript is not equal to the starting subscript of the current array, the value of the starting subscript is exchanged with the value corresponding to the variable subscript

```java
for (int i = 0; i < arr.length - 1; i++) {
    int minOrMaxIndex = i;
    int temp = 0;
    for (int j = i + 1; j < arr.length; j++) {
        minOrMaxIndex = arr[minOrMaxIndex] > arr[j] ? j : minOrMaxIndex;
    }
    if (minOrMaxIndex != i){
        temp = arr[i];
        arr[i] = arr[minOrMaxIndex];
        arr[minOrMaxIndex] = temp;
    }
}
```

