package com.chen.leetcode.arraydoublepointers;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:11
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length ; i++) {
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max,Math.abs((i-j)*Math.min(height[j] ,height[i])));
            }
        }
        return max;
    }
}
