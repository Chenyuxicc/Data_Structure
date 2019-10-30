package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @ Version 1.0
 * @ Author ChenYuXi
 * @ Date 2019/4/25 on 21:43
 **/
public class S30_numOf1In1toN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int num=0;
        for (int i = 1; i <=n ; i++) {
            num+=NumOfOne(i);
        }
        return num;
    }
    public static int NumOfOne(int num){
        ArrayList<Integer> arr=new ArrayList<>();
        int n=0;
        int sys=10;
        while(num!=0){
            arr.add(num%10);
            num=num/10;
        }
        for (int i = 0; i <arr.size() ; i++) {
            if(arr.get(i)==1){
              n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(12));
    }
}
