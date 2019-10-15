package com.chen.niukeLeetcode;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/12 on 20:37
 **/
public class Solution5 {
    public ListNode insertionSortList(ListNode head) {
        ListNode headNode = new ListNode(-1);
        if(head == null || head.next == null){
            return head;
        }
        headNode.next = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null){
            ListNode next = cur.next;
            ListNode p = headNode.next;
            while (p != null){
                if(p.next == null && cur.val >= p.val){
                    System.out.println("cur.val:"+cur.val);
                    System.out.println("p.val:"+p.val);
                    p.next = cur;
                    cur.next = null;
                    break;
                }else if(p.next != null && p.val < cur.val && p.next.val >cur.val){
                    cur.next = p.next;
                    p.next = cur;
                    break;
                }else if(cur.val < p.val){
                    headNode.next = cur;
                    cur.next = p;
                    break;
                }
                p = p.next;
            }
            cur = next;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(68);
        ListNode h1 = new ListNode(27);
        ListNode h2 = new ListNode(73);
        ListNode h3 = new ListNode(89);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = null;
        Solution5 solution5 = new Solution5();
        head = solution5.insertionSortList(head);
        while (head != null){
            System.out.println("node.val:"+head.val);
            head = head.next;
        }
    }
}
