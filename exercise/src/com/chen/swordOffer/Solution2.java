package com.chen.swordOffer;

import java.util.ArrayList;

public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        char c1='0';
        String c2="%20";
        for(int i=0;i<str.length();i++){
           c1=str.charAt(i);
           if(c1==' '){
             str.replace(i,i+1,c2);
           }
        }
        return str.toString();
    }
    public static void main(String[] args) {
       StringBuffer str=new StringBuffer("hello");
       str.replace(1,1,"%20");
       System.out.println("str:"+str);
    }
}