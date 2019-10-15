package com.chen.qiuzhaotest.pingduoduo2;

import java.util.ArrayList;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 21:17
 **/
public class Main2 {
    static ArrayList<String> arrayList = new ArrayList<>();
    static String[] strs = {"l","r","d"};
    public static void main(String[] args) {
        String A = "123";
        String B = "321";
        dfs("",A,B,"");
        for (String s:arrayList) {
            System.out.println(s);
        }

    }
    private static void dfs(String newStr,String A,String B,String actions){
        if(A.length() == 0 ){
            if(newStr.equals(B)){
                arrayList.add(actions);
            }
            return ;
        }
        char t = A.charAt(0);
        A = A.substring(1);
        dfs(newStr+t,A,B,actions+"r");
        dfs(t+newStr,A,B,actions+"l");
        dfs(newStr,A,B,actions+"d");
    }
}
