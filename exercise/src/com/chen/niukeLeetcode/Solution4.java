package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/11 on 9:09
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution4 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        return mergeSort(sortList(head),sortList(midNext));
    }
    public ListNode getMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while(quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head1,ListNode head2){
        ListNode head = new ListNode(-1);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = head;
        while (cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return head.next;
    }

}
