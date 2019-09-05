package com.chen.qiuzhaotest.xiecheng;

import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/4 on 21:00
 **/
public class MainTest {
    public static void main(String[] args) {
        String s = "(a(bcd)";
        System.out.println(resolve(s));
    }
    static String resolve(String expr) {
        Stack<Character> stack  = new Stack<>();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < expr.length(); i++) {
            if(')' == expr.charAt(i)){
                System.out.println(i);
                s = s.reverse();
                while (!stack.isEmpty() && '(' != stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    return "";
                }
            }else {
                if((')'!=expr.charAt(i))&& '(' != expr.charAt(i)){
                    s.append(expr.charAt(i));
                    System.out.println(expr.charAt(i));
                }
                stack.push(expr.charAt(i));
            }

        }
        if(stack.isEmpty()){
            return s.toString();
        }else {
            return "";
        }
    }

}
