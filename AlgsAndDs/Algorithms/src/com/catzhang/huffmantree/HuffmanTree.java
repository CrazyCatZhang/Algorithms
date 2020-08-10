package com.catzhang.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: crazycatzhang
 * @date: 2020/8/2 6:31 PM
 * @description: Simple implementation of Huffman tree
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        System.out.println(creatHuffmanTree(arr));
        System.out.println();
        preOrder(creatHuffmanTree(arr));
    }

    //Define Through method
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("The tree is empty...");
        }
    }

    //Define the method of creating HuffmanTree
    public static Node creatHuffmanTree(int[] arr) {
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        for (int value :
                arr) {
            nodeArrayList.add(new Node(value));
        }
        while (nodeArrayList.size() > 1) {
            Collections.sort(nodeArrayList);
            Node leftNode = nodeArrayList.get(0);
            Node rightNode = nodeArrayList.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodeArrayList.remove(leftNode);
            nodeArrayList.remove(rightNode);

            nodeArrayList.add(parent);
        }
        return nodeArrayList.get(0);
    }
}

class Node implements Comparable<Node> {
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

    //Define Through PreOrder method
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
