package com.chen.leetcode.StringMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/9 on 19:18
 **/
public class S30_findSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || words.length == 0){
            return list;
        }
        int wordNum = words.length;
        int wordLength = words[0].length();
        int all_length = wordNum*wordLength;
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for (int i = 0; i < s.length() - all_length + 1 ; i++) {
            Map<String,Integer> temMap = new HashMap<>();
            String tmp = s.substring(i,i+all_length);
            for (int j = 0; j < tmp.length() ; j += wordLength) {
                String tempSub = tmp.substring(j,j+wordLength);
                temMap.put(tempSub,temMap.getOrDefault(tempSub,0)+1);
            }
            if(temMap.equals(map)){
                list.add(i);
            }
        }
        return list;
    }
}
