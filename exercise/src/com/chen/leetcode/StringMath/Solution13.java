package com.chen.leetcode.StringMath;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 15:06
 **/
public class Solution13 {
    //涉及到随机查找，考虑使用map
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap<>();
        String[] sarr = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] iarr = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        for (int i = 0; i < sarr.length ; i++) {
            map.put(sarr[i],iarr[i]);
        }
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            if(i+1 < s.length() && map.containsKey(s.substring(i,i+2))){
                result += map.get(s.substring(i,i+2));
                i += 2;
            }else {
                result += map.get(s.substring(i,i+1));
                i += 1;
            }
        }
        return result;
    }
}
