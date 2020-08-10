package com.catzhang.binarysorttree;

/**
 * @author: crazycatzhang
 * @date: 2020/8/3 3:48 PM
 * @description: Simple implementation of binary sort tree
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.middleOrder();
        System.out.println();
        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(9);
        binarySortTree.deleteNode(12);
        binarySortTree.deleteNode(7);
        binarySortTree.deleteNode(3);
        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(1);
        binarySortTree.middleOrder();
    }
}

//Define BinarySortTree
class BinarySortTree {
    private Node root;

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
}