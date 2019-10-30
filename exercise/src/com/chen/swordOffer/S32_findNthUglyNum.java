package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @Version 1.0
 * @Author ChenYuXi
 * @Date 2019/4/28 on 17:31
 **/
//把只含质因子的2、3、5的数称之为丑数，求第N个丑数，设1是第一个丑数
public class S32_findNthUglyNum {
    public int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(-1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        if(index<=arr.size()-1){
            return arr.get(index);
        }
        else{
            //判断每个数是不是丑数，复杂度太高
            while(arr.size()-1<=index){
                int length=arr.size()-1;
                int M=arr.get(length);
                int M2=0;
                int M3=0;
                int M5=0;
                for (int i = length; i >0 ; i--) {
                    //分别找到第一个最小的大于M的值
                    if(arr.get(i)*2>M&&arr.get(i-1)*2<=M){
                        M2=arr.get(i)*2;
                    }
                    if(arr.get(i)*3>M&&arr.get(i-1)*3<=M){
                        M3=arr.get(i)*3;
                    }
                    if(arr.get(i)*5>M&&arr.get(i-1)*5<=M){
                        M5=arr.get(i)*5;
                    }
                    if(M2!=0&&M3!=0&&M5!=0){
                        break;
                    }
                }
                if(M2<=M3&&M2<=M5){
                    M=M2;
                }
                if(M3<=M2&&M3<=M5){
                    M=M3;
                }
                if(M5<=M3&&M5<=M2){
                    M=M5;
                }
                arr.add(M);
            }
            return arr.get(index);
        }
    }
    public static void main(String[] args) {
        S32_findNthUglyNum s=new S32_findNthUglyNum();
        for (int i = 1; i <15 ; i++) {
            System.out.println(s.GetUglyNumber_Solution(i));
        }

    }
}
