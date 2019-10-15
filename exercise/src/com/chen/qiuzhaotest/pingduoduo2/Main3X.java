package com.chen.qiuzhaotest.pingduoduo2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/2 on 13:16
 **/
public class Main3X {
    /**
     * 先对数组进行排序，取一个max为当前最大值，max每次循环之后减一因为max的取值就是[1,Max{ni}]
     * 算每一个最大值max的概率时，分母就是大于等于max的n相乘
     * 分子是等于max的相乘，相乘的次数为大于等于max的n的个数，表示这些n取到max的所有情况
     * 再减去每一个骰子取到max-1的情况相乘
     * 不考虑比当前max小的骰子的取值情况，因为都可能取到
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        Arrays.sort(a);
        int max=a[n-1];
        double rs=0;
        while(max>0){
            double p=1;
            double fenzi=1;
            double fenmu=1;
            double fenzi1=1;
            int k=n-1;
            while(k>=0&&a[k]>=max){
                fenmu*=a[k];
                fenzi*=(max-1);//no max
                fenzi1*=max;
                k--;
            }
            rs+=((fenzi1-fenzi)/fenmu)*max;
            max--;
        }

        System.out.printf("%.2f",rs);
    }
}
