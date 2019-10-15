package com.chen.interview.kuaishou;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 11:32
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String dot = ".";
        String[] arr = s.substring(0,s.length()-1).trim().split("\\s+");
        for (int i = arr.length-1; i >= 0 ; i--) {
            if(i == 0){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(dot);
    }
}
