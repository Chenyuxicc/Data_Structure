package com.chen.qiuzhaotest.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/8/3 on 16:09
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNum = Integer.valueOf(in.nextLine());
        int[] nums = new int[testNum];
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(testNum);
        int i = 0;
        while (i < testNum){
            nums[i] = Integer.valueOf(in.nextLine());
            String[] s = in.nextLine().trim().split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>(nums[i]);
            for (int j = 0; j < nums[i] ; j++) {
                arrayList.add(Integer.valueOf(s[j]));
            }
            arrayLists.add(arrayList);
            i++;
        }
        String[] result = new String[testNum];
        for (int j = 0; j < testNum; j++) {
            ArrayList temp = arrayLists.get(j);
        }
        for (int j = 0; j <testNum ; j++) {
            System.out.println("NO");
        }
    }
}
