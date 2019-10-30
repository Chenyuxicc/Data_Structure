package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/28 on 9:21
 **/
public class S8_jumpFloor {
//    public int JumpFloor(int target) {
//        if(target<=0){
//            return 0;
//        }
//        if(target==1){
//            return 1;
//        }
//        if(target==2){
//            return 2;
//        }
//        return JumpFloor(target-1)+JumpFloor(target-2);
//    }
    public int JumpFloor(int target){
        int[] arr=new int[target];
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        arr[0]=1;
        arr[1]=2;
        for (int i = 2; i <target ; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[target-1];
    }
}
