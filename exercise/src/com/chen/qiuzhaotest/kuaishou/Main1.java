package com.chen.qiuzhaotest.kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/25 on 9:15
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        boolean[] result = new boolean[num];
        for (int i = 0; i < num; i++) {
            String[] temp = scanner.nextLine().trim().split(" ");
            String[] t1 = temp[0].split("[.]");
            String[] t2 = temp[1].split("[.]");
            result[i] = isUP(t1,t2);
        }
        for (int i = 0; i < num ; i++) {
            System.out.println(result[i]);
        }
    }
    public static boolean isUP(String[] t1,String[] t2){
        int length = t1.length < t2.length ? t1.length : t2.length;
        int j = 0;
        for ( ; j < length ; j++) {
            if(Integer.parseInt(t1[j]) > Integer.parseInt(t2[j])){
                return false;
            }else if(Integer.parseInt(t1[j]) < Integer.parseInt(t2[j])){
                return true;
            }else {
                continue;
            }
        }
        if(t2.length > t1.length){
            while (j < t2.length){
                if(Integer.parseInt(t2[j]) != 0){
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
