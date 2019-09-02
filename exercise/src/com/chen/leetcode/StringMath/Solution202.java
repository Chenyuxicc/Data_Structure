package com.chen.leetcode.StringMath;

import java.util.HashSet;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:18
 */
public class Solution202 {

    public static void main(String[] args) {
        int num = 19;
        HashSet<Integer> set = new HashSet<>();
        System.out.println(isHappy(num,set));
    }
    private static boolean isHappy(int num,HashSet<Integer> set){
        if(set.contains(num) && num != 1){
            return false;
        }
        if(num == 1){
            return true;
        }
        set.add(num);
        int result = 0;
        while (num != 0){
            int c = num % 10;
            result += c*c;
            num /= 10;
        }
        return isHappy(result,set);
    }
}

