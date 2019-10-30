package com.chen.swordOffer; /**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/17 on 14:54
 **/

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 层次遍历，求层数
 *
 */
public class S38_findDepthOfTree {
    /**
     * no recursion way to calculate the height of binary tree
     * @param root the root com.chen.swordOffer.TreeNode of  binary tree
     * @return the height of binary tree
     */
    public int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = 0;
        //表示每一层的节点数,用队列大小表示
        int length = 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        TreeNode nowTreeNode = root;
        queue.add(nowTreeNode);
        while (!queue.isEmpty()){
            length=queue.size();
            while (length--!=0){
                nowTreeNode = queue.poll();
                if(nowTreeNode!=null){
                    if(nowTreeNode.left!=null){
                        queue.add(nowTreeNode.left);
                    }
                    if(nowTreeNode.right!=null){
                        queue.add(nowTreeNode.right);
                    }
                }
            }
            height++;
        }
        return height;
    }
    /**
     * key:use a var length to record the size of current queue
     * only after traversing all nodes of current layer can we traverse next layer
     * recursion way to calculate the height of binary tree
     * @param root the root com.chen.swordOffer.TreeNode of  binary tree
     * @return the height of binary tree
     */
    public int treeDeepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSlibingDeepth = treeDeepth(root.left);
        int rightSlibingDeepth = treeDeepth(root.right);
        return leftSlibingDeepth>rightSlibingDeepth?leftSlibingDeepth+1:rightSlibingDeepth+1;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(7);
        S38_findDepthOfTree s=new S38_findDepthOfTree();
        System.out.println(s.treeDeepth(root));
    }

}
