package com.chen.leetcode.stack;

import java.util.Stack;

/**
 * @author chenyuxi
 * @since 19-9-5:上午10:34
 */
public class StackSort {
    /**
     * 辅助栈，每次从原栈放数据到辅助栈时先判断该数据是不是大于辅助栈的栈顶元素
     * 如果大于直接压入，否则弹出辅助栈中的元素放入原栈，直到辅助栈空，或者该数
     * 大于辅助栈栈顶元素，最后将辅助栈中数据放入原栈中
     */
    private static void stackSort(Stack<Integer> stack){
        Stack<Integer> stackHelp = new Stack<>();
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if(stackHelp.isEmpty()){
                stackHelp.push(temp);
            }else {
                while (!stackHelp.isEmpty() && stackHelp.peek() > temp){
                    stack.push(stackHelp.pop());
                }
                stackHelp.push(temp);
            }
        }
        while (!stackHelp.isEmpty()){
            stack.push(stackHelp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(6);
        stackSort(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
