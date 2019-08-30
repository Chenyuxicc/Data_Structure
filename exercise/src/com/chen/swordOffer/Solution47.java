package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/21 on 14:42
 **/
public class Solution47 {
    /**
     * calculate the value of sum
     */
    public int Sum_Solution(int n) {
        int number = n;
        boolean result = number>0 && (number += Sum_Solution(n-1)) > 0;
        return number;
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.Sum_Solution(5));
    }
}
