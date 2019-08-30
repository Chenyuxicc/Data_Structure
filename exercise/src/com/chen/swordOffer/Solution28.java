package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/20 on 19:53
 * finished:2019/4/20 on 22:13
 **/
//找到一个数组中最小的k个数
public class Solution28 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> minArray=new ArrayList<>();
        int length=input.length;
        if(length==0||k==0||k>length){
            return minArray;
        }
        input=Partition(input,0,length-1);
        for (int i = 0; i <k ; i++) {
            minArray.add(input[i]);
        }
        return minArray;
    }
    public static int[] Partition(int [] input,int left,int right){
        if(right<=left){
            return input;
        }
        int n=input[left];
        int i=left;
        int j=right;
        while(i<j) {
            while(input[j]>n&&i<j){
                j--;
            }
            //因为input[i]的值已经存下来了，所以改变Input[i]的值，直接将input[j]的值赋给input[i]
            input[i]=input[j];
            while(input[i]<=n&&i<j){
               i++;
            }
            input[j]=input[i];
        }
        //最后将n赋给input[i]
        input[i]=n;
        Partition(input,left,i-1);
        Partition(input,i+1,right);
        return input;
    }

    public static void main(String[] args) {
        int [] input={7,8,2,10,4,6,11,1,5,19,22,13};
        Solution28 s=new Solution28();
        int length=input.length;
        //input=s.Partition(input,0,length-1);
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList=GetLeastNumbers_Solution(input,6);
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
