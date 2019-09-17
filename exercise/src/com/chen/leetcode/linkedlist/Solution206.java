package com.chen.leetcode.linkedlist;

/**
 * @author chenyuxi
 * @since 19-9-10:上午10:45
 */
public class Solution206 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        ListNode next = null;
        while (p != null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    //递归
    public ListNode reverseList1(ListNode head,ListNode pre){
        ListNode next = null;
        if(head == null){
            return pre;
        }
        next = head.next;
        head.next = pre;
        return reverseList1(next,head);
    }
}
