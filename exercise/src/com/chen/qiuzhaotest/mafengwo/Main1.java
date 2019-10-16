package com.chen.qiuzhaotest.mafengwo;

import com.chen.qiuzhaotest.didi.Main;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/15 on 19:17
 **/
public class Main1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public int push(int num){
        return stack1.push(num);
    }
    public int pop(){
        if (stack2.isEmpty() && !stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else if(!stack2.isEmpty()){
            return stack2.pop();
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Main1 list = new Main1();
        list.push(1);
        list.push(2);
        System.out.println(list.pop());
        list.push(3);
        list.push(4);
        System.out.println(list.pop());
        list.push(5);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());

    }
}
