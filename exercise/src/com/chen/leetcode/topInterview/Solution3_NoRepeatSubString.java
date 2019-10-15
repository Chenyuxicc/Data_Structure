package com.chen.leetcode.topInterview;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/5 on 20:17
 **/
public class Solution3_NoRepeatSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int minWindow = 1;
        int maxWindow = 1;
        int i = 0;
        int j = i + minWindow;
        while (j < chars.length){
            while (j < chars.length && isSame(i,j,chars) == j){
                minWindow++;
                maxWindow = minWindow > maxWindow ? minWindow : maxWindow;
                j++;
            }
            if(j == chars.length || j == chars.length - 1){
                break;
            }
            i = isSame(i,j,chars) + 1;
            minWindow = 1;
            j = i + minWindow;

        }
        return maxWindow;
    }
    private int isSame(int i,int j,char[] chars){
        if(i >= j){
            return -1;
        }
        while (i < chars.length && chars[i] != chars[j] && i < j  ){
            i++;
        }
        return i;
    }
    // 使用HashSet作为滑动窗口来判断当前字符是否为重复字符
    public int lengthOfLongestSubstring1(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int length = s.length();
        int maxWindow = 0;
        while (i < length && j < s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                maxWindow = Math.max(maxWindow,j-i);
            }else {
                hashSet.remove(s.charAt(i++));
            }
        }
        return maxWindow;
    }
    //优化二：使用hashmap存放位置和字符
    public int lengthOfLongestSubstring2(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int j = 0;
        int maxWindow = 0;
        for (int i = 0; i<s.length() && j < s.length() ; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            maxWindow = Math.max(j-i+1,maxWindow);
            map.put(s.charAt(j),j+1);
        }
        return maxWindow;
    }


    public static void main(String[] args) {
//        String s = "bbbbbbb";
//        String s1 = "abcabccbb";
//        String s2 = "pwwkew";
//        String s3 = "ggububgvfk";
//        Solution3_NoRepeatSubString solution = new Solution3_NoRepeatSubString();
//        System.out.println("s:"+solution.lengthOfLongestSubstring(s));
//        System.out.println("s1:"+solution.lengthOfLongestSubstring(s1));
//        System.out.println("s3:"+solution.lengthOfLongestSubstring(s3));
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('c',1);
        map.put('c',2);
        System.out.println(map.get('c'));
        System.out.println(map.size());
    }
}
