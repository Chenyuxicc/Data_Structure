package com.chen.qiuzhaotest.xiecheng;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/4 on 20:14
 **/
public class Main2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack  = new Stack<>();
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < expr.length(); i++) {
            if(")".equals(expr.charAt(i))){
                StringBuilder temp = new StringBuilder("");
                reverse(s,temp);
                while (!"(".equals(stack.peek())){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    return "";
                }
            }
            if((!")".equals(expr.charAt(i)) )&& (!"(".equals(expr.charAt(i)))){
                s.append(expr.charAt(i));
            }
            stack.push(expr.charAt(i));
        }
        return s.toString();
    }
    static void reverse(StringBuilder s,StringBuilder temp){
        for (int i = s.length()-1; i >= 0; i--) {
            temp.append(s.charAt(i));
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
