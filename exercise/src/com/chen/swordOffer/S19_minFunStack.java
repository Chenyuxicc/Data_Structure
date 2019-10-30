package com.chen.swordOffer;

import java.util.Stack;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/3 on 14:47
 **/
/*
* 添加辅助栈，辅助栈里存放的原栈中从该位置开始到栈底这些元素里的最小值
* 每次出栈时，原栈和辅助栈同时出栈
* 可以通过一个变量存放整体当前最小值，就可以使用一个辅助栈来存放历史最小值
* 对时间复杂度有要求的，需要通过牺牲空间复杂度来达成
* */

public class S19_minFunStack {
    int min=0;
    Stack<Integer> stack=new Stack();
    Stack<Integer> stack1=new Stack();
    public void push(int node) {
        if(stack.isEmpty()){
            stack.push(node);
            min=node;
            stack1.push(min);
        }else{
            if(node<min){
                min=node;
            }
            stack.push(node);
            stack1.push(min);
        }
    }

    public void pop() {
       stack.pop();
       stack1.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
       return stack1.peek();
    }
}
