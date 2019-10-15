package com.chen.leetcode.StringMath;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:17
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        StringBuffer sb = new StringBuffer("");
        char[] chars = s.toCharArray();
        if(numRows == 1){
            return s;
        }
        int h1 = numRows*2 - 2;
        int t1 = (int) Math.ceil(s.length()/(h1*1.0));
        StringBuffer[] temp = new StringBuffer[t1];
        for (int i = 0; i < t1; i++) {
            StringBuffer stringBuffer = new StringBuffer("");
            temp[i] = stringBuffer;
        }
        for (int i = 0; i < s.length() ; i++) {
            temp[i/h1].append(chars[i]);
        }
        for (int i = 0; i < numRows ; i++) {
            for (int j = 0; j < t1; j++) {
                if(i == 0){
                    sb.append(temp[j].charAt(i));
                }else {
                    if(i < temp[j].length()){
                        sb.append(temp[j].charAt(i));
                    }
                    if(temp[j].length() > (i + h1-i*2) && i != numRows-1){
                        sb.append(temp[j].charAt(i + h1-i*2));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s,2));
    }
}
