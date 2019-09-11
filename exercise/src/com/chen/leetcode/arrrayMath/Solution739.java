package com.chen.leetcode.arrrayMath;

import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-11:下午5:22
 */
public class Solution739 {
    /**
     * 找出数组中第一个比其大的数，组成新的数组
     */
    public int[] dailyTemperatures(int[] T) {
        //使用辅助栈，里面存放还未找到第一个比起大的元素的下标
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if(i == 0 || stack.isEmpty()){
                stack.push(i);
            }else {
                //使用while有可能现在出现的这个元素是好几个元素第一个大的值，一直要弹出直到栈空，或者遇到比他大的元素
                while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                    int index = stack.pop();
                    //leetcode上要求的是需要等待多久才能遇到第一个比起大的数
                    result[index] = i - index;
                    //如果需要存放的是第一个比起大的数，直接写result[index] = T[i];
                }
                stack.push(i);
            }
        }
        return result;
    }
}
