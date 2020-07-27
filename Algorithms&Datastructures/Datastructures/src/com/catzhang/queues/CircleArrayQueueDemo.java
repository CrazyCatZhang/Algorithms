package com.catzhang.queues;

import java.util.Scanner;

/**
 * @author: crazycatzhang
 * @date: 2020/7/27 6:43 下午
 * @description: Array simulates the basic implementation of ring queues
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        while (true){
            show();
            int select = new Scanner(System.in).nextInt();
            switch (select){
                case 1:
                    try {
                        circleArrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("请输入你要添加的数据：");
                    try {
                        circleArrayQueue.addQueue(new Scanner(System.in).nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        int frontData = circleArrayQueue.getFrontData();
                        System.out.println("Front Data：" + frontData);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
    public static void show(){
        System.out.println("1.显示队列");
        System.out.println("2.添加队列");
        System.out.println("3.获取队列");
        System.out.println("0.退出");
    }
}

class CircleArrayQueue{
    private int capacity; //Define array capacity
    private int front; //Defines a pointer to the first element of an array
    private int tails; //Defines the last pointer to the last element of the array
    private int [] arrayQueue; //Defines an array to store the data

    public CircleArrayQueue(int capacity){
        this.capacity = capacity;
        this.arrayQueue = new int[this.capacity];
    }

    //Determine if the queue is empty
    public boolean isEmpty(){
        return front == tails;
    }

    //Determine if the queue is full
    public boolean isFull(){
        return (tails + 1) % capacity == front;
    }

    //add data to the queue
    public void addQueue(int data){
        if (isFull()){
            throw new RuntimeException("The queue is full...");
        }
        arrayQueue[tails] = data;
        tails = (tails + 1) % capacity;
    }

    //Get the data of the front node and get out of the queue
    public int getFrontData(){
        if (isEmpty()){
            throw new RuntimeException("The queue is empty...");
        }
        int values = arrayQueue[front];
        front = (front + 1) % capacity;
        return values;
    }

    //Displays all the data for the queue
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("The queue is empty...");
        }
        for (int i = front; i < front + getSize(); i++) {
            System.out.println("arr[" + (i % capacity) + "] = " + arrayQueue[i % capacity]);
        }
    }

    public int getSize(){
        int size = (tails + capacity - front) % capacity;
        return size;
    }
}