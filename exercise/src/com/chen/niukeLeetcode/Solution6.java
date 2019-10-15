package com.chen.niukeLeetcode;
import com.chen.niukeLeetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/12 on 21:37
 **/
public class Solution6 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        TreeNode p = root;
        TreeNode r = null;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.peek();
                if(p.right != null && p.right != r){
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                }else {
                    p = stack.pop();
                    arrayList.add(p.val);
                    r = p;
                    p = null;
                }
            }

        }
        return arrayList;
    }
}
