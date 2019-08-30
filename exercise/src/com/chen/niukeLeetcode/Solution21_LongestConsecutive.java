package com.chen.niukeLeetcode;

import java.util.HashSet;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/2 on 14:59
 **/
public class Solution21_LongestConsecutive {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>(num.length);
        for (int n : num) {
            set.add(n);
        }
        int max = 1;
        for (int n : num) {
            System.out.println("n:"+n);
            if(set.remove(n)){
                int sum = 1;
                int val = n;
                int small_val = val - 1;
                int big_val = val + 1;
                while (set.remove(small_val)){
                    sum++;
                    small_val--;
                }
                while (set.remove(big_val)){
                    sum++;
                    big_val++;
                }
                max = max > sum ? max : sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] sum = {100,4,200,1,2,3};
        Solution21_LongestConsecutive solution21_longestConsecutive = new Solution21_LongestConsecutive();
        System.out.println(solution21_longestConsecutive.longestConsecutive(sum));
    }
}
