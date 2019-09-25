package com.chen.qiuzhaotest.xiaomi2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/11 on 11:58
 **/
public class Main1 {

    static int solution(int[] arr) {
        if(arr.length == 0 || arr.length == 1){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            if(arr[i] > list.get(list.size() - 1)){
                list.add(arr[i]);
            }else {
                int index = Collections.binarySearch(list,temp);
                int t = index > 0 ? index :   -index -1;
                list.set(t,temp);
            }
        }
        int[] newList = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newList[arr.length - i -1] = arr[i];
        }
        list1.add(newList[0]);
        for (int i = 1; i < arr.length; i++) {
            int temp = newList[i];
            if(newList[i] > list1.get(list1.size() - 1)){
                list1.add(newList[i]);
            }else {
                int index = Collections.binarySearch(list1,temp);
                int t = index > 0 ? index : -index - 1;
                list1.set(t,temp);
            }
        }
        System.out.println(list1.size());
        return list1.size() > list.size() ? arr.length - list1.size() : arr.length - list.size();
    }


    public static void main(String[] args){
        int[] arr = {2,1 ,5 ,3 ,6 ,4 ,8 ,9 ,7};
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(2);
//        arrayList.add(5);
//        int index = Collections.binarySearch(arrayList,4);
//        System.out.println(index);
//        arrayList.set(2,4);
        System.out.println(solution(arr));

    }
}
