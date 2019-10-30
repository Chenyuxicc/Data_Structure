package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/20 on 11:38
 **/

public class S44_reverseString {
    /**
     * reverse order of one sentence's words
     *
     */
    public String ReverseSentence(String str) {
        String s = "";
        if(str.isEmpty()||str.trim().equals(s)){
            return str;
        }
        String[] strings = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strings.length-1; i >= 0; i--) {
           stringBuffer.append(strings[i]);
           if(i>=1){
               stringBuffer.append(" ");
           }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        S44_reverseString solution44 = new S44_reverseString();
        System.out.println(":"+solution44.ReverseSentence("i am a student")+":");
    }
}
