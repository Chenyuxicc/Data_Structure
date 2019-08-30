package com.chen.swordOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/31 on 21:08
 **/
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(num.length == 0 || size <=0 ||num.length<size){
            return arrayList;
        }
        for (int i = 0; i <num.length-size+1 ; i++) {
            int max = num[i];
            for (int j = i+1; j <size+i ; j++) {
                if(num[j] > max){
                    max = num[j];
                }
            }
            arrayList.add(max);
        }
        return arrayList;
    }
    public ArrayList<Integer> maxInWindows1(int [] num, int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(num.length == 0 || size <=0 ||num.length<size){
            return arrayList;
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //the start index of sliding windows
        int begin;
        for (int i = 0; i <num.length ; i++) {
            begin = i-size+1;
            System.out.println("begin:"+begin);
            if(arrayDeque.isEmpty()){
                arrayDeque.add(i);
            }else if(begin > arrayDeque.peekFirst()){
                arrayDeque.pollFirst();
            }

            while (!arrayDeque.isEmpty() && num[arrayDeque.peekLast()] <= num[i]){
                System.out.println("peeklast:"+num[arrayDeque.peekLast()]);
                arrayDeque.pollLast();
            }
            arrayDeque.add(i);
            if(begin >= 0){
                arrayList.add(num[arrayDeque.peekFirst()]);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        Solution64 solution64 = new Solution64();
        ArrayList<Integer> arrayList = solution64.maxInWindows1(num,3);
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
