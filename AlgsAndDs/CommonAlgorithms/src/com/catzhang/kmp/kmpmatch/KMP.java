package com.catzhang.kmp.kmpmatch;


/**
 * @author: crazycatzhang
 * @date: 2020/8/6 10:18 AM
 * @description: Realize string matching through kmp algorithm
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] partialMatchTable = partialMatchTable(str2);
        System.out.println(kmpMatch(str1, str2, partialMatchTable));
    }

    //Define KMP method
    public static int kmpMatch(String str1, String str2, int[] partialMatchTable) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = partialMatchTable[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //Get the partial matching value table of the string
    public static int[] partialMatchTable(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
