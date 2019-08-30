package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/22 on 10:05
 **/
public class Solution49 {
    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        int [] strToInt = new int[length];
        int decimal = 1;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if(i == 0){
                if(chars[0] == 45){
                    strToInt[0] = 45;
                }else if(chars[0] == 43){
                    strToInt[0] = 43;
                }else if(chars[0] >= 48 && chars[0] <= 57){
                    strToInt[0] = chars[0] - 48;
                }else {
                    return 0;
                }
            }else {
                if(chars[i] >= 48 && chars[i] <= 57){
                    strToInt[i] = chars[i] - 48;
                }else {
                    return 0;
                }
            }
        }
        for (int i = length-1; i >= 1 ; i--) {
            result += strToInt[i] * decimal;
            decimal *= 10;
        }
        if(strToInt[0] == 45){
            result = -result;
        }else if(strToInt[0] >= 0 && strToInt[0] <= 9){
            result += strToInt[0] * decimal;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.StrToInt("123"));
    }
}
