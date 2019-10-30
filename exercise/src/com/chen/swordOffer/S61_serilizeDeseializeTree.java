package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/30 on 14:35
 **/
public class S61_serilizeDeseializeTree {
    StringBuffer stringBuffer = new StringBuffer();
    String Serialize(TreeNode root) {
       if(root == null){
           stringBuffer.append("#,");
           return stringBuffer.toString();
       }
       stringBuffer.append(root.val+",");
       Serialize(root.left);
       Serialize(root.right);
       return stringBuffer.toString();
    }
    /**
     * because add the "#" to present null node,we can use the str to deserialize original tree
     */
    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String[] strings = str.split(",");
        if(index < str.length()){
            if("#".equals(strings[index])){
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
            return node;
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        //root.right=new com.chen.swordOffer.TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(5);
        S61_serilizeDeseializeTree solution61 = new S61_serilizeDeseializeTree();
        String s = solution61.Serialize(root);
        String[] s1 = s.split(",");
        for (String s2: s1) {
            System.out.println(s2);
        }

    }
}
