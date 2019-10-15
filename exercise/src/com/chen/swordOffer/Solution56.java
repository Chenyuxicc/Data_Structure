package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/28 on 13:46
 **/
public class Solution56 {
    /**
     * delete duplicate node of ordered LinkedList
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        headNode.next = pHead;
        ListNode lastP = headNode;
        ListNode p = pHead;
        ListNode pRepeatNode  = pHead.next;
        while (pRepeatNode != null){
            if(p.val != pRepeatNode.val){
                lastP = p;
                p = p.next;
                pRepeatNode = p.next;

            }else {
                while (pRepeatNode!=null&&pRepeatNode.val == p.val){
                    pRepeatNode = pRepeatNode.next;
                }
                if(pRepeatNode == null){
                    lastP.next = null;
                    return headNode.next;
                }else {
                    lastP.next = pRepeatNode;
                    p = pRepeatNode;
                    pRepeatNode = p.next;

                }
            }
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution56 solution56 = new Solution56();
        ListNode node = solution56.deleteDuplication(node1);
        while (node != null){
            System.out.println("node.val:"+node.val);
            node = node.next;
        }
    }
}
