package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/3 on 10:28
 **/
public class Solution18 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr=new ArrayList<>();
        if(matrix==null||matrix.length==0||(matrix.length==1&&matrix[0].length==0)){
            return null;
        }
        int rn=matrix.length;
        int cn=matrix[0].length;
        int i=0;
        int j=-1;
        while(rn*2>matrix.length&&cn*2>matrix[0].length){
            while(j<cn-1){
                j++;
                arr.add(matrix[i][j]);
                System.out.println(matrix[i][j]);
            }
            while(i<rn-1){
                i++;
                arr.add(matrix[i][j]);
                System.out.println(matrix[i][j]);

            }
            if(j!=matrix[0].length-cn&&i!=matrix.length-rn){
                while(j>matrix[0].length-cn){
                    j--;
                    arr.add(matrix[i][j]);
                    System.out.println(matrix[i][j]);
                }
                if(j<0){
                    j++;
                }
                while(i>matrix.length-rn+1){
                    i--;
                    arr.add(matrix[i][j]);
                    System.out.println(matrix[i][j]);
                }
            }
            rn--;
            cn--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] matrix=new int[5][3];
        int k=1;
        for (int i = 0; i <5; i++) {
            for (int j = 0; j <3 ; j++) {
                matrix[i][j]=k;
                k++;
            }

        }
        ArrayList<Integer> arr=new ArrayList<>();
        arr=printMatrix(matrix);
        System.out.println("main");
        for (int i = 0; i <arr.size() ; i++) {
            System.out.println(arr.get(i));
        }
    }
}
