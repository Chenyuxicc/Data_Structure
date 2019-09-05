package com.chen.leetcode.arrrayMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/14 on 21:06
 **/

import java.util.HashSet;

/**
 * input:[100,4,200,1,3,2]
 * output:4
 * explain:最长连续序列是[1,2,3,4]，其长度为4
 */
public class LongestSubSeq128 {
    //使用HashSet
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestSubSeq = 1;
        for (int num : nums){
            int curSubSeq = 1;
            int temp = num;
            if(set.remove(num)){
                while (set.remove(num+1)){
                    num++;
                }
                curSubSeq += num - temp;
                num = temp;
                while (set.remove(num-1)){
                    num--;
                }
                curSubSeq += temp - num;
                longestSubSeq = Math.max(longestSubSeq,curSubSeq);
            }

        }
        return longestSubSeq;
    }
}
