package com.catzhang.kmp.violencematch;

/**
 * @author: crazycatzhang
 * @date: 2020/8/6 9:18 AM
 * @description: Solve string matching problems through brute force matching
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "HelloCatZhangHelloZhang";
        String str2 = "HelloZhang~";
        System.out.println(violenceMatch(str1, str2));
    }

    //Define ViolenceMatch method
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
