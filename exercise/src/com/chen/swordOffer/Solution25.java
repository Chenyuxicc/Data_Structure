package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/4/16 on 11:16
 * finished：15:15
 **/
//将二叉树转化为双向链表
//要求不能创建任何新的节点，只能改变树的节点指向
public class Solution25 {
    //思路感觉有点不一样,先改子树，再改根节点
    //改变根节点的整棵树会影响子树的修改，此种情况下先改子树
    //方法一：
//    public com.chen.swordOffer.TreeNode Convert(com.chen.swordOffer.TreeNode pRootOfTree) {
//        if(pRootOfTree==null){
//            return null;
//        }
//        com.chen.swordOffer.TreeNode lRight=pRootOfTree.left;
//        com.chen.swordOffer.TreeNode rLeft=pRootOfTree.right;
//        com.chen.swordOffer.TreeNode left=lRight;
//        com.chen.swordOffer.TreeNode right=rLeft;
//        if(lRight!=null){
//            while(lRight.right!=null){
//                lRight=lRight.right;
//            }
//        }
//        if(rLeft!=null){
//            while(rLeft.left!=null){
//                rLeft=rLeft.left;
//            }
//        }
//        if(left!=null)
//            Convert(left);
//       if(right!=null)
//            Convert(right);
//        if(lRight!=null){
//            pRootOfTree.left=lRight;
//            lRight.right=pRootOfTree;
//        }
//        if(rLeft!=null){
//            pRootOfTree.right=rLeft;
//            rLeft.left=pRootOfTree;
//        }
//        while (pRootOfTree.left!=null){
//            pRootOfTree=pRootOfTree.left;
//        }
//        return pRootOfTree;
//    }
    //方法二(书上的)：
    public TreeNode Convert(TreeNode pRootOfTree){
        TreeNode lastNode=Convert1(pRootOfTree,null);
        while(lastNode.left!=null){
            lastNode=lastNode.left;
        }
        return lastNode;
    }
    public TreeNode Convert1(TreeNode pRootOfTree,TreeNode lastNode){
        if(pRootOfTree==null){
            return null;
        }
        TreeNode cur=pRootOfTree;
        if(pRootOfTree.left!=null){
            lastNode=Convert1(pRootOfTree.left,lastNode);
        }
        cur.left=lastNode;
        if(lastNode!=null){
            lastNode.right=cur;
        }
        lastNode=cur;
        if(pRootOfTree.right!=null){
            lastNode=Convert1(pRootOfTree.right,lastNode);
        }
        return lastNode;

    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(3);
        root.left.left.left=new TreeNode(2);
//        root.left=new com.chen.swordOffer.TreeNode(3);
//        root.right=new com.chen.swordOffer.TreeNode(8);
//        root.left.left=new com.chen.swordOffer.TreeNode(1);
//        root.left.right=new com.chen.swordOffer.TreeNode(4);
        Solution25 s=new Solution25();
        TreeNode t=s.Convert(root);
        while (t!=null){
            System.out.println(t.val);
            t=t.right;
        }
    }
}
