package com.chen.swordOffer; /**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/22 on 11:01
 **/

public class S51_mutiplyWithoutDivision {
    /**
     * A[0,1,...,n-1] B[0,1,...,n-1] B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
     * limit:can't use division
     */
    public int[] multiply(int[] A) {
        if(A == null){
           return null;
        }
        if(A.length == 1){
           int[] B = {0};
           return B;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length ; i++) {
            int temp = 1;
            for (int j = 0; j < A.length ; j++) {
                if(j == i){
                    temp *= 1;
                }
                else {
                    temp *= A[j];
                }
            }
            B[i] = temp;
        }
        return B;
    }
    public int[] multiply1(int[] A){
        if(A == null){
            return null;
        }
        if(A.length == 1){
            int[] B = {0};
            return B;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        int temp = 1;
        for (int i = 1; i < A.length; i++) {
            temp *= A[i-1];
            B[i] = temp;
        }
        temp = 1;
        for (int i = A.length-2; i >= 0 ; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }
    public static void main(String[] args) {
        S51_mutiplyWithoutDivision solution51 = new S51_mutiplyWithoutDivision();
        int[] A = {1,2,3,4};
        int[] B = solution51.multiply1(A);
        for (int i = 0; i < B.length ; i++) {
            System.out.println("B["+i+"]:"+B[i]);
        }
    }
}
