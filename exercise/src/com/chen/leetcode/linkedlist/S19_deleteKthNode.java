package com.chen.leetcode.linkedlist;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/30 on 15:35
 **/
public class S19_deleteKthNode {
    /**
     * 快慢指针，但是需要考虑极端情况，n == length 此时单独处理
     * 以及 n > length此时直接返回Null
     * 时间复杂度 O(n)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        int j = 0;
        while (fast != null){
            fast = fast.next;
            j++;
        }
        if(j == n){
            return head.next;
        }else if(j < n){
            return null;
        }
        fast = head;
        while (fast != null && i < n){
            fast = fast.next;
            i++;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
