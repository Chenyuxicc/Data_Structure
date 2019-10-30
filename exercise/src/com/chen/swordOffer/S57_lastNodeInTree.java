package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/28 on 20:26
 **/
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class S57_lastNodeInTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        /**
         * if pNode has right sibling node ,the last node is the sibling tree's the most left node
         *
         */
        if(pNode.right != null){
            TreeLinkNode left = pNode.right.left;
            if(left != null){
                while (left.left != null){
                    left = left.left;
                }
                return left;
            }return pNode.right;
        }else if(pNode.next !=null && pNode.next.left == pNode) {
            return pNode.next;
        }
        if(pNode.next != null && pNode.next.next !=null && pNode.next.next.left == pNode.next){
            return pNode.next.next;
        }else {
            return null;
        }

    }
}
