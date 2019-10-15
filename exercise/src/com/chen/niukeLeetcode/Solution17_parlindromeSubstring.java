package com.chen.niukeLeetcode;
import java.util.*;
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/25 on 10:17
 **/
public class Solution17_parlindromeSubstring {
    /**
     * 要求出所有可能解，深度优先遍历，要求出最优解，解的个数，动态规划
     */
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        DFS(s,arrayLists,arrayList);
        return arrayLists;
    }
    public void DFS(String s , ArrayList<ArrayList<String>> res , ArrayList<String> cur){
        if(s.length() == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0,i);
            if(isParlindrome(sub)){
                cur.add(sub);
                DFS(s.substring(i),res,cur);
                cur.remove(cur.size()-1);
            }
        }

    }
    public boolean isParlindrome(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0,j = chars.length-1; i < j ; i++,j--) {
            if(chars[i] != chars[j]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        Solution17_parlindromeSubstring substringSolution17 = new Solution17_parlindromeSubstring();
        System.out.println(substringSolution17.partition(s));
    }
}
