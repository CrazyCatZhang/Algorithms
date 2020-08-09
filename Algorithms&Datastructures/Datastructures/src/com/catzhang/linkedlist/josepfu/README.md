# Josepfu

## 1. Problem Description

 - ##### Suppose n people numbered 1, 2,... n sit in a circle, and the person numbered k (1<=k<=n) shall start counting from 1, and the person who counts to m will go out. The next digit starts to count from 1, and the person who counts to m goes out again, and so on, until everyone goes out, thus generating a sequence of dequeue numbers

## 2. Solutions

 - ##### Use a circular linked list without a leading node to deal with Josephu's problem: first form a single circular linked list with n nodes, and then count from 1 from the k node. When m is counted, the corresponding node is deleted from the linked list , And then count from 1 to the next node to be deleted, until the last node is deleted from the linked list and the algorithm ends.

## 3. Achieve

 - ##### Create circular linked list

    - ###### Define the ==first== node as the starting node and initialize it to null

   ```java
   private Boy first = null;
   ```

   

    - ###### Add operation: define an auxiliary pointer (initialized to null), if it is to add the first node, assign the first node to ==first==, point ==first== to ==first==, and then assign first to the auxiliary pointer. Otherwise, point the auxiliary pointer to the target node, then point the target node to the first node, and finally assign the target node to the auxiliary pointer.

   ```java
   public void addNode(int num) {
       if (num < 2) {
           System.out.println("There is an error in the input data...");
           return;
       }
       Boy curBoy = null;
       for (int i = 1; i <= num; i++) {
           Boy boy = new Boy(i);
           if (i == 1) {
               first = boy;
               first.setNext(first);
               curBoy = first;
           } else {
               curBoy.setNext(boy);
               boy.setNext(first);
               curBoy = boy;
           }
       }
   }
   
   ```

   

   - ######  Traversal operation: define the auxiliary pointer ==currentBoy== to point to ==first==, and traverse the entire linked list through the while loop until the end of ==currentBoy.next == first==

   ```java
   public void show() {
       if (first == null) {
           System.out.println("The list is empty...");
           return;
       }
       Boy curBoy = first;
       while (true) {
           System.out.println(curBoy);
           if (curBoy.getNext() == first) {
               break;
           }
           curBoy = curBoy.getNext();
       }
   }
   ```

   

- ##### The child goes out of the circle (count from K, count M)

  - ###### Create a helper pointer ==helper== to point to the last node of the linked list

  - ###### Before the child reports the count, move the ==helper== and ==first== ==K-1== times at the same time

  - ###### When the child counts, move ==first== and ==helper== ==M -1== times at the same time

  - ###### Move the child pointed to ==first== out of the circle

```java
public void countBoy(int num, int key, int count) {
    if (first == null || key < 1 || key > num) {
        System.out.println("There is an error in the input data...");
        return;
    }
    Boy helper = first;
    while (true) {
        if (helper.getNext() == first) {
            break;
        }
        helper = helper.getNext();
    }
    for (int i = 0; i < key - 1; i++) {
        first = first.getNext();
        helper = helper.getNext();
    }
    while (true) {
        if (helper == first) {
            break;
        }
        for (int i = 0; i < count - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        System.out.println("Out of the circle is" + first);
        first = first.getNext();
        helper.setNext(first);
    }
    System.out.println("What's left in the circle is" + first);
}
```



​	