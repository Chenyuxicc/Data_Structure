package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/21 on 15:13
 **/
public class S17_print1toMax {
    public void print1ToMax(int n){
        if(n <= 0){
            System.out.println("n无意义");
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while (!incrementNumber(number)){

        }
    }
    //自加方法
    private boolean incrementNumber(char[] number){
        boolean isOverFlow = false;
        //进位标志位
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0 ; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if(i == nLength - 1){
                nSum++;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverFlow = true;
                    break;
                }else {
                    nTakeOver = 1;
                    nSum -= 10;
                    number[i] = (char)('0' + nSum);
                }
            }else {
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }
}
