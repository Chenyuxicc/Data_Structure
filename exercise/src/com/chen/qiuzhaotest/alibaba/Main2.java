package com.chen.qiuzhaotest.alibaba;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 19:48
 **/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main2 {
    static String getIndexAndLongest(String users,int k) {
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int max_Count = Integer.MIN_VALUE;
        for (int i = 0; i < users.length() ; i++) {
            int r = i+1;
            int l = i-1;
            if (users.charAt(i) == 'b'){
                int count = 0;
                while ((r >= users.length() ? r-users.length() : r) != (l<0?users.length()+l:l) &&users.charAt(r >= users.length() ? r-users.length() : r) == 'g' ){
                    count ++;
                    r++;
                }
                while ((r >= users.length() ? r-users.length() : r) != (l<0?users.length()+l:l) && users.charAt(l<0?users.length()+l:l) == 'g'){
                    count++;
                    l--;
                }
                if(count > max){
                    max = Math.max(max,count);
                    max_index = i;
                }
            }
        }
        for (int i = 0; i < users.length(); i++) {
            int r = i+1;
            if (users.charAt(i) == 'b'){
                int count = 3;
                int max_count = 0;
                while (count >= 0){
                    while (count >= 0 && users.charAt(r >= users.length() ? r-users.length() : r) == 'g'){
                        count--;
                        r++;
                    }
                    while (users.charAt(r >= users.length() ? r-users.length() : r) == 'b'){
                        max_count++;
                        r++;
                    }
                }
                if(max_count > max_Count){
                    max_Count = Math.max(max_Count,max_count);
                }
            }
        }
        return max_index+" " +max_Count;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int k = 0;
        try {
            _users = in.nextLine();
            k = Integer.valueOf(in.nextLine());
        } catch (Exception e) {
            _users = null;
        }
        res = getIndexAndLongest(_users,k);
        System.out.println(res);
    }
}
