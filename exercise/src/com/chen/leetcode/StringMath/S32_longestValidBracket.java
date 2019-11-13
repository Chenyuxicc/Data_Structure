package com.chen.leetcode.StringMath;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/13 on 11:49
 * leetcode:https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 描述：给定包含(和)的字符串，找出最长有效子字符串
 * 解法：使用栈，当前字符为(时，直接入栈，当前字符为)时，先弹出栈，如果此时栈为空，说明当前)已经没有
 * 与之匹配的(，是一个无效的),如果此时栈不为空，则说明)与之前弹出的栈顶元素是配对的，此时减去栈中还存在
 * 的元素下标即为当前值，并修改max
 **/
public class S32_longestValidBracket {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < sArray.length; i++) {
            if(stack.isEmpty()){
                stack.push(sArray[i]);
            }else if(stack.peek() == '(' && sArray[i] == ')'){
                stack.pop();
                count += 2;
            }else {
                stack.push(sArray[i]);
            }
        }
        return count;
    }
    public int longestValidParentheses1(String s){
        //这种写法没办法保存()()这种情况下的第一个(的位置，不能这么写
        //如果要保存第一个(的位置，但是这个(又必须弹出，只能记录其前面的位置，只能使用leetcode题解法
        Stack<Integer> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(sArray[i] == '('){
                stack.push(i);
            }else if(sArray[i] == ')' && !stack.isEmpty()){
                int tmp = stack.pop();
                max = Math.max(max,i-tmp+1);

            }
        }
        return max;
    }
    public int longestValidParentheses2(String s){
        Stack<Integer> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(sArray[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()))((())";
        S32_longestValidBracket s32_longestValidBracket = new S32_longestValidBracket();
        System.out.println(s32_longestValidBracket.longestValidParentheses1(s));
    }
}
