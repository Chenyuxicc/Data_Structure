package com.chen.swordOffer;

import java.util.Stack;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/30 on 14:08
 **/
public class S12_putEvenAfterOdd {
    public static void reOrderArray(int [] array) {
//        Stack<Integer> stack1=new Stack<>();
//        Stack<Integer> stack2=new Stack<>();
//        for (int i = 0; i <array.length ; i++) {
//            if(array[i]%2==0){
//                stack1.push(array[i]);
//            }else {
//                stack2.push(array[i]);
//            }
//        }
//        int n=array.length-1;
//        for (int i = n; i >=0;  i--) {
//            if(!stack1.empty()){
//                array[i]=stack1.pop();
//            }
//            else{
//                array[i]=stack2.pop();
//            }
//        }

        for (int i = 1; i <array.length ; i++) {
            int j=i-1;
            //把偶数换到后面去
            if(array[i]%2!=0){
                while(j>=0){
                    if(array[j]%2!=0){
                        break;
                    }else {
                        //此时array[j]为偶数，array[j+1]为奇数，将这两个数交换位置
                        //保证后面的一直是偶数，把偶数换到后面去
                        int t=array[j+1];
                        array[j+1]=array[j];
                        array[j]=t;
                        j--;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
       int[] arr=new int[]{2,4,6,1,3,5,7};
       reOrderArray(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("i:"+arr[i]);
        }
    }
}
