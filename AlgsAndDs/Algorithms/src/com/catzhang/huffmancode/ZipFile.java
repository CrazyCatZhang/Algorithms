package com.catzhang.huffmancode;

import java.io.*;
import java.util.HashMap;

/**
 * @author: crazycatzhang
 * @date: 2020/8/3 12:31 PM
 * @description: Simple realization of file compression and decompression
 */
public class ZipFile {
    public static void main(String[] args) {
        zipFile("CatZhang.bmp", "test.zip");
        unZipFile("test.zip", "CatZhang2.bmp");
    }

    //Define the method of CompressionFile
    public static void zipFile(String sourcePath, String outPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(sourcePath);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] huffmanBytes = HuffmanCode.huffmanCodeCompression(bytes);
            fos = new FileOutputStream(outPath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(huffmanBytes);
            oos.writeObject(HuffmanCode.huffmanCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Define the method of DeCompressionFile
    public static void unZipFile(String sourcePath, String outPath) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourcePath);
            ois = new ObjectInputStream(fis);
            fos = new FileOutputStream(outPath);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            HashMap<Byte, String> huffmanCode = (HashMap<Byte, String>) ois.readObject();
            byte[] decode = HuffmanCode.decode(huffmanCode, huffmanBytes);
            fos.write(decode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
