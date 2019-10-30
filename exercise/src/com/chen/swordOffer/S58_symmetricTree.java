package com.chen.swordOffer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/29 on 9:53
 **/
public class S58_symmetricTree {
    /**
     * to judge a tree is symmetry or not
     *
     */
    boolean isSymmetrical1(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        TreeNode mirrorTreeNode = new TreeNode(pRoot.val);
        mirrorTreeNode = mirrorTree(pRoot);
        Queue<TreeNode> queuePRoot = new LinkedBlockingQueue<>();
        queuePRoot.add(pRoot);
        Queue<TreeNode> queueMirrorRoot = new LinkedBlockingQueue<>();
        queueMirrorRoot.add(mirrorTreeNode);
        while (!queuePRoot.isEmpty() && !queueMirrorRoot.isEmpty()){
            System.out.println("进来了");
            int sizeOfQueueP = queuePRoot.size();
            int sizeOfQueueMirror = queueMirrorRoot.size();
            if(sizeOfQueueMirror != sizeOfQueueP){
                return false;
            }
            while (sizeOfQueueP > 0){
                TreeNode treeNodeP = queuePRoot.poll();
                sizeOfQueueP--;
                TreeNode treeNodeMirror = queueMirrorRoot.poll();
                sizeOfQueueMirror--;
                if(treeNodeP !=null && treeNodeMirror != null){
                    if(treeNodeP.val != treeNodeMirror.val){
                        return false;
                    }
                    if(treeNodeP.left != null && treeNodeMirror.left != null){
                        if(treeNodeP.left.val != treeNodeMirror.left.val){
                            return false;
                        }
                    }else {
                        if(treeNodeP.left == null && treeNodeMirror.left != null){
                            return false;
                        }
                        if(treeNodeP.left != null && treeNodeMirror.right == null){
                            return false;
                        }
                    }
                    if(treeNodeP.right != null && treeNodeMirror.right != null){
                        if(treeNodeP.right.val != treeNodeMirror.right.val){
                            return false;
                        }
                    }else {
                        if(treeNodeP.right == null && mirrorTreeNode.right != null){
                            return false;
                        }
                        if(treeNodeP.right != null && mirrorTreeNode.right == null){
                            return false;
                        }
                    }
                }
                if(treeNodeP.left != null){
                    queuePRoot.add(treeNodeP.left);
                    queueMirrorRoot.add(treeNodeMirror.left);
                }
                if(treeNodeP.right != null){
                    queuePRoot.add(treeNodeP.right);
                    queueMirrorRoot.add(treeNodeMirror.right);
                }
            }
        }
        return queuePRoot.isEmpty() && queueMirrorRoot.isEmpty();
    }

    /**
     * change a tree when mirror it
     *
     */

    private TreeNode mirrorTree(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        if(node.left != null){
            mirrorTree(node.left);
        }
        if(node.right != null){
            mirrorTree(node.right);
        }
        return node;
    }
    /**
     * sword offer solution
     * define a new traverse method which is symmetry of before method
     */
    boolean isSymmetrical(TreeNode pRoot){
        return isSymmetry(pRoot,pRoot);
    }

    private boolean isSymmetry(TreeNode node,TreeNode mirror){
        if(node == null && mirror == null){
            return true;
        }
        if(node == null || mirror == null){
            return false;
        }
        if(node.val != mirror.val){
            return false;
        }
        return isSymmetry(node.left,mirror.right)&&isSymmetry(node.right,mirror.left);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
//        root.right=new com.chen.swordOffer.TreeNode(2);
//        root.left.left=new com.chen.swordOffer.TreeNode(4);
//        root.left.right=new com.chen.swordOffer.TreeNode(7);
        S58_symmetricTree solution58 = new S58_symmetricTree();
        System.out.println(solution58.isSymmetrical(root));
    }
}
