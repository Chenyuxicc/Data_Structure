package com.chen.leetcode.linkedlist;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:08
 */
public class S21_mergeTwoList {
    /**
     * 思路：使用头节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next =  l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head;
    }
}

