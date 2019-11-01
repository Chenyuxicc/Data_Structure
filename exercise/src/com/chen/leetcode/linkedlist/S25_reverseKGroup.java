package com.chen.leetcode.linkedlist;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/11/1 on 9:17 end 10:35
 **/
public class S25_reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode p = h.next;
        ListNode fast = null;
        ListNode slow = null;
        ListNode pre1 = h;
        while (p != null){
            int t = k;
            fast = p;
            slow = p;
            while (fast != null && t > 1){
                fast = fast.next;
                --t;
            }
            if(t > 1 || fast == null){
                break;
            }else {
                ListNode temp1 = slow;
                p = fast.next;
                fast.next = null;
                ListNode pre = null;
                while (slow != null){
                    ListNode next = slow.next;
                    slow.next = pre;
                    pre = slow;
                    slow = next;
                }
                pre1.next = fast;
                pre1 = temp1;
                temp1.next = p;
            }
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;

        ListNode r = reverseKGroup(h1,3);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }
    }
}
