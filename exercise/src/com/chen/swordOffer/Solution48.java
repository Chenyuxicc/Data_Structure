package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/21 on 15:12
 **/
public class Solution48 {
    public int Add(int num1,int num2) {
        while (num2 != 0){
            System.out.println("--------------");
            int sum = num1 ^ num2;
            System.out.println("sum:"+sum);
            int carry = num1 & num2;
            System.out.println("carry:"+carry);
            carry <<= 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        System.out.println(solution48.Add(-5,7));
        //System.out.println(-5&-7);
    }
}
