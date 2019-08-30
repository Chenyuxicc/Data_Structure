package com.chen.leetcode.StringMath;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/30 on 11:52
 **/
public class Solution12 {
    public String intToRoman(int num) {
        int n = num;
        StringBuffer sb = new StringBuffer("");
        while (n >= 1000){
            sb.append("M");
            n -= 1000;
        }
        while (n >= 900){
            sb.append("CM");
            n -= 900;
        }
        while (n >= 500){
            sb.append("D");
            n -= 500;
        }
        while (n >= 400){
            sb.append("CD");
            n -= 400;
        }
        while (n >= 100){
            sb.append("C");
            n -= 100;
        }
        while (n >= 90){
            sb.append("XV");
            n -= 90;
        }
        while (n >= 50){
            sb.append("L");
            n -= 50;
        }
        while (n >= 40){
            sb.append("XL");
            n -= 40;
        }
        while (n >= 10){
            sb.append("X");
            n -= 10;
        }
        while (n >= 9){
            sb.append("IX");
            n -= 9;
        }
        while (n >= 5){
            sb.append("V");
            n -= 5;
        }
        while (n >= 4){
            sb.append("IV");
            n -= 4;
        }
        while (n >= 1){
            sb.append("I");
            n -= 1;
        }
        return sb.toString();
    }
}
