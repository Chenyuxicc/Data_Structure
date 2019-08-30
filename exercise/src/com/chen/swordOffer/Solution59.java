package com.chen.swordOffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/29 on 11:35
 **/
public class Solution59 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if(pRoot == null){
            return arrayList;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(pRoot);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            while (size>0){
                TreeNode treeNode = queue.poll();
                arrayList1.add(treeNode.val);
                size--;
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            if(!flag){
                reverseArrayList(arrayList1);
                arrayList.add(arrayList1);
                flag = !flag;
            }else {
                arrayList.add(arrayList1);
                flag = !flag;
            }
        }
        return arrayList;
    }
    private ArrayList<Integer> reverseArrayList(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        for (int i = 0; i <= size/2-1 ; i++) {
            int temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(size-1-i));
            arrayList.set(size-1-i,temp);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        Solution59  solution59 = new Solution59();
        System.out.println(solution59.Print(root));
    }
}
