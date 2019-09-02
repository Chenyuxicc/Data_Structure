package com.chen.leetcode.dfs;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:03
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution124 {
    int max = Integer.MIN_VALUE;
    //用递归做
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //最大都为负数，就选择不走这条路
        int leftMax = Math.max(maxSum(root.left),0);
        int rightMax = Math.max(maxSum(root.right),0);

        //第一种情况，从左子树的最大路径经过根节点再到右子数的最大路径
        int path1 = root.val + leftMax + rightMax;
        //第二种情况，最大路径在于左/右子树的最大路径到根节点再到根节点的父节点
        int path2 = root.val + Math.max(leftMax,rightMax);

        max = Math.max(max,Math.max(path1,path2));
        //重要，如果需要返回值，返回的一定是第二种情况，第一种情况路径已经走完了，没有出口了。
        return path2;
    }
}

