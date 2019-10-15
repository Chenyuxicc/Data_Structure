package com.chen.leetcode.topInterview;
import com.chen.swordOffer.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/10 on 12:50
 **/
public class Solution6_isMatch {
    public boolean isMatch(String s, String p) {
        if(s == null || s.length() == 1&&!".".equals(p)){
            return false;
        }
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        int i = 0,j=0;
        while (i<schar.length && j < pchar.length){
            if(pchar[j] == '.' && j+1 < pchar.length && pchar[j+1] == '*'){
                return true;
            }else if(schar[i] == pchar[j] && j+1 <pchar.length && pchar[j+1] == '*'){
               if(i+1 < schar.length && schar[i+1] == schar[i]){
                   i++;
               }else{
                   i++;
                   j += 2;
               }
            }else if(schar[i] == pchar[j] || pchar[j] == '.'){
                i++;
                j++;
            }else if(schar[i] != pchar[j] && j+1 <pchar.length && pchar[j+1] == '*'){
                i++;
                j += 2;
            }else {
                return false;
            }

        }
        return i == schar.length && j == pchar.length;
    }
    public boolean isMatch1(String s, String p){
        int strIndex = 0;
        int patternIndex = 0;
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        return isMatch2(sChar,pChar,strIndex,patternIndex);
    }
    private boolean isMatch2(char[] sChar,char[] pChar,int strIndex,int patternIndex){
        if(sChar.length == strIndex && pChar.length == patternIndex){
            return true;
        }
        //后面每次都会判断sChar.length == strlength 如果相等就会最后返回false因此不必在此判断str先遍历完成的情况
        if(sChar.length != strIndex && pChar.length == patternIndex){
            return false;
        }
        //第二个字符为*的情况
        if(patternIndex + 1 < pChar.length && pChar[patternIndex+1] == '*'){
            //第一个字符匹配的情况下
            //三种情况分别为：匹配0个字符，只匹配一个字符，匹配一个字符，并继续进行匹配
            if(strIndex < sChar.length && (pChar[patternIndex] == sChar[strIndex] || pChar[patternIndex] == '.')){
                return isMatch2(sChar,pChar,strIndex,patternIndex+2) ||
                        isMatch2(sChar,pChar,strIndex+1,patternIndex) ||
                        isMatch2(sChar,pChar,strIndex+1,patternIndex+2);
            }else {
                return isMatch2(sChar,pChar,strIndex,patternIndex+2);
            }
        }
        //第二个字符不为*
        if(strIndex < sChar.length && (pChar[patternIndex] == sChar[strIndex] || pChar[patternIndex] == '.' )){
            return isMatch2(sChar,pChar,strIndex+1,patternIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "c*a*b";
        Solution6_isMatch solution6 = new Solution6_isMatch();
        System.out.println(solution6.isMatch1(s,p));

    }
}
