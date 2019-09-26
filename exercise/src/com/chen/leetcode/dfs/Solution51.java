package com.chen.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyuxi
 * @since 19-9-11:上午11:36
 */
public class Solution51 {
    /**
     * 存放每一行的皇后的列值
     */
    private int[] array;
    /**
     * 使用全局变量
     */
    private int n;
    /**
     * 存放结果
     */
    private static List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        array = new int[n];
        check(0);
        return result;
    }
    private void check(int cur){
        //cur为行值
        if(cur == n){
            List<String> arr = new ArrayList<>();
            //遍历每一列

            for (int i = 0; i < n; i++) {
                StringBuffer str = new StringBuffer("");
                for (int j = 0; j < n; j++) {
                    if(array[i] == j){
                        str.append("Q");
                    }else {
                        str.append(".");
                    }
                }
                arr.add(str.toString());
            }

            result.add(arr);
            return;
        }
        //使用i来表示列值
        //由于是循环，如果找到一个排列组合符合要求，只要循环的条件还没有结束，就还需要继续循环，去遍历接下来的其他列是否符号要求
        //结束的条件是循环结束
        for (int i = 0; i < n; i++) {
            array[cur] = i;
            //如果是可以放的位置，就放置下一行的皇后
            if(judge(cur)){
                check(cur + 1);
            }
        }

    }
    private boolean judge(int cur){
        //将cur和其之前行的皇后的位置进行对比，如果发现在同一列或者在对角线上，就返回false
        for (int i = 0; i < cur; i++) {
            //此时表示在同一列中
            //横坐标的差的绝对值和纵坐标的差的绝对值相同，表示在斜线上
            if(array[i] == array[cur] || Math.abs(cur - i) == Math.abs(array[cur] - array[i])){
                return false;
            }
        }
        //遍历完都没有发现cur存放的列的位置是合法的，返回true，寻找下一行的皇后应该在的位置
        return true;
    }

    public static void main(String[] args) {
        Solution51 s = new Solution51();
        s.solveNQueens(4);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
