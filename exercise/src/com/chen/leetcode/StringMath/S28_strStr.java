package com.chen.leetcode.StringMath;

import java.util.Arrays;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/4 on 9:58
 **/
public class S28_strStr {
    public static int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        char[] hayChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (i < hayChar.length){

            while (i < hayChar.length && j < needleChar.length && hayChar[i] == needleChar[j]){
                i++;
                j++;
            }
            if(j == needle.length()){
                return i - j;
            }else {
                i -= j;
                j = 0;
            }
            i++;
        }
        return -1;
    }
    public static int strStr_KMP(String haystack, String needle){
        if(needle.length() == 0){
            return 0;
        }
        char[] hayChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        if(next == null){
            return 0;
        }
        while (i < hayChar.length && j < needle.length()){
            if(j == -1 || hayChar[i] == needleChar[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j == needleChar.length){
            return i-j;
        }else {
            return -1;
        }
    }
    public static int[] getNext(String needle){
        char[] needleChar = needle.toCharArray();
        int[] next = new int[needleChar.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < needleChar.length - 1){
            if(j == -1 || needleChar[i] == needleChar[j]){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        System.out.println( strStr_KMP(s1,s2));
       // System.out.println(Arrays.toString(getNext(s2)));

    }
}
