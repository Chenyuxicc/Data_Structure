package com.chen.leetcode.StringMath;

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

    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issipi";
        strStr(s1,s2);
    }
}
