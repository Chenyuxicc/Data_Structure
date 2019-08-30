package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/26 on 9:24
 **/
public class Solution18_parlindromeSubstringii {
    //递归
    public int minCut(String s) {
        if(isParlindrome(s)){
            return 0;
        }
        int min = s.length()-1;
        for (int i = 1; i < s.length(); i++) {
            int a = minCut(s.substring(0,i));
            int b = minCut(s.substring(i));
            a = a+b+1;
            min = min > a ? a : min;
        }
        return min;
    }
    public boolean isParlindrome(String str){
        if(str == null || str.length() == 0){
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0,j = chars.length-1; i < j ; i++,j--) {
            if(chars[i] != chars[j]){
                return false;
            }
        }

        return true;
    }
    private static int[][] f = new int[1000][1000];
    //迭代
    public int minCut1(String s){
        for(int t = 0 ; t < s.length() ; t++){
            for (int i = 0 , j = t ; j < s.length(); i++ ,j++){
                f[i][j] = compCut(s,i,j);
            }
        }
        return f[0][s.length()-1];
    }
    private int compCut(String s,int i ,int j){
        if(isParlindrome(s.substring(i,j+1))){
            return 0;
        }
        int min = s.length();
        for (int k = i; k <j ; k++) {
            int a = f[i][k];
            int b = f[k+1][j];
            a = a+b+1;
            min = min > a ? a : min;
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "aabcbdbddbdaac";
        Solution18_parlindromeSubstringii solution18 = new Solution18_parlindromeSubstringii();
        System.out.println("min:"+solution18.minCut1(s));
    }

}
