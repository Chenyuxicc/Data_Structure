package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/31 on 15:37
 **/
public class Solution17 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }else{
            TreeNode p=root.left;
            root.left=root.right;
            root.right=p;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
