package com.chen.qiuzhaotest.kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/25 on 9:57
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] t1 = scanner.nextLine().trim().split(" ");
        String[] t2 = scanner.nextLine().trim().split(" ");
        ArrayList<String> arr = new ArrayList<>();
        int j = 0;
        for (int i = 0;i < t1.length ; i++) {
            if(i % 4 == 0 && i != 0 && j < t2.length){
                arr.add(t2[j++]);
            }
            arr.add(t1[i]);
        }
        while (j < t2.length){
            arr.add(t2[j++]);
        }
        for (int i = 0; i < arr.size() ; i++) {
            if(i != arr.size() -1){
                System.out.print(arr.get(i)+" ");
            } else {
                System.out.print(arr.get(i));
            }
        }
    }
}
