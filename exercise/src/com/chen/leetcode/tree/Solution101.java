package com.chen.leetcode.tree;

import com.chen.niukeLeetcode.dataStructure.TreeNode;

/**
 * @author chenyuxi
 * @since 19-9-9:下午10:04
 */
public class Solution101 {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    /**
     * 传入两个参数left和right
     */
    private static boolean isMirror(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            if(left.val == right.val){
                return isMirror(left.left,right.right) && isMirror(left.right,right.left);
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.right = node1;
        head.left = node2;
        System.out.println(isSymmetric(head));
    }
}
