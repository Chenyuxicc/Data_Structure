package com.chen.leetcode.tree;

import com.chen.niukeLeetcode.dataStructure.TreeNode;

/**
 * @author chenyuxi
 * @since 19-9-6:下午12:56
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortBst(nums,0,nums.length-1);
        return root;
    }
    private TreeNode sortBst(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortBst(nums,left,mid - 1);
        root.right = sortBst(nums,mid + 1 , right);
        return root;
    }
}
