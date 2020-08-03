package com.catzhang.huffmancode;

import java.util.*;

/**
 * @author: crazycatzhang
 * @date: 2020/8/2 10:10 PM
 * @description: Simple implementation of Huffman data compression and decompression
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        byte[] huffmanCodeCompression = huffmanCodeCompression(bytes);
        System.out.println(Arrays.toString(huffmanCodeCompression));

        byte[] decode = decode(huffmanCode, huffmanCodeCompression);
        System.out.println(new String(decode));

    }

    //Define a map that stores Huffman coding changes
    public static HashMap<Byte, String> huffmanCode = new HashMap<>();

    public static StringBuilder stringBuilder = new StringBuilder();

    public static int huffmanCodeStringLength = 0;

    //Define the method of decode
    public static byte[] decode(HashMap<Byte, String> huffmanCode, byte[] huffmanCodeCompression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanCodeCompression.length - 1; i++) {
            stringBuilder.append(byteToBitString(true, huffmanCodeCompression[i]));
        }
        byte lastByte = huffmanCodeCompression[huffmanCodeCompression.length - 1];
        String lastByteStr = byteToBitString(false, lastByte);
        if (stringBuilder.length() + lastByteStr.length() != huffmanCodeStringLength) {
            while (stringBuilder.length() + lastByteStr.length() < huffmanCodeStringLength) {
                stringBuilder.append(0);
            }
        }
        stringBuilder.append(lastByteStr);

        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            stringByteHashMap.put(entry.getValue(), entry.getKey());
        }

        ArrayList<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            Byte b = null;
            while (true) {
                String str = stringBuilder.substring(i, i + count);
                b = stringByteHashMap.get(str);
                if (b == null) {
                    count++;
                } else {
                    break;
                }
            }
            bytes.add(b);
            i += count;
        }

        byte[] bytes1 = new byte[bytes.size()];
        for (int i = 0; i < bytes1.length; i++) {
            bytes1[i] = bytes.get(i);
        }
        return bytes1;
    }

    //Convert byte to binary string
    public static String byteToBitString(boolean flag, byte bytes) {
        int temp = bytes;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag || temp < 0) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //Define HuffmanCode method
    public static byte[] huffmanCodeCompression(byte[] bytes) {
        ArrayList<Node> nodeArrayList = getNode(bytes);
        Node node = constructHuffmanTree(nodeArrayList);
        getHuffmanCode(node, "", stringBuilder);
        byte[] huffmanZip = huffmanZip(bytes, huffmanCode);
        return huffmanZip;
    }

    //Get a byte[] compressed by the Huffman coding table
    public static byte[] huffmanZip(byte[] bytes, HashMap<Byte, String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte byteCode :
                bytes) {
            stringBuilder.append(huffmanCode.get(byteCode));
        }
        huffmanCodeStringLength = stringBuilder.length();
        int len = (stringBuilder.length() + 7) / 8;
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str;
            if (i + 8 <= stringBuilder.length()) {
                str = stringBuilder.substring(i, i + 8);
            } else {
                str = stringBuilder.substring(i);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(str, 2);
        }
        return huffmanCodeBytes;
    }

    //Get the Huffman coding table
    public static void getHuffmanCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {
                getHuffmanCode(node.left, "0", stringBuilder1);
                getHuffmanCode(node.right, "1", stringBuilder1);
            } else {
                huffmanCode.put(node.data, stringBuilder1.toString());
            }
        }
    }

    //Construct the HuffmanTree
    public static Node constructHuffmanTree(ArrayList<Node> nodeArrayList) {
        while (nodeArrayList.size() > 1) {
            Collections.sort(nodeArrayList);
            Node leftNode = nodeArrayList.get(0);
            Node rightNode = nodeArrayList.get(1);
            Node parent = new Node(null, leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodeArrayList.remove(leftNode);
            nodeArrayList.remove(rightNode);
            nodeArrayList.add(parent);
        }
        return nodeArrayList.get(0);
    }

    //Define the method of getNode
    public static ArrayList<Node> getNode(byte[] bytes) {
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        HashMap<Byte, Integer> nodeHashMap = new HashMap<>();
        for (Byte byteCode :
                bytes) {
            Integer count = nodeHashMap.get(byteCode);
            if (count == null) {
                nodeHashMap.put(byteCode, 1);
            } else {
                nodeHashMap.put(byteCode, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : nodeHashMap.entrySet()) {
            nodeArrayList.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodeArrayList;
    }

    //Define Through method
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("The tree is empty...");
        }
    }
}

//Define Node
class Node implements Comparable<Node> {
    public Byte data;
    public int value;
    public Node left;
    public Node right;

    public Node(Byte data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
