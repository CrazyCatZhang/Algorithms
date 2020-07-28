package com.catzhang.linkedlist;

/**
 * @author: crazycatzhang
 * @date: 2020/7/28 11:30 AM
 * @description: Basic realization of bidirectional linked list
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNode(new HeroDoubleNode(1, "宋江", "及时雨"));
        doubleLinkedList.addNode(new HeroDoubleNode(4, "鲁智深", "花和尚"));
        doubleLinkedList.addNode(new HeroDoubleNode(2, "林冲", "豹子头"));
        doubleLinkedList.addNode(new HeroDoubleNode(3, "吴用", "智多星"));
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.delete(4);
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.modify(new HeroDoubleNode(1, "小江", "及时雨啊哈"));
        doubleLinkedList.show();
        System.out.println();
        System.out.println(doubleLinkedList.select(1));
    }
}

//Define DoubleLinkedList
class DoubleLinkedList {
    private HeroDoubleNode head = new HeroDoubleNode(0, "", "");

    public HeroDoubleNode getHead() {
        return head;
    }

    //Through the DoubleLinkedList
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

    //Add Node to the LinkedList
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

    //Delete the Node of the LinkedList
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

    //Modify the Node of the LinkedList
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

    //Select the Node of the LinkedList
    public HeroDoubleNode select(int index) {
        if (head.next == null) {
            System.out.println("The LinkedList is empty...");
            return null;
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
            return temp;
        }
        return null;
    }
}

//Define Node
class HeroDoubleNode {
    public int id;
    public String name;
    public String nickname;
    public HeroDoubleNode next;
    public HeroDoubleNode pre;

    public HeroDoubleNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroDoubleNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
