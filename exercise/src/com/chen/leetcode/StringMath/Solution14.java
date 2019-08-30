package com.chen.leetcode.StringMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 15:28
 **/
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        if(strs.length == 0){
            return "";
        }
        for (String s:
             strs) {
            min = Math.min(s.length(),min);
        }
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while (index < min){
            char sub = strs[0].charAt(index);
            for (String s: strs) {
                if(sub != s.charAt(index)){
                    return sb.toString();
                }
            }
            sb.append(sub);
            index ++;
        }
        return sb.toString();
    }
}
