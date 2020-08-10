# SingleLinkedList

## 1. Basic Introduction

 - ##### The singly linked list nodes include data domain and next domain, data domain stores data, and next domain stores the address of the next node

 - ##### Head node points to the start node

 - ##### The end node has no successor, the next field points to null

## 2. Applications

 - ##### Use the single-linked list with head to realize the leaderboard management of Water Margin heroes to complete the addition, deletion, and modification of heroes

## 3. Achieve

 - ##### Create Head node

```java
private HeroNode head = new HeroNode(0, "", "");
```



 - ##### Add operation: directly add to the end of the linked list

    - ###### If the linked list is empty, point the Head node to the target node to be added

    - ###### If the linked list is not empty, traverse the entire linked list through the auxiliary pointer to obtain the final node, and then point it to the target node to be added

```java
public void addNode(HeroNode node) {
    HeroNode temp = head;
    while (true) {
        if (temp.next == null) {
            break;
        }
        temp = temp.next;
    }
    temp.next = node;
}
```



- ##### Add operation: insert the hero into the specified position according to the ranking

  - ###### Define the auxiliary pointer temp to point it to the Head node

  - ###### Compare the ranking of the next node of temp with the target node to be added, and find the position of the target node to be added

  - ###### Point the target node to the next node of temp

  - ###### Point temp to the target node

```java
public void addNodeOrder(HeroNode node) {
    HeroNode temp = head;
    boolean flag = false;
    while (true) {
        if (temp.next == null) {
            break;
        }
        if (temp.next.id > node.id) {
            break;
        } else if (temp.next.id == node.id) {
            flag = true;
            break;
        }
        temp = temp.next;
    }
    if (flag) {
        System.out.println("The Hero Id is existed...");
        return;
    } else {
        node.next = temp.next;
        temp.next = node;
    }
}
```



- ##### Modify node information: traverse the linked list through the auxiliary pointer to find the location of the target node, and then change its node information

```java
public void modifyNode(HeroNode node) {
    HeroNode temp = head.next;
    boolean flag = false;
    while (true) {
        if (temp == null) {
            break;
        }
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
        System.out.println("The Node Id is not existed in the LinkedList...");
    }
}
```



- ##### Delete node: find the previous node temp of the target node, and then point temp to the next node of the target node

```java
public void deleteNode(int id) {
    HeroNode temp = head;
    boolean flag = false;
    while (true) {
        if (temp.next == null) {
            break;
        }
        if (temp.next.id == id) {
            flag = true;
            break;
        }
        temp = temp.next;
    }
    if (flag) {
        temp.next = temp.next.next;
    } else {
        System.out.println("The Node Id is not existed in the LinkedList...");
    }
}
```

## 4. Interview Questions

 - ##### Get the number of valid nodes in the singly linked list

```java
public static int getLength(HeroNode head) {
    if (head.next == null){
        return 0;
    }
    HeroNode temp = head.next;
    int count = 0;
    while (temp != null) {
        count++;
        temp = temp.next;
    }
    return count;
}
```



 - ##### Find the kth node from the bottom in the singly linked list

    - ###### Traverse the linked list, get the total length of the linked list length

    - ###### Check whether K is within the length of the linked list

    - ###### Define auxiliary pointers, traverse (size-index) from the first of the linked list

    - ###### If found, return the node, otherwise return null

```java
public static HeroNode findLastNode(HeroNode head, int index) {
    if (head.next == null || index > getLength(head)) {
        return null;
    }
    HeroNode temp = head.next;
    for (int i = 0; i < getLength(head) - index; i++) {
        temp = temp.next;
    }
    return temp;
}
```



 - ##### Reversal of singly linked list

    - ###### Define a new head node reverseHead

    - ###### Define a node to store the next node of the current node

    - ###### Define auxiliary pointer to traverse the linked list

    - ###### Define the auxiliary pointer to traverse the linked list, take it out every time a node is traversed, and put it at the forefront of the new linked list reverseHead

    - ###### Point the Head node of the original linked list to the next node of the reverseHead node

```java
public static void reverseList(HeroNode head) {
    if (head.next == null || head.next.next == null) {
        return;
    }
    HeroNode reverseHead = new HeroNode(0, "", "");
    HeroNode current = head.next;
    HeroNode next = null;
    while (current != null) {
        next = current.next;
        current.next = reverseHead.next;
        reverseHead.next = current;
        current = next;
    }
    head.next = reverseHead.next;
}
```



 - ##### Print singly linked list from end to beginning

   	- ###### Push each node into the stack, and then use the first-in-last-out feature of the stack to achieve the effect of reverse printing

```java
public static void reversePrint(HeroNode head) {
    Stack<HeroNode> heroNodeStack = new Stack<>();
    HeroNode temp = head.next;
    while (temp != null) {
        heroNodeStack.add(temp);
        temp = temp.next;
    }
    while (heroNodeStack.size() > 0) {
        System.out.println(heroNodeStack.pop());
    }
}
```



