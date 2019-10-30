package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/31 on 13:29
 **/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class S16_judgeSubTree {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {

       if(root1==null||root2==null){
           return false;
       }
//       boolean a=findSameTree(root1,root2);
//       if(a){
//           return a;
//       }else {
//           return !HasSubtree(root1.left,root2)?HasSubtree(root1.right,root2):HasSubtree(root1.left,root2);
//
//       }
        return findSameTree(root1,root2)||findSameTree(root1.left,root2)||findSameTree(root1.right,root2);

    }
    public static boolean findSameTree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        else if(root1==null||root1.val!=root2.val){
            return false;
        }
        return findSameTree(root1.left,root2.left)&&findSameTree(root1.right,root2.right);
//        else{
//            if(findSameTree(root1.left,root2.left)&&findSameTree(root1.right,root2.right)){
//                return true;
//            }else{
//                return false;
//            }
//        }
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);
        root1.left.left=new TreeNode(2);
        root1.right.left=new TreeNode(2);
        root1.right.left.left=new TreeNode(4);
        TreeNode root2=new TreeNode(2);
        root2.left=new TreeNode(4);
//        root2.right=new com.chen.swordOffer.TreeNode(2);
//        root2.left.left=new com.chen.swordOffer.TreeNode(4);
        System.out.println("是不是其子类:"+HasSubtree(root1,root2));

    }
}
