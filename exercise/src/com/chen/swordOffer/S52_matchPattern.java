package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/23 on 18:59
 **/
public class S52_matchPattern {
    private char star = '*';
    private char dot = '.';
    public boolean match(char[] str, char[] pattern) {

        int strIndex = 0;
        int patternIndex = 0;
        return matchPattern(str,strIndex,pattern,patternIndex);
    }
    public boolean matchPattern(char[] str,int strIndex,char[] pattern,int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        //the second char is '*'
        if(patternIndex+1 < pattern.length && pattern[patternIndex+1] == star){
            if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == dot)){
                return matchPattern(str,strIndex,pattern,patternIndex+2)||
                        matchPattern(str,strIndex+1,pattern,patternIndex+2)||
                        matchPattern(str,strIndex+1,pattern,patternIndex);
            }else {
                return matchPattern(str,strIndex,pattern,patternIndex+2);
            }
        }
        //the second char is not '*'
        if(strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == dot)) {
            return matchPattern(str,strIndex+1,pattern,patternIndex+1);
        }
        System.out.println("str:"+strIndex+",pattern:"+patternIndex);
        return false;
    }

    public static void main(String[] args) {
        char[] str = {};
        char[] pattern  = {'.','*'};
        S52_matchPattern solution52 = new S52_matchPattern();
        System.out.println(solution52.match(str,pattern));
    }
}
