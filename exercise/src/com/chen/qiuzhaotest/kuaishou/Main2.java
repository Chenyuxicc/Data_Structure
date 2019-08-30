package com.chen.qiuzhaotest.kuaishou;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/25 on 10:17
 **/


import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        in.nextLine();
        for(int i=0;i<num;i++){
            int t=in.nextInt();
            HashSet<Integer> hashset=new HashSet<>();
            if(result(t,hashset)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }

        }
    }
    private static boolean result(int num, HashSet<Integer> set) {
        if(set.contains(num)&&num!=1){
            return false;
        }
        if(num==1){
            return true;
        }
        set.add(num);
        int result =0;
        while(num!=0){
            int temp =num % 10;
            num = num/10;
            result = result + temp * temp;
        }
        return result(result,set);
    }
}