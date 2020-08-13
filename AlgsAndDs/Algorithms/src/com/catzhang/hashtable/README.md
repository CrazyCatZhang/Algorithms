# Hash Table 

## 1. Basic Introduction

 - ##### Hash table is a data structure that represents data in the form of **key-value** pairs. Each key is mapped to a value in the hash table. The keys are used for indexing the values/data. A similar approach is applied by an associative array

 - ##### Data is represented in a key value pair with the help of keys as shown in the figure below. Each data is associated with a key. The key is an integer that point to the data

   ![Hash Table key and data](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghphlx8qelj30au04u0sq.jpg)

- ##### Problem description: There is a company, when a new employee comes to report, the employee’s information is required to be added (id, gender, age, name, address...), when the employee’s id is entered, the employee is required to be found All information

## 2. Idea Diagram

 - #### Direct Address Table

   ###### Direct address table is used when the amount of space used by the table is not a problem for the program. Here, we assume that

   - ###### the keys are small integers

   - ###### the number of keys is not too large, and

   - ###### no two data have the same key

   ###### A pool of integers is taken called universe `U = {0, 1, ……., n-1}`

   ###### Each slot of a direct address table `T[0...n-1]` contains a pointer to the element that corresponds to the data

   ###### The index of the array `T` is the key itself and the content of `T` is a pointer to the set `[key, element]`. If there is no element for a key then, it is left as `NULL`

   ![Direct addressing representation](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghpi08fkqtj317j0u0dhq.jpg)

   ###### Sometimes, the key itself is the data

   ##### Limitations of a Direct Address Table

   - ###### The value of the key should be small

   - ###### The number of keys must be small enough so that it does not cross the size limit of an array

- #### Hash Table

  ###### In a hash table, the keys are processed to produce a new index that maps to the required element. This process is called hashing

  ###### Let `h(x)` be a hash function and `k` be a key

  ###### `h(k)` is calculated and it is used as an index for the element

  ![Hash Table representation](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghpi0lb30cj311j0u00uf.jpg)

  ##### Limitations of a Hash Table

  - ###### If the same index is produced by the hash function for multiple keys then, conflict arises. This situation is called collision

    ###### To avoid this, a suitable hash function is chosen. But, it is impossible to produce all unique keys because `|U|>m`. Thus a good hash function may not prevent the collisions completely however it can reduce the number of collisions

  ###### However, we have other techniques to resolve collision

  ##### Advantages of hash table over direct address table:

  ###### The main issues with direct address table are the size of the array and the possibly large value of a key. The hash function reduces the range of index and thus the size of the array is also reduced

  ###### For example, If `k = 9845648451321`, then `h(k) = 11` (by using some hash function). This helps in saving the memory wasted while providing the index of `9845648451321` to the array

  ##### Collision resolution by chaining

  ###### In this technique, if a hash function produces the same index for multiple elements, these elements are stored in the same index by using a doubly linked list

  ###### If `j` is the slot for multiple elements, it contains a pointer to the head of the list of elements. If no element is present, `j` contains `NIL`

  ![Collision resolution in hash table](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghpi0zgmc8j31kg0u0ac7.jpg)

## 3. Achieve

 - ##### Create employee linked list

    - ###### Define head pointer

      ```java
      private Employee head;
      ```

      

    - ###### Add operation: define the auxiliary pointer to traverse the entire linked list until it points to the last element of the linked list, and then add an element after it

      ```java
      public void addEmployee(Employee employee) {
          if (head == null) {
              head = employee;
              return;
          }
          Employee current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = employee;
      }
      ```

      

    - ###### Search operation: define the auxiliary pointer to traverse the entire linked list, and return the element until the pointed element id is the same as the target element id

      ```java
      public Employee findEmployee(int id) {
          if (head == null) {
              System.out.println("The LinkedList is empty...");
              return null;
          }
          Employee current = head;
          boolean flag = false;
          while (current != null) {
              if (current.getId() == id) {
                  flag = true;
                  break;
              }
              current = current.next;
          }
          if (flag) {
              return current;
          } else {
              return null;
          }
      }
      ```

      

    - ###### Delete operation: define an auxiliary pointer `current`, an auxiliary pointer `present`, and initialize it as `head`. Through `current` traversing the entire linked list, `present` points to the previous position of `current` during the traversal process, and exits when the id of the target element is found or the entire linked list is traversed. If current is null at this time, it means that the element id to be deleted is not found; otherwise, it is judged whether `current` is equal to `present`, if it is equal, the `head` element is deleted, if not, `present` is pointed to the next element of `current`

      ```java
      public void deleteEmployee(int id) {
          if (head == null) {
              System.out.println("The LinkedList is empty...");
              return;
          }
          Employee current = head;
          Employee present = head;
          while (current != null && !(current.getId() == id)) {
              present = current;
              current = current.next;
          }
          if (current == null) {
              System.out.println("The id is not existed...");
          } else {
              if (present == current) {
                  head = current.next;
              }
              present.next = current.next;
          }
      }
      ```

      

- ##### Creat Hash Table

  - ###### Define employee linked list array

    ```java
    private EmployeeLinkedList[] employeeLinkedLists;
    ```

    

  - ###### Initial operation

    ```java
    public HashTable(int capacity) {
        this.capacity = capacity;
        employeeLinkedLists = new EmployeeLinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }
    ```

    

  - ###### Create a method to return the array position index where the employee id should be stored

    ```java
    public int HashFun(int id) {
        return id % capacity;
    }
    ```

    

  - ###### Add operation: find the location where the employee id should be stored in HashTable, and then add

    ```java
    public void add(Employee employee) {
        int employeeLinkedListId = HashFun(employee.getId());
        employeeLinkedLists[employeeLinkedListId].addEmployee(employee);
    }
    ```

    

  - ###### Delete operation: find the location where the employee id is to be stored in the HashTable, and then delete

    ```java
    public void delete(int id) {
        int employeeLinkedListId = HashFun(id);
        employeeLinkedLists[employeeLinkedListId].deleteEmployee(id);
    }
    ```

    

  - ###### Search operation: find the location where the employee id should be stored in the HashTable, and then return the element

    ```java
    public void find(int id) {
        int employeeLinkedListId = HashFun(id);
        Employee employee = employeeLinkedLists[employeeLinkedListId].findEmployee(id);
        if (employee != null) {
            System.out.println("The Employee information is: " + employee);
        } else {
            System.out.println("The id is not existed...");
        }
    }
    ```

    











 