package com.catzhang.tree.binarytree;

/**
 * @author: crazycatzhang
 * @date: 2020/7/31 8:33 PM
 * @description: Simple implementation of preorder, middle order and postorder traversal of binary tree
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        System.out.println("The PreOrder is: ");
        binaryTree.preOrder();
//        System.out.println("The MiddleOrder is: ");
//        binaryTree.middleOrder();
//        System.out.println("The PostOrder is: ");
//        binaryTree.postOrder();
//        System.out.println();
//
//        System.out.println("The PreOrderSearch is: ");
//        System.out.println(binaryTree.preOrderSearch(5));
//        System.out.println("The MiddleOrderSearch is: ");
//        System.out.println(binaryTree.middleOrderSearch(5));
//        System.out.println("The PostOrderSearch is: ");
//        System.out.println(binaryTree.postOrderSearch(5));

        binaryTree.deleteNode(5);
        System.out.println();
        binaryTree.preOrder();

    }
}

//Define BinaryTree
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
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

    public HeroNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public HeroNode middleOrderSearch(int id) {
        if (this.root != null) {
            return this.root.middleOrderSearch(id);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int id) {
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
}

//Define HeroNode
class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
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

    //Define MiddleOrderSearch method
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

    //Define PostOrderSearch method
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