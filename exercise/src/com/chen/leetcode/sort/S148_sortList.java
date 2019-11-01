package com.chen.leetcode.sort;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

}
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/1 on 20:57
 **/
public class S148_sortList {
    public ListNode sortList(ListNode head){
        if(head != null && head.next != null){
            ListNode head1 = head;
            ListNode head2 = head.next;
            while (head2 != null && head2.next != null){
                head1 = head1.next;
                head2 = head2.next.next;
            }
            //使用快慢指针二分之后，需要将前一段和后一段断开
            ListNode temp = head1;
            head2 = head1.next;
            temp.next = null;
            ListNode h1 = sortList(head);
            ListNode h2 = sortList(head2);
            return mergeLinkedList(h1 , h2);
        }
        return head;
    }
    public ListNode mergeLinkedList(ListNode head1 , ListNode head2){
        ListNode h = new ListNode(-1);
        ListNode p = h;
        while (head1!= null && head2 != null){
            if(head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        p.next = head1 == null ? head2 : head1;
        return h.next;
    }
}
