# Queues

## 1. Basic Introduction

 - ##### The queue is an ordered list, which can be implemented as an array or a linked list

 - ##### Follow the principle of first in, first out. That is: the data stored in the queue first must be taken out first. What's deposited later will be taken out later

## 2. Application

 - ##### Use queue to realize bank queuing case

## 3. Achieve

 - ##### Use an array to simulate a circular queue

    - ###### Define the front pointer, which points to the first element of the queue. That is, arr[front] is the first element of the queue. Front is initialized to 0

   ```java
   private int front;
   ```

   

    - ###### Define the tails pointer to point to a position after the last element of the queue, because we hope to free up a space as a convention. Tails is initialized to 0

   ```java
   private int tails
   ```

   

    - ###### Use modulo operation to get the condition that the queue is full

   ```java
   public boolean isFull() {
       return (tails + 1) % capacity == front;
   }
   ```

   

    - ###### Determine whether the queue is empty according to the head and tail pointer of the queue

   ```java
   public boolean isEmpty() {
       return front == tails;
   }
   ```

   

    - ###### Get the number of valid data in the queue

   ```java
   public int getSize() {
       int size = (tails + capacity - front) % capacity;
       return size;
   }
   ```

   

    - ###### Add operation: judge whether the queue is full, if not, add the data to the queue and move the tails pointer one bit backward

   ```java
   public void addQueue(int data) {
       if (isFull()) {
           throw new RuntimeException("The queue is full...");
       }
       arrayQueue[tails] = data;
       tails = (tails + 1) % capacity;
   }
   ```

   

   - ###### Dequeue operation: determine whether the queue is empty, if not, get the element at the head of the queue and move the front pointer back

   ```java
   public int getFrontData() {
       if (isEmpty()) {
           throw new RuntimeException("The queue is empty...");
       }
       int values = arrayQueue[front];
       front = (front + 1) % capacity;
       return values;
   }
   ```

   



