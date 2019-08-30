package com.chen.qiuzhaotest.beike.lastyear;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/10 on 15:43
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length-1 ; i++) {
            num++;
            boolean condition1 = chars[i] >= 97 && chars[i] <= 122;
            boolean condition2 = chars[i] >= 65 && chars[i] <= 90;
            boolean condition3 = chars[i + 1] >= 97 && chars[i + 1] <= 122;
            boolean condition4 = chars[i + 1] >= 65 && chars[i + 1] <= 90;
            if(condition1 && condition4){
                num ++;
            }else if(condition2 && condition3){
                num++;
            }
        }
        num++;
        System.out.println(num);
        return;
    }
}
