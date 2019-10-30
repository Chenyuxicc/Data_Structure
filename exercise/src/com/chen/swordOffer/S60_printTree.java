package com.chen.swordOffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/29 on 15:59
 **/
public class S60_printTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(pRoot == null){return arrayLists;}
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (size > 0){
                TreeNode treeNode = queue.poll();
                size--;
                arrayList.add(treeNode.val);
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        S60_printTree solution60 = new S60_printTree();
        System.out.println(solution60.Print(root));
    }
}
