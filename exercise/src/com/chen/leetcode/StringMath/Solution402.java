package com.chen.leetcode.StringMath;

import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-10:下午4:36
 */
public class Solution402 {

    public String removeKdigits(String num, int k) {
        //使用一个栈，保存递增的序列
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        if(k == num.length()){
            return "0";
        }
        for( ; i < num.length() ; i++){
            int var = num.charAt(i) - '0';
            //添加时要把比自己大的全pop出来
            while(!stack.isEmpty() && var < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(var);
        }
        //删掉一些数或者一个数都没有删掉之后，栈里的数都是递增的了
        while (k > 0){
            stack.pop();
            k--;
        }

        //使用一个StringBuffer存放栈里的元素，头插
        StringBuffer str = new StringBuffer();
        while (!stack.isEmpty()){
            str.insert(0,stack.pop());
        }
        i = 0;
        while (i < str.length() && str.charAt(i) == '0'){
            i++;
        }
        return str.length() - i > 0 ? str.substring(i) : "0";
    }
}
