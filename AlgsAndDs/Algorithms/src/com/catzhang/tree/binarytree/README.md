# Binary Tree

## 1. Basic Introduction

 - ###### A binary tree is a tree data structure in which each parent node can have at most two children.

 - ###### For example: In the image below, each element has at most two children.

![Binary Tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7upvh9smj30bk0c0q2x.jpg)

## 2. Types of Binary Tree

 - #### Full Binary Tree

   ###### A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.

   ![Full binary tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7uq8biuoj30bk0fkglp.jpg)

- #### Perfect Binary Tree

  ###### A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.

  ![Perfect binary tree](https://cdn.programiz.com/sites/tutorial2program/files/perfect-binary-tree_0.png)

- #### Complete Binary Tree

  ###### A complete binary tree is just like a full binary tree, but with two major differences

  - ###### Every level must be completely filled

  - ###### All the leaf elements must lean towards the left.

  - ###### The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.

  ![Complete Binary Tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7uqrzavfj30co0c0dfu.jpg)

- #### Degenerate or Pathological Tree

  ###### A degenerate or pathological tree is the tree having a single child either left or right.

  ![Degenerate Binary Tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7ur620p3j309c0fkdft.jpg)

- #### Skewed Binary Tree

  ###### A skewed binary tree is a pathological/degenerate tree in which the tree is either dominated by the left nodes or the right nodes. Thus, there are two types of skewed binary tree: `left-skewed binary tree` and `right-skewed binary tree`.

  ![Skewed Binary Tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7urfe99tj30i80c0gln.jpg)

- #### Balanced Binary Tree

  ###### It is a type of binary tree in which the difference between the left and the right subtree for each node is either 0 or 1.
  
  ![Balanced Binary Tree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7uroxttlj30io0hcjri.jpg)

## 3. Tree Travel

 - #### Basic

   ###### Traversing a tree means visiting every node in the tree. You might, for instance, want to add all the values in the tree or find the largest one. For all these operations, you will need to visit each node of the tree.

   ###### Linear data structures like arrays, [stacks](https://www.programiz.com/data-structures/stack), [queues](https://www.programiz.com/data-structures/queue), and [linked list](https://www.programiz.com/data-structures/linked-list) have only one way to read the data. But a hierarchical data structure like a [tree](https://www.programiz.com/data-structures/trees) can be traversed in different ways.

   ![sample tree to learn tree traversal - root node contains 1 with leftchild as 12 and right child as 9. The left child of root further has left child 5 and right child 6](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7v8spa7kj314k0g8dgz.jpg)

   ###### Let's think about how we can read the elements of the tree in the image shown above.

   ###### Starting from top, Left to right

   ```java
   1 -> 12 -> 5 -> 6 -> 9
   ```

   ###### Starting from bottom, Left to right

   ```java
   5 -> 6 -> 12 -> 9 -> 1
   ```

   ###### Although this process is somewhat easy, it doesn't respect the hierarchy of the tree, only the depth of the nodes.

   ###### Instead, we use traversal methods that take into account the basic structure of a tree i.e.

   ```c
   struct node {
       int data;
       struct node* left;
       struct node* right;
   }
   ```

   ###### The struct node pointed to by `left` and `right` might have other left and right children so we should think of them as sub-trees instead of sub-nodes.

   ###### According to this structure, every tree is a combination of

   - ###### A node carrying data

   - ###### Two subtrees

   ![root node with left subtree and right subtree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7v95ecdzj314k0hymyi.jpg)

   ###### Remember that our goal is to visit each node, so we need to visit all the nodes in the subtree, visit the root node and visit all the nodes in the right subtree as well.

   ###### Depending on the order in which we do this, there can be three types of traversal.

- #### Inorder traversal

  - ###### First, visit all the nodes in the left subtree

  - ###### Then the root node

  - ###### Visit all the nodes in the right subtree

  ```java
  public void middleOrder() {
      if (this.left != null) {
          this.left.middleOrder();
      }
      System.out.println(this);
      if (this.right != null) {
          this.right.middleOrder();
      }
  }
  ```

  

- #### Preorder traversal

  - ###### Visit root node

  - ###### Visit all the nodes in the left subtree

  - ###### Visit all the nodes in the right subtree

  ```java
  public void preOrder() {
      System.out.println(this);
      if (this.left != null) {
          this.left.preOrder();
      }
      if (this.right != null) {
          this.right.preOrder();
      }
  }
  ```

  

- #### Postorder traversal

  - ###### Visit all the nodes in the left subtree

  - ###### Visit all the nodes in the right subtree

  - ###### Visit the root node

  ```java
  public void postOrder() {
      if (this.left != null) {
          this.left.postOrder();
      }
      if (this.right != null) {
          this.right.postOrder();
      }
      System.out.println(this);
  }
  ```

  

- #### Visualize

  ###### Let's visualize in-order traversal. We start from the root node.

  ![outlining left subtree, right subtree and root node](https://cdn.programiz.com/sites/tutorial2program/files/tree_traversal_inorder-traversal.png)

  ###### We traverse the left subtree first. We also need to remember to visit the root node and the right subtree when this tree is done.

  ###### Let's put all this in a [stack](https://www.programiz.com/data-structures/stack) so that we remember.

  ![we put the left subtree, root node and right subtree in a stack in that order so that we can display root node and traverse right subtree when we are done with left subtree](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7vggd4i2j314k0m8gnf.jpg)

  ###### Now we traverse to the subtree pointed on the TOP of the stack.

  ###### Again, we follow the same rule of inorder

  ```java
  Left subtree -> root -> right subtree
  ```

  ###### After traversing the left subtree, we are left with

  ![situation of stack after traversing left subtree, stack now contains the elements of left subtree, followed by root, followed by right child of root](https://tva1.sinaimg.cn/large/007S8ZIlly1gi7vgr3jxaj314k0q00uo.jpg)

  ###### Since the node "5" doesn't have any subtrees, we print it directly. After that we print its parent `"12"` and then the right child `"6"`.

  ###### Putting everything on a stack was helpful because now that the left-subtree of the root node has been traversed, we can print it and go to the right subtree.

  ###### After going through all the elements, we get the inorder traversal as

  ```java
  5 -> 12 -> 6 -> 1 -> 9
  ```

  ###### We don't have to create the stack ourselves because recursion maintains the correct order for us.

## 4. Tree Search

 - #### Preorder Search

    - ###### Determine whether the current node is the target node to be found

    - ###### If they are equal, return the current node

    - ###### If they are not equal, judge whether the left child node of the current node is empty, if not, then search the left child node recursively

    - ###### If the left recursive preorder search finds the target node, then return, otherwise continue to judge whether the right child node of the current node is empty, if not, continue right recursive preorder search

   ```java
   public HeroNode preOrderSearch(int id) {
       if (this.id == id) {
           return this;
       }
       HeroNode temp = null;
       if (this.left != null) {
           temp = this.left.preOrderSearch(id);
       }
       if (temp != null) {
           return temp;
       }
       if (this.right != null) {
           temp = this.right.preOrderSearch(id);
       }
       return temp;
   }
   ```

   

 - #### Inorder Search

    - ###### Determine whether the left child node of the current node is empty, if not, perform a left recursive middle-order search

    - ###### If the target node is found, return, if not found, compare with the current node, if it is, return to the current node, otherwise continue with the right recursive middle-order search

    - ###### If right recursive middle order search finds the target node, return, otherwise return null

   ```java
   public HeroNode middleOrderSearch(int id) {
       HeroNode temp = null;
       if (this.left != null) {
           temp = this.left.middleOrderSearch(id);
       }
       if (temp != null) {
           return temp;
       }
       if (this.id == id) {
           return this;
       }
       if (this.right != null) {
           temp = this.right.middleOrderSearch(id);
       }
       return temp;
   }
   ```

   

 - #### Postorder Search

    - ###### Determine whether the left child node of the current node is empty, if it is not empty, perform a left recursive post-order search

    - ###### If found, return, otherwise, determine whether the right child node of the current node is empty, if not, perform right recursive post-order search, if found, return

   	- ###### Compare with the current node, and return if equal, otherwise return null

   ```java
   public HeroNode postOrderSearch(int id) {
       HeroNode temp = null;
       if (this.left != null) {
           temp = this.left.postOrderSearch(id);
       }
       if (temp != null) {
           return temp;
       }
       if (this.right != null) {
           temp = this.right.postOrderSearch(id);
       }
       if (temp != null) {
           return temp;
       }
       if (this.id == id) {
           return this;
       }
       return temp;
   }
   ```

## 5. Tree Delete

 - ###### If there is only one root node, leave the binary tree empty

 - ###### If the left child node of the current node is not empty, and the left child node is the target node to be deleted, set `this.left=null` and return

   ```java
   if (this.left != null && this.left.id == id) {
       this.left = null;
       return;
   }
   ```

   

 - ###### If the right child node of the current node is not empty, and the right child node is the target node to be deleted, set `this.right=null` and return

   ```java
   if (this.right != null && this.right.id == id) {
       this.right = null;
       return;
   }
   ```

   

 - ###### Recursively delete the left subtree

   ```java
   if (this.left != null) {
       this.left.deleteNode(id);
   }
   ```

   

 - ###### Recursively delete the right subtree

   ```java
   if (this.right != null) {
       this.right.deleteNode(id);
   }
   ```

   