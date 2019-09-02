package com.chen.leetcode.StringMath;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:18
 */
public class Solution8 {
    public static int myAtoi(String str) {
        if(str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int i = 0;
        boolean flag = false;
        int result = 0;
        while (i < chars.length && chars[i] == ' '){
            i++;
        }
        if(i < chars.length && (chars[i] == '-' || chars[i] == '+')) {
            if(chars[i] == '-'){
                flag = true;
            }
            i++;
        }
        for (; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                int t = chars[i] - '0';
                if(flag && (-result < Integer.MIN_VALUE/10 ||(-result == Integer.MIN_VALUE/10 && t >= 8) )){
                    return Integer.MIN_VALUE;
                }
                if(!flag && (result > Integer.MAX_VALUE / 10 ||(result == Integer.MAX_VALUE/10 && t>=7))){
                    System.out.println("进来了");
                    return Integer.MAX_VALUE;
                }
                result = result * 10 + t;
                System.out.println("result:"+result);
            }else{
                break;
            }
        }
        return flag ? -result : result;
    }

    public static void main(String[] args) {
        String s = "-2147483647";
        System.out.println(myAtoi(s));
    }
}
