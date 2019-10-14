package com.chen.qiuzhaotest.xiecheng2;

import java.util.*;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/14 on 10:37
 **/
public class Main1 {
    static boolean CheckBlackList(String userIP, String blackIP) {
        if(userIP.equals(blackIP)){
            return true;
        }
        String[] s1 = userIP.split("\\.");
        String[] s2 = blackIP.split("\\.");
        int[] ip1 = new int[32];
        int[] ip2 = new int[32];
        String[] t = s2[3].split("/");
        int num = -1;
        if(t.length == 2){
            num = Integer.valueOf(t[1]);
            s2[3] = t[0];
        }
        for (int i = 0; i < s1.length; i++) {
            int t1 = Integer.valueOf(s1[i]);
            int t2 = Integer.valueOf(s2[i]);

            int[] binaryT1 = convert(t1);
            int[] binaryT2 = convert(t2);

            for (int j = 0; j < binaryT1.length; j++) {
                ip1[i * 8 + j] = binaryT1[j];
                ip2[i * 8 + j] = binaryT2[j];
            }
        }
        for (int i = 0; i < ip1.length; i++) {
            if(t.length == 2){
                if(num == 0){
                    break;
                }
                if(ip1[i] != ip2[i]){
                    return false;
                }
                num--;
            }else {
                if(ip1[i] != ip2[2]){
                    return false;
                }
            }
        }
        return true;
    }
    static int[] convert(int num){
        int[] binaryNum = new int[8];
        int i = 7;
        while (num != 0){
            int t = num % 2;
            binaryNum[i] = t;
            i--;
            num /= 2;
        }
        return binaryNum;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
