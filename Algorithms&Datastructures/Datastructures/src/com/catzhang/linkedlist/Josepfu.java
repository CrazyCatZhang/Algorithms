package com.catzhang.linkedlist;

/**
 * @author: crazycatzhang
 * @date: 2020/7/28 3:01 PM
 * @description: Josepfu problem is realized through unidirectional circular linked list
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(5, 1, 2);
    }
}

//Define CircleSingleLinkedList
class CircleSingleLinkedList {
    private Boy first = null;

    //Add Node to the list
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

    //Through the list
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

    /*
     * @param num: Boy's number
     * @param key: The number of children who start counting
     * @param count: Count down to number one
     * @return: void
     * @author: crazycatzhang
     * @date: 2020/7/28 8:13 PM
     * @description: Josepfu Question ones with queue
     */
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
}

//Define Boy Node
class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}