package com.chen.niukeLeetcode;

import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/6 on 20:38
 **/
public class Solution2 {
    /**
     * calculate the value of string array
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        for (int i = 0; i < tokens.length ; i++) {
            if("+".equals(tokens[i])){
                if(!stack.isEmpty()){
                    num1 = Integer.valueOf(stack.pop());
                    if(!stack.isEmpty()){
                        num2 = Integer.valueOf(stack.pop());
                    }
                    result = num1 + num2;
                    stack.push(result+"");
                }
            }
            else if("-".equals(tokens[i])){
                if(!stack.isEmpty()){
                    num1 = Integer.valueOf(stack.pop());
                    if(!stack.isEmpty()){
                        num2 = Integer.valueOf(stack.pop());
                    }
                    result = num2 - num1;
                    stack.push(result+"");
                }
            }
            else if("/".equals(tokens[i])){
                if(!stack.isEmpty()){
                    num1 = Integer.valueOf(stack.pop());
                    if(!stack.isEmpty()){
                        num2 = Integer.valueOf(stack.pop());
                    }
                    result = num2 / num1;
                    stack.push(result+"");
                }
            }
            else if("*".equals(tokens[i])){
                if(!stack.isEmpty()){
                    num1 = Integer.valueOf(stack.pop());
                    if(!stack.isEmpty()){
                        num2 = Integer.valueOf(stack.pop());
                    }
                    result = num2 * num1;
                    stack.push(result+"");
                }
            }
            else {
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.peek());
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] token1 = {"4","13","5","/","+"};
        System.out.println(solution2.evalRPN(token1));
    }
}
