package com.chen.leetcode.math;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/5 on 9:20
 **/
public class S29_divide {
//    public static int divide(int dividend, int divisor) {
//        boolean flag1 = dividend < 0;
//        boolean flag2 = divisor < 0;
//
//        boolean flag = flag1 ^ flag2;
//        long dividengLong = dividend;
//        long divisorLong = divisor;
//
//        long t = 0;
//        if(flag1){
//           dividengLong = -dividengLong;
//        }
//        if(flag2){
//            divisorLong = -divisorLong;
//        }
//        long m = divisorLong;
//        while (divisorLong <= dividengLong){
//            divisorLong += m;
//            t++;
//        }
//        if(flag){
//            return -t;
//        }else {
//            return t;
//        }
//    }
    public static int divide1(int dividend , int divisor){
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }
        while (dividend <= divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)){
                //-1073741824 等于MIN_VALUE/2时便结束
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                //左移/乘以2的次数
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        //全正/全负 result一直为负数
        if(!sign){
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide1(10,3));
//        System.out.println(Integer.MIN_VALUE >> 1);
//        System.out.println(-1 << 1);
//        System.out.println(-1 << 31);
    }
}
