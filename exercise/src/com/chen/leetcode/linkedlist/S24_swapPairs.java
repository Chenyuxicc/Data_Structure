package com.chen.leetcode.linkedlist;

import java.util.List;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/31 on 21:00
 **/
public class S24_swapPairs {
    /**
     * 想使用p1和p2来表示需要交换的两个节点，但是又必须引入temp来保存p2的next
     * 这样就不能直接遍历了
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(-1);
        if(head == null){
            return null;
        }
        ListNode p = h;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode temp = null;
        if(p2 == null){
            return head;
        }

        while (p1 != null && p2 != null){
            temp = p2.next;
            p.next = p2;
            p = p.next;
            p.next = p1;
            p = p.next;
            p.next = null;
            if(temp == null){
                break;
            }else {
                p1 = temp;
                p2 = p1.next;
                if(p2 == null){
                    p.next = p1;
                    break;
                }
            }
        }
        return h.next;
    }
    /**
     * 使用一个指针来遍历，再使用两个指针分别指向需要交换的节点
     */
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
//        ListNode h4 = new ListNode(4);
        h1.next = h2;
        h2.next = h3;
//        h3.next = h4;
        ListNode result = swapPairs(h1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
