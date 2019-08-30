package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/18 on 15:49
 **/
public class Solution39 {
    /**
    * to judge a binary tree is balanced or not
    * @param root root of binary tree
    * @return true or false
    */
    public boolean IsBalanced_Solution(TreeNode root) {
       if(root == null){
           return true;
       }
       return treeDeepth(root) != -1;
    }
    /**
     * when calculate the height of a tree you can judge a tree is balanced or not the same time
     */
    private int treeDeepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSlibingDeepth = treeDeepth(root.left);
        if(leftSlibingDeepth == -1){
            return -1;
        }
        int rightSlibingDeepth = treeDeepth(root.right);
        if(rightSlibingDeepth == -1){
            return -1;
        }
        int difference = leftSlibingDeepth - rightSlibingDeepth;
        return Math.abs(difference)>1?-1:1+Math.max(leftSlibingDeepth,rightSlibingDeepth);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        Solution39 s=new Solution39();
        System.out.println(s.IsBalanced_Solution(root));
    }
}
