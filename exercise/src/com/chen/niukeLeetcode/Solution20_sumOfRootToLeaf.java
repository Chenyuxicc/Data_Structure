package com.chen.niukeLeetcode;

import com.chen.niukeLeetcode.dataStructure.TreeNode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/2 on 10:41
 **/
public class Solution20_sumOfRootToLeaf {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return sumOfLeaves(root,sum);
    }
    /**
     * cannot calculate the height of tree
     * you need to consider special condition when you calculate the solution
     */
    private int sumOfLeaves(TreeNode root , int sum){
        if(root == null){
            return 0;
        }
        sum = sum*10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        return sumOfLeaves(root.left,sum)+sumOfLeaves(root.right,sum);
    }
}
