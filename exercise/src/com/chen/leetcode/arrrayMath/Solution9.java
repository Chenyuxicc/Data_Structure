package com.chen.leetcode.arrrayMath;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:12
 */
public class Solution9 {
    public static boolean isPalindrome(int x) {
        String temp = x+"";
        int n = temp.length();
        int[] nums = new int[n];
        int i = 0;
        if(x < 0){
            return false;
        }
        while (x != 0){
            int c = x % 10;
            nums[i] = c;
            x /= 10;
            i++;
        }
        for (int j = 0; j < n ; j++) {
            if(nums[j] != nums[n-j-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t = 121;
        int t1 = -121;
        System.out.println(isPalindrome(t));
        System.out.println(isPalindrome(t1));
    }
}
