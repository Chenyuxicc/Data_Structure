package com.chen.qiuzhaotest.pingduoduo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/2 on 10:59
 **/
public class Main3 {
    static int t = 0;
    static List<Integer> maxList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        float result = 0.0f;
        float sum = 1.0f;
        expection(nums,maxList);
        for (int i = 0; i < maxList.size(); i++) {
            System.out.println(maxList.get(i));
            result += maxList.get(i);
        }
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
        }
        System.out.println(result/sum);
    }
    private static void expection(int[] nums, List<Integer> maxList){
        if(t == nums.length){
            return;
        }
        if(t == 0){
            for (int i = 1; i <= nums[0]; i++) {
                maxList.add(i);
            }
        }else {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= nums[t]; i++) {
                for (int j = 0; j < maxList.size(); j++) {
                    if(i <= maxList.get(j)){
                        list.add(maxList.get(j));
                    }else {
                        list.add(i);
                    }
                }
            }
            maxList.clear();
            for (int i = 0; i < list.size(); i++) {
                maxList.add(list.get(i));
            }
        }
        t++;
        expection(nums,maxList);
    }
}
