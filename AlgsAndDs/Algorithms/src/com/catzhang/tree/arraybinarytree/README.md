# Sequential Binary Tree

## 1. Basic Introduction	

 - ###### From the perspective of data storage, the array storage method and the tree storage method can be converted to each other, that is, an array can be converted into a tree, and a tree can also be converted into an array

## 2. Features

 - ###### Sequential binary trees usually only consider complete binary trees

 - ###### The left child node of the nth element is 2 * n + 1

 - ###### The right child node of the nth element is 2 * n + 2

 - ###### The parent node of the nth element is (n-1) / 2

 - ###### n: Indicates the number of elements in the binary tree (start numbering with 0 as shown in the figure)

## 3. Tree Travel

 - #### Preorder traversal

    - ###### Output current node

    - ###### If the left child node of the current node is less than the length of the array, recursively traverse to the left

    - ###### If the right child node of the current node is less than the length of the array, recursively traverse to the right

   ```java
   public void preOrder(int index) {
       if (arr == null || arr.length == 0) {
           System.out.println("The tree is empty...");
           return;
       }
       System.out.print(arr[index] + " ");
       if ((index * 2 + 1) < arr.length) {
           preOrder((index * 2 + 1));
       }
       if ((index * 2 + 2) < arr.length) {
           preOrder((index * 2 + 2));
       }
   }
   ```

   

 - #### Inorder traversal

    - ###### If the left child node of the current node is less than the length of the array, recursively traverse to the left

    - ###### Output current node

    - ###### If the right child node of the current node is less than the length of the array, recursively traverse to the right

   ```java
   public void middleOrder(int index) {
       if (arr == null || arr.length == 0) {
           System.out.println("The tree is empty...");
           return;
       }
       if ((index * 2 + 1) < arr.length) {
           middleOrder((index * 2 + 1));
       }
       System.out.print(arr[index] + " ");
       if ((index * 2 + 2) < arr.length) {
           middleOrder((index * 2 + 2));
       }
   }
   ```

   

 - #### Postorder traversal

    - ###### If the left child node of the current node is less than the length of the array, recursively traverse to the left

    - ###### If the right child node of the current node is less than the length of the array, recursively traverse to the right

    - ###### Output current node

   ```java
   public void postOrder(int index) {
       if (arr == null || arr.length == 0) {
           System.out.println("The tree is empty...");
           return;
       }
       if ((index * 2 + 1) < arr.length) {
           postOrder((index * 2 + 1));
       }
       if ((index * 2 + 2) < arr.length) {
           postOrder((index * 2 + 2));
       }
       System.out.print(arr[index] + " ");
   }
   ```

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   

   