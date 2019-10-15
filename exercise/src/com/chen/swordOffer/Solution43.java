package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/20 on 10:43
 **/
public class Solution43 {
    /**
     * input a string output result of this string cyclic left shift
     *
     */
    public String LeftRotateString(String str,int n) {
        if(str.isEmpty()){
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < n ; i++) {
            stringBuffer.append(str.charAt(i));
        }
        stringBuffer.delete(0,n);
        return stringBuffer.toString();
    }
    /**
     * reverse the array of str three times
     */
    public String LeftRotateString1(String str,int n){
        if(str.isEmpty()){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,chars.length-1-n);
        reverse(chars,chars.length-n,chars.length-1);
        return new String(chars);
    }
    private void reverse(char[] chars,int begin,int end){
        while(begin<end){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.LeftRotateString("abcXYZdef",3));
    }
}
