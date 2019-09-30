package com.chen.qiuzhaotest.wangyi2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/27 on 19:31
 **/
public class Solution2 {
    public static void main(String[] args) {
        char[] chars = {'A','S','D','F','G','H'};
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] arr = new String[count];

        for (int i = 0; i < count ; i++) {
            arr[i] = scanner.nextLine();
        }

    }
//    public static ArrayList<String> quanpai(int index,char[] keyBoard,ArrayList<String> result){
//        if(index == keyBoard.length){
//            StringBuffer sb = new StringBuffer("");
//            for (int i = 0; i < keyBoard.length; i++) {
//                sb.append(keyBoard[i]);
//            }
//            result.add(sb.toString());
//        }
//        for (int i = index; i < keyBoard.length; i++) {
//            swap(keyBoard,i,index);
//
//        }
//    }
    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
//    public static int[] cal(String[] arr){
//
//    }
}
