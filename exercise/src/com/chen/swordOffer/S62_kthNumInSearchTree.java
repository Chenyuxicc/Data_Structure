package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/30 on 15:51
 **/
public class S62_kthNumInSearchTree {
    /**
     * find the kth smallest treeNode in search tree
     */
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k <= 0){
            return null;
        }
        TreeNode node = KthNode(pRoot.left,k);
        if(node != null){
            return node;
        }
        index++;
        if(index == k){
            return pRoot;
        }
        TreeNode node1 = KthNode(pRoot.right,k);
        if(node1 != null){
            return node1;
        }
        return null;
    }
}
