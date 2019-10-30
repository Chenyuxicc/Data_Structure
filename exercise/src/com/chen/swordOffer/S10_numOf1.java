package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/29 on 11:47
 **/
public class S10_numOf1 {
    public static int NumberOf1(int n) {
//        int[] arr=new int[32];
//        boolean flag=false;
//        int num=0;
//        int i=0;
//        if(n==0){
//            return 0;
//        }
//        if(n<0){
//            n=-n;
//            flag=true;
//        }
//        while(n>0){
//            arr[i]=n%2;
//            n=n/2;
//            i++;
//        }
//        if(!flag){
//            for (int j = 0; j <32 ; j++) {
//                if(arr[j]==1){
//                    num++;
//                }
//            }
//        }else {
//            for(int k=0;k<32;k++){
//                if(arr[k]==1){
//                    arr[k]=0;
//                }else {
//                    arr[k]=1;
//                }
//            }
//            int c=0;
//            int[] arr1=new int[31];
//            arr1[0]=1;
//            for (int j = 0; j <31; j++) {
//                int sum=arr[j]+arr1[j]+c;
//                arr[j]=sum%2;
//                c=sum/2;
//                if(arr[j]==1){
//                    num++;
//                }
//            }
//            num++;
//        }
//        return num;
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println("n:"+NumberOf1(-50));
    }
}
