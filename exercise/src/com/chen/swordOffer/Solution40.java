package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/18 on 20:21
 **/
public class Solution40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<2){
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int number = array[0];
        for (int i = 1; i <array.length ; i++) {
            number ^= array[i];
        }

        //find the index of the first number 1 from right
        //the reason why we find 1 rather than 0 because the xor result is 1 means the two numbers to xor is different which can identity the two numbers
        //we can find the number 1 through num&0x1
        int index = 0;
        while((number & 0x1) ==0){
            number >>= 1;
            index++;
        }
        //after we identity the two numbers we don't need to create new space to put the different parts
        //we can execute xor operation directly to get the number we need
        for (int i = 0; i <array.length ; i++) {
            if(((array[i]>>index)&0x1) == 1){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }

    }
    public static void main(String[] args) {
        int[] array = {1,2,5,2,7,1,5,8};
        int number = array[0];
        for (int i = 1; i <array.length ; i++) {
            number ^= array[i];
        }
        for (int i = 0; i <array.length; i++) {
            if((array[i]&0x1) == 0 ){
                System.out.println("array[i]"+i+":"+array[i]);
            }
        }
        System.out.println("异或结果:"+number);
    }
}
