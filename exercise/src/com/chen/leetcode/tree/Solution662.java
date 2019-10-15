package com.chen.leetcode.tree;

import com.chen.niukeLeetcode.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenyuxi
 * @since 19-9-9:下午7:20
 */
public class Solution662 {
    /**
     * 使用一个indexList存放每个节点的编号
     *
     */
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode temp = queue.poll();
                int index = indexList.removeFirst();
                if(temp.left != null){
                    queue.add(temp.left);
                    indexList.add(index * 2);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    indexList.add(index * 2 + 1);
                }
                size--;
            }
            //需要进行判断，不然会报错
            if(indexList.size() >= 2){
                max = Math.max(max,indexList.getLast() - indexList.getFirst() + 1 );
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(widthOfBinaryTree(root));
    }
}
