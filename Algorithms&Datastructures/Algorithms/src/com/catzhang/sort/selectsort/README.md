# Select Sort

## 1. Basic Introduction

 - ##### Selective sorting is also an internal sorting method, which is to select an element from the data to be sorted according to the specified rules, and then exchange positions according to the regulations to achieve the purpose of sorting

 - ##### Select sorting is also a simple sorting method. Its basic idea is: first select the minimum value from `arr[0]~arr[n-1]`, exchange with `arr[0]`, and select from `arr[1]~arr[n-1]` for the second time Minimum value, exchange with `arr[1]`, select the minimum value from `arr[2]~arr[n-1]` for the third time, exchange with `arr[2]`,..., for the i-th time from `arr[i-1] ]~arr[n-1]` select the minimum value, exchange with `arr[i-1]`,..., select the minimum value from `arr[n-2]~arr[n-1]` for the n-1th time, Exchange with `arr[n-2]`, pass n-1 times in total, and get an ordered sequence arranged from small to large according to the sorting code

## 2. Idea Diagram

![img](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghljn3jlc7g30mj06w7l2.gif)

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

