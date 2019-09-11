package com.chen.leetcode.linkedlist;

/**
 * @author chenyuxi
 * @since 19-9-10:上午10:58
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
         ListNode p = head;
         ListNode before = null;
         ListNode head2 = null;
         ListNode after ;
         ListNode pre = null;
         ListNode next;
         int count = 0;
         while (p != null){
             if(count == m-2){
                 before = p;
             }
             if(count == m-1){
                 after = p;
                 while (count < n){
                     next = p.next;
                     p.next = pre;
                     pre = p;
                     p = next;
                     count++;
                 }
                 head2 = pre;
                 if(before != null){
                     before.next = pre;
                 }
                 after.next = p;
                 if(p == null){
                     break;
                 }
             }
             p = p.next;
             count++;
         }
         if(before != null){
             return head;
         }
         return head2;
    }
}
