package com.chen.niukeLeetcode;

import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/13 on 9:12
 **/
public class Solution8 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        slow = head;
        quick = head2;
        Stack<ListNode> stack = new Stack<>();
        while (quick != null){
            stack.push(quick);
            quick = quick.next;
        }
        while (slow != null && !stack.isEmpty()){
            quick = stack.pop();
            quick.next = slow.next;
            slow.next = quick;
            slow = slow.next.next;
        }
    }
}
