package com.chen.leetcode.topInterview;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/7/17 on 9:40
 **/


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution148_LinkedListSort {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null){
            p = p.next;
            q = q.next.next;
        }
        ListNode temp = p.next;
        p.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(temp);
        ListNode h = new ListNode(-1);
        ListNode res = h;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                res.next = head1;
                head1 = head1.next;
            }else {
                res.next = head2;
                head2 = head2.next;
            }
            res = res.next;
        }
        res.next = head1 == null ? head2 : head1;
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;
        Solution148_LinkedListSort s = new Solution148_LinkedListSort();
        ListNode h = s.sortList(head);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
