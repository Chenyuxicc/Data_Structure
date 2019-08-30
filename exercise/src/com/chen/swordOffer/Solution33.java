package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @date 2019/4/29 on 20:13
 **/
//找到只含字母的字符串中第一个只出现一次的字符的位置
public class Solution33 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null&&str.length()==0){
            return 0;
        }
        int[] lowCase=new int[26];
        int[] upperCase=new int[26];
        for (int i = 0; i <str.length() ; i++) {
            char c=str.charAt(i);
            if(c>=65&&c<=90){
                int index=c-65;
                upperCase[index]++;
            }else {
                int index=c-97;
                lowCase[index]++;
            }
        }
        for (int i = 0; i <26 ; i++) {
            System.out.println(upperCase[i]);
        }
        System.out.println("--------------");
        for (int i = 0; i <26 ; i++) {
            System.out.println(lowCase[i]);
        }
        System.out.println("--------------");

        for (int i = 0; i <str.length() ; i++) {
            char c=str.charAt(i);
            if(c>=65&&c<=90){
                int index=c-65;
                if(upperCase[index]==1){
                    return i;
                }

            }
            if(c>=97&&c<=122){
                int index=c-97;
                if(lowCase[index]==1){
                    return i;
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str="aAwshdduisajGBSFIAjshvx";
        Solution33 s=new Solution33();
        System.out.println(s.FirstNotRepeatingChar(str));
    }
}
