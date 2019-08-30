package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/14 on 15:19
 **/
public class Solution9 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode quick = head;
        boolean flag = false;
        int i = 0;
        while (quick.next != null && quick.next.next != null){
//            System.out.print(i+":");
//            System.out.print("slow.val:"+slow.val);
//            System.out.println("quick.val:"+quick.val);
            slow = slow.next;
            quick = quick.next.next;
            i++;
            if(slow == quick){
                flag = true;
                break;
            }
        }
        if(flag){
            slow = head;
            while (slow != quick){
                slow = slow.next;
                quick = quick.next;
            }
            return slow;
        }else {
            return null;
        }
//        return head;
    }
}
