package com.chen.swordOffer;

import java.util.ArrayList;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/15 on 12:56
 **/
//判断二叉树是否存在路径之和等于给定值
//1.注意审题，题目中说的路径指从根节点到叶结点的路径，这样就不必比数组长短，不必再递归子节点
public class S23_findPathInTree {
    //下面这两句初始化，加static牛客网不能ac，不加static可以ac
    private ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> arr_sub=new ArrayList<>();
    //非递归
//    public static ArrayList<ArrayList<Integer>> FindPath(com.chen.swordOffer.TreeNode root,int target) {
//        ArrayList<ArrayList<com.chen.swordOffer.TreeNode>> arr = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> arr_Int=new ArrayList<>();
//        if(root==null){
//            return arr_Int;
//        }
//        ArrayList<com.chen.swordOffer.TreeNode> arr_sub = new ArrayList<>();
//        Stack<com.chen.swordOffer.TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            com.chen.swordOffer.TreeNode tr = stack.pop();
//            while (!arr_sub.isEmpty()&&(arr_sub.get(arr_sub.size() - 1).left != tr) &&( arr_sub.get(arr_sub.size() - 1).right != tr)) {
//                arr_sub.remove(arr_sub.get(arr_sub.size() - 1));
//            }
//            arr_sub.add(tr);
//            if (sum(arr_sub) == target&&tr.left==null&&tr.right==null) {
//                //不用判断？
//                arr.add(new ArrayList<>(arr_sub));
//            }
//            if (tr.right != null) {
//                stack.push(tr.right);
//            }
//            if (tr.left != null) {
//                stack.push(tr.left);
//            }
//        }
//
//        for (int i = 0; i <arr.size() ; i++) {
//            ArrayList<Integer> a=new ArrayList<>();
//            for (int j = 0; j <arr.get(i).size() ; j++) {
//                a.add(arr.get(i).get(j).val);
//            }
//            arr_Int.add(a);
//        }
//        return arr_Int;
//    }
//    public com.chen.swordOffer.S23_findPathInTree(){
//        arr.clear();
//        arr_sub.clear();
//    }
    //递归：
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return arr;
        }
        arr_sub.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            arr.add(new ArrayList<>(arr_sub));
        }
        //以根节点为例,返回带根节点的数组,结束后返回上一级递归时，将最后加入的那个节点删除
        else{
            if(root.left!=null)
                FindPath(root.left,target);
            if(root.right!=null)
                FindPath(root.right,target);
        }
        arr_sub.remove(arr_sub.size()-1);
        return arr;
    }
//    public static int sum(ArrayList<com.chen.swordOffer.TreeNode> arrayList){
//        int sum=0;
//        for (com.chen.swordOffer.TreeNode t:arrayList) {
//            sum+=t.val;
//        }
//        return sum;
//    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(7);
        S23_findPathInTree s=new S23_findPathInTree();
        //创建两个实例来测试这个方法时就会出现问题，因为static是共享的。
        //解决方案，创建无参构造函数，函数里将这两个变量值清除
        ArrayList<ArrayList<Integer>> arr=s.FindPath(root,18);
        ArrayList<ArrayList<Integer>> arr1=s.FindPath(root,22);
        System.out.println(arr);
        System.out.println(arr1);
    }
}
