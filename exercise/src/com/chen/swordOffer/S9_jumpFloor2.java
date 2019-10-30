package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/28 on 9:46
 **/
public class S9_jumpFloor2 {
//    public int JumpFloorII(int target) {
//        if(target<=0){
//            return 0;
//        }
//        if(target==1){
//            return 1;
//        }
//        if(target==2){
//            return 2;
//        }
//        int[] arr=new int[target];
//        arr[0]=1;
//        arr[1]=2;
//        for (int i = 2; i <target ; i++) {
//            for (int j = 0; j <i ; j++) {
//                arr[i]=arr[i]+arr[j];
//            }
//            arr[i]++;
//        }
//        return arr[target-1];
//    }
    public static int JumpFloorII(int target){
        int sum=0;
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        for (int i = 1; i <target ; i++) {
            sum+=JumpFloorII(target-i);
        }
        sum++;
        return sum;
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println("target:"+JumpFloorII(3));
    }
}
