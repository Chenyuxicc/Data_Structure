package com.chen.leetcode.StringMath;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:18
 */
public class Solution7 {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0){
            int t = x % 10;
            x /= 10;
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && t >7)) {
                return 0;
            }
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && t < -8)){
                return 0;
            }
            result = result * 10 + t;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 1534236469;
        System.out.println(reverse(num));
    }
}
