package com.chen.leetcode.dfs;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:03
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}