package com.chen.swordOffer;
/*
* 输入参数：一个二维数组，数组的每一行都递增，每一列都递增
*          一个整数target
* 功能:查找这个整数在这个数组里是否存在，若存在，则返回true，若不存在返回false
*
* 思路：找到一个数，该行的数都比他小，该列的数都比他大
* 右上角的数，符合这样的条件，若右上角的数大于target，则删除该列，小于target，则删除改行
*
* 左下角的数大于target，删除改行，小于target，删除该列
* */

public class S1_findInMatrix {
    public boolean Find(int target, int [][] array) {
        int rlength=array.length;
        int clength=array[0].length;
        if(array==null){
            return false;
        }else{
           int i=0;
           while(i<rlength&&clength>0){
               int num=array[i][clength-1];
               if(num>target){
                   clength--;
               }else if(num<target){
                   i++;
               }else if(num==target){
                   return true;
               }
           }
           return false;
        }
    }

    public static void main(String[] args) {
        int [][] array={{}};
        System.out.println("array.length:"+array.length);
        System.out.println("array.length:"+array[0].length);
    }
}