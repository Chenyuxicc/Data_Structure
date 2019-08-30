package com.chen.niukeLeetcode;

import com.chen.niukeLeetcode.dataStructure.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/3 on 21:39
 **/
public class Solution1 {
    public int run(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if(root == null){
            return 0;
        }
        queue.add(root);
        int size = 0;
        int minPath = 1;
        while (!queue.isEmpty()){
            size = queue.size();
            while (size > 0){
                TreeNode treeNode = queue.poll();
                size--;
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
                if(treeNode.left == null && treeNode.right == null){
                    return minPath;
                }
            }
            minPath++;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.run(root));
    }
}
