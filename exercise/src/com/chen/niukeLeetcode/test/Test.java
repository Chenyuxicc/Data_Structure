package com.chen.niukeLeetcode.test;

import com.chen.niukeLeetcode.Solution20_sumOfRootToLeaf;
import com.chen.niukeLeetcode.dataStructure.TreeNode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/2 on 11:26
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        root.left = t1;
        t1.left = t2;
        t2.left = t3;
        root.right = t4;
        Solution20_sumOfRootToLeaf solution20 = new Solution20_sumOfRootToLeaf();
        System.out.println("sum:"+solution20.sumNumbers(root));
     }
}
