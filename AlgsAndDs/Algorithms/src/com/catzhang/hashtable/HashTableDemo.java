package com.catzhang.hashtable;

import java.util.Scanner;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 4:24 PM
 * @description: Simple implementation of Hash Table
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        while (true) {
            show();
            int id = 0;
            String name = "";
            int select = new Scanner(System.in).nextInt();
            switch (select) {
                case 1:
                    System.out.println("Pleas input the id:");
                    id = new Scanner(System.in).nextInt();
                    System.out.println("Please input the name:");
                    name = new Scanner(System.in).next();
                    hashTable.add(new Employee(id, name));
                    break;
                case 2:
                    System.out.println("Please enter the id you want to delete:");
                    id = new Scanner(System.in).nextInt();
                    hashTable.delete(id);
                    break;
                case 3:
                    hashTable.list();
                    break;
                case 4:
                    System.out.println("Please enter the id you want to find:");
                    id = new Scanner(System.in).nextInt();
                    hashTable.find(id);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public static void show() {
        System.out.println("1.添加员工");
        System.out.println("2.删除员工");
        System.out.println("3.显示员工");
        System.out.println("4.查找员工");
        System.out.println("0.退出系统");
    }
}

//Define HashTable Class
class HashTable {
    private int capacity;
    private EmployeeLinkedList[] employeeLinkedLists;

    public HashTable(int capacity) {
        this.capacity = capacity;
        employeeLinkedLists = new EmployeeLinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        int employeeLinkedListId = HashFun(employee.getId());
        employeeLinkedLists[employeeLinkedListId].addEmployee(employee);
    }

    public void delete(int id) {
        int employeeLinkedListId = HashFun(id);
        employeeLinkedLists[employeeLinkedListId].deleteEmployee(id);
    }

    public void list() {
        for (int i = 0; i < capacity; i++) {
            employeeLinkedLists[i].listEmployee(i);
        }
    }

    public void find(int id) {
        int employeeLinkedListId = HashFun(id);
        Employee employee = employeeLinkedLists[employeeLinkedListId].findEmployee(id);
        if (employee != null) {
            System.out.println("The Employee information is: " + employee);
        } else {
            System.out.println("The id is not existed...");
        }
    }

    public int HashFun(int id) {
        return id % capacity;
    }
}

//Define Employee Class
class Employee {
    private int id;
    private String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//Define EmployeeLinkedList
class EmployeeLinkedList {
    private Employee head;

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

    public void listEmployee(int index) {
        if (head == null) {
            System.out.println("The " + (index + 1) + " LinkedList is empty...");
            return;
        }
        System.out.print("The " + (index + 1) + " LinkedList information is: ");
        Employee current = head;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
        System.out.println();
    }

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
}