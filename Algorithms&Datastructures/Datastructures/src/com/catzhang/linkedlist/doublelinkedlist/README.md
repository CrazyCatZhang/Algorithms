# DoubleLinkedList

## 1. Basic Introduction

 - ##### On the basis of the singly linked list, a predecessor pointer is added to the node to store the address of the previous node

 - ##### Doubly linked list can be searched forward or backward

 - ##### Doubly linked list can be self-deleted

## 2. Application

 - ##### Use a doubly linked list with head to achieve-Water Margin Hero Ranking

## 3. Achieve

 - ##### Traverse operation: define auxiliary pointer to traverse the linked list

```java
public void show() {
    if (head.next == null) {
        System.out.println("The LinkedList is empty...");
        return;
    }
    HeroDoubleNode temp = head.next;
    while (temp != null) {
        System.out.println(temp);
        temp = temp.next;
    }
}
```



 - ##### Add operation: add to the end of the doubly linked list

  - ###### Find the end node through auxiliary pointer traversal

  - ###### Point the end node to the target node

  - ###### Point the predecessor pointer of the target node to the original end node

```java
public void addNode(HeroDoubleNode node) {
    HeroDoubleNode temp = head;
    while (true) {
        if (temp.next == null) {
            break;
        }
        temp = temp.next;
    }
    temp.next = node;
    node.pre = temp;
}
```



- ##### Modification operation: traverse the auxiliary pointer to find the location of the target node, and then modify the target node information

```java
public void modify(HeroDoubleNode node) {
    if (head.next == null) {
        System.out.println("The LinkedList is empty...");
        return;
    }
    HeroDoubleNode temp = head.next;
    boolean flag = false;
    while (temp != null) {
        if (temp.id == node.id) {
            flag = true;
            break;
        }
        temp = temp.next;
    }
    if (flag) {
        temp.name = node.name;
        temp.nickname = node.nickname;
    } else {
        System.out.println("The Node Id is not existed...");
        return;
    }
}
```



- ##### Delete operation: self-delete

  - ###### Find the location of the target node through auxiliary pointer traversal

  - ###### Point the previous node of the target node to the next node of the target node

  - ###### Point the predecessor pointer of the next node of the target node to the previous node of the target node

```java
public void delete(int index) {
    if (head.next == null) {
        System.out.println("The LinkedList is empty...");
        return;
    }
    HeroDoubleNode temp = head.next;
    boolean flag = false;
    while (temp != null) {
        if (temp.id == index) {
            flag = true;
            break;
        }
        temp = temp.next;
    }
    if (flag) {
        temp.pre.next = temp.next;
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
    } else {
        System.out.println("The Node Id is not existed...");
        return;
    }
}
```

