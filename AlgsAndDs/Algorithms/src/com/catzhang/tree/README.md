# Tree

## 1. Basic Introduction

 - ##### A tree is a nonlinear hierarchical data structure that consists of nodes connected by edges

   ![tree in data structure](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghqmzolms2j30co0fkdfy.jpg)

## 2. Why Tree Data Structure

 - ##### Other data structures such as arrays, linked list, stack, and queue are linear data structures that store data sequentially. In order to perform any operation in a linear data structure, the time complexity increases with the increase in the data size. But, it is not acceptable in today's computational world.

 - ##### Different tree data structures allow quicker and easier access to the data as it is a non-linear data structure.

## 3. Tree Terminologies

 - #### Node

    - ###### A node is an entity that contains a key or value and pointers to its child nodes.

    - ###### The last nodes of each path are called `leaf nodes or external nodes` that do not contain a link/pointer to child nodes.

   	- ###### The node having at least a child node is called an `internal node`.

- #### Edge

  - ###### It is the link between any two nodes.

    ![Nodes and edges of a tree](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghqnaff0h9j30h20c0wem.jpg)

- #### Root

  - ###### It is the topmost node of a tree.

- #### Height of a Node

  - ###### The height of a node is the number of edges from the node to the deepest leaf (ie. the longest path from the node to a leaf node).

    ![Height and depth of each node in a tree](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghqnap7x7jj30io0hcdg0.jpg)

- #### Depth of a Node

  - ###### The depth of a node is the number of edges from the root to the node.

- #### Height of a Tree

  - ###### The height of a Tree is the height of the root node or the depth of the deepest node.

- #### Degree of a Node

  - ###### The degree of a node is the total number of branches of that node.

- #### Forest

  - ###### A collection of disjoint trees is called a forest.

    ![Forest in data structure](https://tva1.sinaimg.cn/large/007S8ZIlgy1ghqnayu9rxj30qo0ccdg2.jpg)

  - ###### You can create a forest by cutting the root of a tree.

