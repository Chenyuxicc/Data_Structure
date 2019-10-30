package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @Version 1.0
 * @Author ChenYuXi
 * @Date 2019/4/26 on 10:58
 **/
//把数组排成最小的数
public class S31_permutationNum {
    //使用快排，定义一种新的两个数比较的方式.数m数n，定义mn为这两个数转为字符串的连接
    //如果mn>nm则称m大于n,以此作为排序的标准
    public String PrintMinNumber(int [] numbers) {
        numbers=partition(numbers,0,numbers.length-1);
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <numbers.length ; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
    public int[] partition(int [] numbers,int left,int right){
        if(right>numbers.length-1||left>right){
            return numbers;
        }
        int privot=numbers[left];
        int i=left;
        int j=right;
        while(i<j){
            while(Compare(numbers[j],privot)&&i<j){
                j--;
            }
            numbers[i]=numbers[j];
            while (Compare(privot,numbers[i])&&i<j){
                i++;
            }
            numbers[j]=numbers[i];
        }
        numbers[i]=privot;
        partition(numbers,left,i-1);
        partition(numbers,i+1,right);
        return numbers;
    }

    public boolean Compare(int a,int b){
        String abs=a+""+b;
        String bas=b+""+a;
        if(abs.compareTo(bas)>=0){
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        int [] a={321,32,3};
//        com.chen.swordOffer.S31_permutationNum s=new com.chen.swordOffer.S31_permutationNum();
//        System.out.println(s.PrintMinNumber(a));
//    }
}
