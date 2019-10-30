package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/27 on 10:19
 **/
public class S7_Fibonacci {
//    public int Fibonacci(int n) {
//        if(n==0||n==1){
//            return n;
//        }else {
//            return Fibonacci(n-1)+Fibonacci(n-2);
//        }
//    }
    //用循环自下而上
    public int Fibonacci(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int [] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <=n ; i++) {
           arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        S7_Fibonacci s=new S7_Fibonacci();
        int a=s.Fibonacci(7);
        System.out.println("a:"+a);
    }
}
