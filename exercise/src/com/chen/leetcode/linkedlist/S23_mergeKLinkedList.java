package com.chen.leetcode.linkedlist;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/31 on 9:19
 * 题：合并K个有序链表
 **/
public class S23_mergeKLinkedList {
    /**
     * 思路：先拆，拆成只有两个或只有一个的，再两两合并，直到只剩一个链表
     * 如果是类似于数组那样拆分，需要创建新的list作为参数传入，如果使用额外的空间，原地归并也是可以做到的
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null){
            return null;
        }
        int length = lists.length;
        int interval = 1;
        while (interval < length){
            for (int i = 0; i + interval < length; i += 2*interval) {
                lists[i] = mergeTwoLists(lists,i,i+interval);
            }
            interval *= 2;
        }
        return length != 0 ? lists[0] : null;

    }

    public ListNode mergeTwoLists(ListNode[] lists , int h1 , int h2){
        ListNode head1 = lists[h1];
        ListNode head2 = lists[h2];
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return head.next;
    }
}
