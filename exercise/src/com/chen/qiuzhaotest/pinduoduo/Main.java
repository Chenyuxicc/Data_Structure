package com.chen.qiuzhaotest.pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/28 on 15:14
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = null;
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int temp = 0;
        int temp1 = 0;
        if (in.hasNextLine()){
            s1 = in.nextLine();
            String[] s = s1.split(" ");
            for (int i = 0; i < s.length ; i++) {
                A.add(Integer.valueOf(s[i]));
            }
        }
        if (in.hasNextLine()){
            s1 = in.nextLine();
            String[] s = s1.split(" ");
            for (int i = 0; i < s.length ; i++) {
               B.add(Integer.valueOf(s[i]));
            }
        }
        if(A.size() == 0 || B.size() == 0){
            System.out.println("NO");
            return;
        }
        if(A.size() == 1){
            for (int i = 0; i < B.size() ; i++) {
                if(max < B.get(i)){
                    max = B.get(i);
                }
            }
            A.add(max);
            A.remove(0);
            System.out.println(A.get(0));
            return;
        }
        System.out.println("true");
        for (int i = 0; i < A.size() - 1 ; i++) {
            if(A.get(i) >= A.get(i+1)){
                temp = i;
                temp1 = i+1;
                //替换A[i]
                for (int j = 0; j < B.size() ; j++) {
                    if(i == 0){
                        if(B.get(j) < A.get(i+1)){
                            if(B.get(j) > max){
                                max = B.get(j);
                            }
                        }
                    }else {
                        if(B.get(j) > A.get(i-1) && B.get(j) < A.get(i+1)){
                            if(B.get(j) > max){
                                max = B.get(j);
                            }
                        }
                    }
                }
                for (int j = 0; j < B.size(); j++) {
                    if(i == A.size() - 2){
                        if(B.get(j) > A.get(i)){
                            if(B.get(j) > max1){
                                max1 = B.get(j);
                            }
                        }
                    }else {
                        if(B.get(j) > A.get(i) && B.get(j) < A.get(i + 2)){
                            if(B.get(j) > max1){
                                max1 = B.get(j);
                            }
                        }
                    }
                }
                break;
            }
        }
        if(max == max1 && max == Integer.MIN_VALUE){
            System.out.println("NO");
            return;
        }
        if(max > max1){
            A.add(temp,max);
            A.remove(temp+1);
        }else if(max < max1){
            A.add(temp1,max1);
            A.remove(temp1+1);
        }else {
            A.add(temp,max);
            A.remove(temp+1);
        }
        for (int i = 0; i <A.size() ; i++) {
            if(i == A.size() - 1){
                System.out.println(A.get(i));
            }else {
                System.out.print(A.get(i) + " ");
            }
        }
    }
}
