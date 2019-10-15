package com.chen.leetcode.dfs;

import java.util.ArrayList;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/24 on 16:31
 **/
public class AllSubStringPar {
    /**
     * 获取一个字符串的所有回文子字符串，使用dfs和回溯做
     * https://blog.csdn.net/zuochao_2013/article/details/80673207
     */
    public ArrayList<ArrayList<String>> getAllSubString(String s){
        //存放最后的结果
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        //在遍历的过程中使用的list
        ArrayList<String> list = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }
        dfs(s,0,list,result);
        return result;

    }
    private void dfs(String s,int index,ArrayList<String> preList,ArrayList<ArrayList<String>> result){
        //出口条件，遍历到字符串最后之后，就返回，并将完整的preList放入result中
        if(index == s.length()){
            System.out.println(preList.size());
            result.add(new ArrayList<>(preList ));
            return;
        }
        //使用不同的list
        ArrayList<String> arr = new ArrayList<>(preList);
        for (int i = index; i < s.length(); i++) {
            if(isPar(s,index,i)){
                arr.add(s.substring(index,i+1));
                dfs(s,i+1,arr,result);
                arr.remove(arr.size() - 1);
            }
        }

    }
    private boolean isPar(String s,int start,int end){
        while (start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaab";
        AllSubStringPar allSubStringPar = new AllSubStringPar();
        System.out.println(allSubStringPar.getAllSubString(s));
    }
}
