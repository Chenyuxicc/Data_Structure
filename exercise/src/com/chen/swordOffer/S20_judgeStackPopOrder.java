package com.chen.swordOffer;

import java.util.Stack;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/12 on 21:15
 **/
//输入入栈顺序和出栈顺序，判断出栈顺序有没有可能存在
public class S20_judgeStackPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null||popA==null){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        int index=0;
        for (int i = 0; i <pushA.length ; i++) {
            //先push，再判断
            stack.push(pushA[i]);
            while(!stack.isEmpty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,3,2,1};
        int[] popB={4,3,5,1,2};
        System.out.println("可不可能为A的出栈顺序:"+IsPopOrder(pushA,popA));
        System.out.println("可不可能为A的出栈顺序:"+IsPopOrder(pushA,popB));
    }
}
