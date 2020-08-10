# Shell Sort

## 1. Basic Introduction

 - ##### Hill sorting is a sorting algorithm proposed by Donald Shell in 1959. Hill sort is also a kind of insertion sort, it is a more efficient version of simple insertion sort after improvement, also known as reduced incremental sort

 - ##### Hill sorting is to group records by a certain increment of the target, and use the direct insertion sorting algorithm to sort each group; as the increment decreases, each group contains more and more keywords. When the increment decreases to 1, The entire file is divided into one group, and the algorithm terminates

## 2. [Idea Digram](https://www.programiz.com/dsa/shell-sort)

 - ##### Suppose, we need to sort the following array

   ![Shell sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqgi9rhdj30vs05gglq.jpg)

 - ##### We are using the shell's original sequence `(N/2, N/4, ...1`) as intervals in our algorithm

    ##### In the first loop, if the array size is `N = 8` then, the elements lying at the interval of `N/2 = 4` are compared and swapped if they are not in order.

    - ###### The 0th element is compared with the 4th element.

    - ###### If the 0th element is greater than the 4th one then, the 4th element is first stored in `temp` variable and the `0th` element (ie. greater element) is stored in the `4th` position and the element stored in `temp` is stored in the `0th` position.

      ![Shell Sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqgwjg47j30zw0gejsf.jpg)

    - ###### This process goes on for all the remaining elements.

      ![Shell Sort steps](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqh4z73sj30vs0hs75k.jpg)

- ##### In the second loop, an interval of `N/4 = 8/4 = 2` is taken and again the elements lying at these intervals are sorted.

  ![Shell Sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqhlaqqpj30vs09kgm4.jpg)

  ##### You might get confused at this point.

  ![Shell Sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqhxxe5tj30vs09kjrw.jpg)

  ##### The elements at 4th and `2nd` position are compared. The elements at 2nd and `0th` position are also compared. All the elements in the array lying at the current interval are compared.

- ##### The same process goes on for remaining elements.

  ![Shell Sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqigoqffj30vs0hswfs.jpg)

- ##### Finally, when the interval is `N/8 = 8/8 =1` then the array elements lying at the interval of 1 are sorted. The array is now completely sorted.

  ![Shell Sort step](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghlqisfhpmj30u01070vy.jpg)

## 3. Achieve

 - ##### Define the incremental gap and gradually reduce the increment

 - ##### From the gap element, directly insert and sort its group one by one

```java
for (int gap = arr.length / 2; gap > 0; gap /= 2) {
    for (int i = gap; i < arr.length; i++) {
        int j = i;
        int temp = arr[j];
        if (arr[j] < arr[j - gap]){
            while (j - gap >= 0 && temp < arr[j - gap]){
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}
```

