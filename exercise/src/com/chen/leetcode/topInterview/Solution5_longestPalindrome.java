package com.chen.leetcode.topInterview;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/9 on 17:26
 **/
public class Solution5_longestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int maxLength = -1;
        String str = null;
        if(s.length() == 1){
            return s;
        }
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 0; i < s.length()-1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                int k = tmp1/2;
                tmp1 = isParlindrome(s,i,i-k,i+k+1,true);
                while ( tmp1 != -1){
                    str = tmp1 > maxLength ?  s.substring(i-k,i+k+2) : str;
                    maxLength = Math.max(maxLength,tmp1);
                    k ++ ;
                    tmp1 = isParlindrome(s,i,i-k,i+k+1,true);
                }
            }
            int m = tmp2/2;
            tmp2 = isParlindrome(s,i,i-m,i+m,false);
            while (tmp2 != -1){
                str = tmp2 > maxLength ?  s.substring(i-m,i+m+1) : str;
                maxLength = Math.max(maxLength,tmp2);
                m ++;
                tmp2 = isParlindrome(s,i,i-m,i+m,false);

            }
        }
        return str;

    }
    public String longestPalindrome1(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        if(len == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        String result = "";
        for (int i = 0; i < len-1 ; i++) {
            if(chars[i] == chars[i+1]){
                /**
                 *回文函数里已经判断过长度了
                 */
                result = isParlindrome1(chars, i ,i+1 ,result);
            }
            result = isParlindrome1(chars,i,i,result);
        }
        return result;
    }
    //只判断一个字串是否为回文字串
    public int isParlindrome(String s,int k,int left,int right,boolean same){
        if(left < 0 || right > s.length() - 1){
            return -1;
        }
        if(!same){
            for (int i = left,j = right ; i <= k && j >= k ; i++,j--) {
                if(s.charAt(i) != s.charAt(j)){
                    return -1;
                }
            }
        }else {
            for (int i = left,j=right; i <= k && j >= k+1 ; i++,j--) {
                if(s.charAt(i) != s.charAt(j)){
                    return -1;
                }
            }
        }
        return right-left+1;
    }

    //将以该字符为中心最大的回文字串返回
    public String isParlindrome1(char[] s , int i , int j , String longest){
        while (i >= 0 && j < s.length && s[i] == s[j]){
            i--;
            j++;
        }
        int length = j-1 - (i+1) + 1;
        if(length > longest.length()){
            //String.valueOf(char[] s,int offset,int count)count就是字串的长度
            return String.valueOf(s,i+1,length);
        }
        return longest;
    }
    public static void main(String[] args) {
        String s = "ccc";
        String s1 = "annc";
        String s3 = "a";
        Solution5_longestPalindrome solution5 = new Solution5_longestPalindrome();
//        System.out.println("s:"+solution5.isParlindrome(s,3,0,6,false));
//        System.out.println("s1:"+solution5.isParlindrome(s1,2,0,5,true));
        System.out.println("s:"+solution5.longestPalindrome1(s));
        System.out.println("s1:"+solution5.longestPalindrome1(s1));
    }
}
