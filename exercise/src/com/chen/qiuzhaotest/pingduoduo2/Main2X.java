package com.chen.qiuzhaotest.pingduoduo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 21:54
 **/
public class Main2X {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String ss[] = new String[2*n];
        for(int i=0;i<2*n;i++) {
            ss[i] = in.nextLine();
        }
        List<List<String>> collection = new ArrayList<>();
        for(int i=0;i<2*n;i=i+2) {
            List<String> list = new ArrayList<String>();
            dfs(ss[i],ss[i+1],"",list,"");
            collection.add(list);
        }
        for(List<String> list:collection) {
            System.out.println("{");
            for(int i=0;i<list.size();i++) {
                String string = list.get(i);
                for(int j=0;j<string.length();j++) {
                    if(j==string.length()-1) {
                        System.out.print(string.charAt(j)+"\n");
                    }else {
                        System.out.print(string.charAt(j)+" ");
                    }
                }
            }
            System.out.println("}");
        }

    }

    private static void dfs(String string, String string2, String newstring, List<String> list,String action) {
        // TODO Auto-generated method stub
        if(string.length()==0) {
            if(string2.equals(newstring)) {
                list.add(action);
            }
            return;
        }
        char left = string.charAt(0);
        string = string.substring(1);
        dfs(string, string2, newstring, list, action+"d");
        dfs(string, string2, left+newstring, list, action+"l");
        dfs(string, string2, newstring+left, list, action+"r");
    }

}
