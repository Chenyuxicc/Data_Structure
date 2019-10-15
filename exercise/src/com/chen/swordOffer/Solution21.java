package com.chen.swordOffer; /**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/13 on 19:13
 **/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//从上往下打印二叉树
public class Solution21 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
            arrayList.add(treeNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        System.out.println(arr);
    }
}
