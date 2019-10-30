package com.chen.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/30 on 16:49
 * 题：给出括号对数，输出所有有效的括号组成的字符串
 **/
public class S22_generateBrackets {
    /**
     * 优解：回溯法
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list,"",0,0,n);
        return list;
    }
    public void dfs(List<String> list,String s , int open , int closed , int max){
        if(s.length() == max * 2){
            list.add(s);
            return;
        }
        if(open < max){
            dfs(list,s + "(" ,open + 1 , closed , max);
        }
        //使用closed < open 来控制右括号的位置，从而保证有效性
        //有效时：右括号出现的数量一定小于等于前面左括号的数量
        if(closed < open){
            dfs(list,s + ")" , open , closed + 1 , max);
        }
    }

    public static void main(String[] args) {
        S22_generateBrackets sss = new S22_generateBrackets();
        List<String> result = sss.generateParenthesis(3);
        System.out.println(result.size());
    }
}
