package com.chen.leetcode.StringMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 17:11
 **/
public class Solution17 {
    private int index = 0;
    //递归来做，每次遍历原数组，将原数组中的每一个元素都添加下一个数字对应的字符串中的每一个元素
    //原["a","b","c"] -- ["ad","ae","af"....]这样
    public List<String> letterCombinations(String digits) {
        String[] s1 = {"2","3","4","5","6","7","8","9"};
        String[] s2 = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            map.put(s1[i],s2[i]);
        }
        String temp = map.get(digits.charAt(0)+"");
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.charAt(i)+"");
        }
        return combineString(digits,list,map);
    }
    private List<String> combineString(String s,List<String> list,Map<String,String> map){
        if(index == s.length()-1){
            return list;
        }
        index++;
        String temp1 = map.get(s.charAt(index)+"");
        List<String> newList = new ArrayList<>();
        for (String t:list) {
            for (int j = 0; j < temp1.length() ; j++) {
                newList.add(t+temp1.charAt(j));
            }
        }
        list = newList;
        return combineString(s,list,map);
    }
}
