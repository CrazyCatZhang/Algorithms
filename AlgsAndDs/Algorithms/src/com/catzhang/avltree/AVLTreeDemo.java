package com.catzhang.avltree;

/**
 * @author: crazycatzhang
 * @date: 2020/8/3 8:13 PM
 * @description: Simple implementation of AVLTree
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.middleOrder();

        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().left);
        System.out.println(avlTree.getRoot().right);
    }
}

//Define AVLTree
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    //Add the node
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            this.root.add(node);
        }
    }

    //Through the node
    public void middleOrder() {
        if (root == null) {
            System.out.println("The tree is empty...");
        } else {
            this.root.middleOrder();
        }
    }

    //Find the node
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //Find the node parent
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //Delete the minimum node with node as the root node and return the minimum value
    public int deleteRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    //Delete the node
    public void deleteNode(int value) {
        if (root == null) {
            System.out.println("The tree is empty...");
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == targetNode.value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                int min = deleteRightTreeMin(targetNode.right);
                targetNode.value = min;
            } else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.right.value == value) {
                            parent.right = targetNode.right;
                        } else {
                            parent.left = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}

//Define Node
class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //Define the method of AddNode
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }
            this.rightRotate();
            return;
        }
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
            }
            this.leftRotate();
        }
    }

    //Define Through method
    public void middleOrder() {
        if (this.left != null) {
            this.left.middleOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleOrder();
        }
    }

    //Define the method of find the node
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //Define the method of find the NodeParent
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //Define get the leftTree height
    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    //Define get the rightTree height
    public int rightHeight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.height();
        }
    }

    //Define get the tree height
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    //Define the method of leftRotate
    public void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;
    }

    //Define the method of rightRotate
    public void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }
}
