package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/18 on 10:07
 **/
public class S15_numOf1 {
    public int NumberOf1(int n){
        //思路2，使用1去按位与，再移动1的位置
        int count = 0;
        int one = 1;
        for (int i = 0; i < 32; i++) {
            if((n & one) != 0){
                count ++;
            }
            one = one << 1;
        }
        return count;
    }
    //思路3，和其-1后的结果按位与
    public int NumberOf12(int n){
        int count = 0;
        while (n != 0){
            n = (n & n-1);
            count++;
        }
        return count;
    }
}
