package com.chen.qiuzhaotest.baidu;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/17 on 20:33
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = "";
        }
        for (int i = 0; i < count; i++) {
            String[] s = in.nextLine().split(" ");
            int dotCount = Integer.valueOf(s[0]);
            int vecCount = Integer.valueOf(s[1]);
            int[][] arr = new int[vecCount][2];
            for (int j = 0; j < vecCount; j++) {
                String[] temp = in.nextLine().split(" ");
                arr[j][0] = Integer.valueOf(temp[0]);
                arr[j][1] = Integer.valueOf(temp[1]);
            }
            for (int j = 0; j < vecCount; j++) {
                if(arr[j][0] == 1){
                    int t = arr[j][1];
                    for (int k = 0; k < vecCount; k++) {
                        if(arr[k][0] == t && arr[k][1] == dotCount){
                            result[i] = "POSSIBLE";
                            break;
                        }
                    }
                }
            }
            if(!result[i].equals("POSSIBLE")){
                result[i] = "IMPOSSIBLE";
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(result[i]);
        }
    }
}
