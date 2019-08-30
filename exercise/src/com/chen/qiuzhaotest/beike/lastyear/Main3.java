package com.chen.qiuzhaotest.beike.lastyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 15:51
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.valueOf(in.nextLine());
        for (int i = num+1; i <= 9000 ; i++) {
            if(isBeautiful(i)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
        return;

    }
    public static boolean isBeautiful(int n){
        int temp = n;
        HashSet<Integer> set = new HashSet<>();
        while (temp != 0){
            int t = temp % 10;
            if(set.contains(t)){
                return false;
            }else {
                set.add(t);
            }
            temp = (temp - t) / 10;
        }
        return true;
    }
}
