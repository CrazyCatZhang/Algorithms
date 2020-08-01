package com.catzhang.tree;

/**
 * @author: crazycatzhang
 * @date: 2020/8/1 10:38 AM
 * @description: Simple implementation of threaded binary tree
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, "Tom");
        TreeNode node2 = new TreeNode(3, "Jack");
        TreeNode node3 = new TreeNode(6, "Smith");
        TreeNode node4 = new TreeNode(8, "Mary");
        TreeNode node5 = new TreeNode(10, "King");
        TreeNode node6 = new TreeNode(14, "Dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);

//        threadedBinaryTree.middleOrderThreadedBinaryTree();
        threadedBinaryTree.postOrderThreadedBinaryTree();
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


    }
}

//Define ThreadedBinaryTree class
class ThreadedBinaryTree {
    private TreeNode root;
    //Define the predecessor node of the current node
    private TreeNode pre = null;

    public TreeNode getPre() {
        return pre;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("The BinaryTree is empty...");
        }
    }

    public void middleOrder() {
        if (this.root != null) {
            this.root.middleOrder();
        } else {
            System.out.println("The BinaryTree is empty...");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("The BinaryTree is empty...");
        }
    }

    public TreeNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public TreeNode middleOrderSearch(int id) {
        if (this.root != null) {
            return this.root.middleOrderSearch(id);
        } else {
            return null;
        }
    }

    public TreeNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    public void deleteNode(int id) {
        if (this.root != null) {
            if (this.root.getId() == id) {
                this.root = null;
            } else {
                this.root.deleteNode(id);
            }
        } else {
            System.out.println("The tree is empty...");
        }
    }

    public void preOrderThreadedBinaryTree() {
        this.preOrderThreadedBinaryTree(this.root);
    }

    public void middleOrderThreadedBinaryTree() {
        this.middleOrderThreadedBinaryTree(this.root);
    }

    public void postOrderThreadedBinaryTree() {
        this.postOrderThreadedBinaryTree(this.root);
    }

    //Define PreOrder ThreadedBinaryTree method
    public void preOrderThreadedBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        if (node.getLeftType() != 1) {
            preOrderThreadedBinaryTree(node.getLeft());
        }
        if (node.getRightType() != 1) {
            preOrderThreadedBinaryTree(node.getRight());
        }
    }

    //Define MiddleOrder ThreadedBinaryTree method
    public void middleOrderThreadedBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }

        middleOrderThreadedBinaryTree(node.getLeft());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        middleOrderThreadedBinaryTree(node.getRight());
    }

    //Define PostOrder ThreadedBinaryTree method
    public void postOrderThreadedBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderThreadedBinaryTree(node.getLeft());

        postOrderThreadedBinaryTree(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
    }
}

//Define TreeNode
class TreeNode {
    private int id;
    private String name;
    private TreeNode left;
    private TreeNode right;

    //Define the status of the left and right nodes of the current node
    //if leftType == 0 => Indicates that it points to the left subtree
    //if leftType == 1 => Indicates that it points to the precursor node
    private int leftType;
    //if rightType == 0 => Indicates that it points to the right subtree
    //if rightType == 1 => Indicates that it points to the successor node
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public TreeNode(int id, String name) {
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

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //Define PreOrder method
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //Define MiddleOrder method
    public void middleOrder() {
        if (this.left != null) {
            this.left.middleOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleOrder();
        }
    }

    //Define PostOrder method
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //Define PreOrderSearch method
    public TreeNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }
        TreeNode temp = null;
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

    //Define MiddleOrderSearch method
    public TreeNode middleOrderSearch(int id) {
        TreeNode temp = null;
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

    //Define PostOrderSearch method
    public TreeNode postOrderSearch(int id) {
        TreeNode temp = null;
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

    //Define DeleteNode method
    public void deleteNode(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteNode(id);
        }
        if (this.right != null) {
            this.right.deleteNode(id);
        }
    }
}
