package com.chen.leetcode.stack;

import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/30 on 16:15
 * 题：判断一串字符串是否是有效字符串
 **/
public class S20_validBrackets {
    /**
     * 使用栈，注意弹出的时机
     */
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                stack.push(array[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (array[i]) {
                    case ')':
                        if (stack.peek() != '(') {
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;
                    case ']':
                        if (stack.peek() != '[') {
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;
                    case '}':
                        if (stack.peek() != '{') {
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        S20_validBrackets so = new S20_validBrackets();
        so.isValid(s);
    }
}
