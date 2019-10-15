package com.chen.qiuzhaotest.byteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/11 on 19:30
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int[] arr = new int[s.length()];
        int[] arrOrigin = new int[num];
        for (int i = 0; i < s.length() ; i++) {
            arr[i] = Integer.valueOf(s.charAt(i)+"");
        }
        arrOrigin[0] = arr[0];
        int temp = 0;
        for (int i = 1; i < num ; i++) {
            if(i < k){
                temp = arrOrigin[0];
                for (int j = 1; j < k ; j++) {
                    temp = temp ^ arrOrigin[j];
                }
            }else {
                temp = arrOrigin[i-k+1];
                for (int j = i-k+2; j < i+1 ; j++) {
                    temp = temp ^ arrOrigin[j];
                }
            }
            temp = temp ^ arr[i];
            arrOrigin[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num ; i++) {
            sb.append(arrOrigin[i]);
        }
        System.out.println(sb.toString());
    }
}
