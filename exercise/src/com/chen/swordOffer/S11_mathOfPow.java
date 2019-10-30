package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/30 on 13:38
 **/
public class S11_mathOfPow {
    /**
     * 细节：
     * 1.exponent可能为负，base可能为0，要考虑参数的所有可能情况以及带来的代码上的变化
     * 2.判断base为0时，不能直接与0进行比较，要与一个很小的数进行比较，double类型的0就只是一个很小的数
     * 3.可以将复杂度降低到O(log(n)),考虑直接平方
     * 4.判断奇数偶数时可以使用与1按位与，除以2可以改成右移，位运算比除法和取余效率高
     */
    public double Power(double base, int exponent) {
        if(equal(base,0.0) && exponent <=0){
            return 0.0;
        }
        int absExponent = exponent;
        if(exponent<=0){
            absExponent = -exponent;
        }
        double result = pow(base,absExponent);
        if(exponent<0){
            return 1/result;
        }else {
            return result;
        }
    }
    private double pow(double base,int exponent){
        if(exponent==0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        //算exponent=exponent/2时的结果
        double result = pow(base,exponent>>1);
        //结果平方
        result *= result;
        //判断exponent奇偶
        if((exponent & 0x1) == 1){
            result *= base;
        }
        return result;

    }
    private static boolean equal(double a,double b){
        double n=a-b;
        if(n<0.000001&&n>-0.000001){
            return true;
        }else {
            return false;
        }
    }
}
