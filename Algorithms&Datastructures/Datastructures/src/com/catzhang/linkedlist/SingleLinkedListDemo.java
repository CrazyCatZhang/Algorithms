package com.catzhang.linkedlist;

/**
 * @author: crazycatzhang
 * @date: 2020/7/27 8:11 下午
 * @description: Simple implementation of a single linked list
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNodeOrder(new HeroNode(1,"宋江","及时雨"));
        singleLinkedList.addNodeOrder(new HeroNode(4,"鲁智深","花和尚"));
        singleLinkedList.addNodeOrder(new HeroNode(2,"林冲","豹子头"));
        singleLinkedList.addNodeOrder(new HeroNode(3,"吴用","智多星"));
        singleLinkedList.show();
        System.out.println();
        singleLinkedList.modifyNode(new HeroNode(1,"小江","及时雨啊哈"));
        singleLinkedList.show();
        System.out.println();
        singleLinkedList.deleteNode(2);
        singleLinkedList.show();
    }
}

//Define SingleLinkedList
class SingleLinkedList{
    //Define HeadNode
    HeroNode head = new HeroNode(0,"","");

    //Add Node
    public void addNode(HeroNode node){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //Add Node with Order
    public void addNodeOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id > node.id){
                break;
            }else if (temp.next.id == node.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("The Hero Id is existed...");
            return;
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //Modify the Node data
    public void modifyNode(HeroNode node){
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.id == node.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else {
            System.out.println("The Node Id is not existed in the LinkedList...");
        }
    }

    //Delete Node
    public void deleteNode(int id){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("The Node Id is not existed in the LinkedList...");
        }
    }

    //Through LinkedList
    public void show(){
        if (head.next == null){
            throw new RuntimeException("The LinkedList is empty...");
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//Define Node
class HeroNode{
    public int id;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
