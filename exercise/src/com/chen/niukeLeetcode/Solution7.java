package com.chen.niukeLeetcode;
import com.chen.niukeLeetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/13 on 8:23
 **/
public class Solution7 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
           if(p != null){
               arrayList.add(p.val);
               stack.push(p);
               p = p.left;
           }else {
               p = stack.pop();
               p = p.right;
           }
        }
        return arrayList;
    }
    public ArrayList<Integer> midorderTraversal(TreeNode root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                arrayList.add(p.val);
                p = p.right;
            }
        }
        return arrayList;
    }
}
