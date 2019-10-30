package com.chen.swordOffer;

import java.util.Arrays;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/13 on 19:48
 **/
//输入一个数组，判断这个数组是否可能为二叉搜索树的后序遍历结果
//并不是子树不为搜索二叉树就返回false，而是就在第一层中就能判断是不是搜索二叉树了，通过restart的值
public class S22_judgeSearchTreeAfterTraversal {
    public static  boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        int restart=0;
        int length=sequence.length;
        int root=sequence[length-1];
        //这里必须写小于加，不能写大于break，如果是大于break，就没法判断本来应该为右子树的
        //的数组中是否有比最后一个元素小的元素了
        for (int i = 0; i <length-1 ; i++) {
            if(sequence[i]<root){
                restart++;
            }

        }
        if(restart==0){
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,length-1));
        }else {
            for (int i = restart; i <length-1 ; i++) {
                if(sequence[i]<root){
                    return false;
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,restart));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence,restart,length-1));
        }
        return true;

    }
    public static  boolean VerifySquenceOfBST1(int [] sequence){
        if(sequence==null||sequence.length<=0){
            return false;
        }
        int length=sequence.length;
        int root=sequence[length-1];
        int i = 0;
        for (; i <length-1 ; i++) {
            if(sequence[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<length-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left=true;
        if(i>0){
            left=VerifySquenceOfBST1(Arrays.copyOfRange(sequence,0,i));
        }
        boolean right=true;
        if(i<length-1){
            right=VerifySquenceOfBST1(Arrays.copyOfRange(sequence,i,length-1));
        }
        return (left&&right);

    }


    public static void main(String[] args) {
        int arr[]={1,4,3,6,9,8,5};
        System.out.println("是否为后序:"+VerifySquenceOfBST1(arr));
        //Arrays.copyofRange测试：从from到to-1
        int arr1[]=Arrays.copyOfRange(arr,0,2);
        for (int i = 0; i <arr1.length ; i++) {
            System.out.println(arr1[i]);
        }
    }
}
