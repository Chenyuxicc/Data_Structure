package com.chen.niukeLeetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/13 on 9:58
 **/
public class ListNodeTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        ListNode h6 = new ListNode(7);
        ListNode h7 = new ListNode(8);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        h7.next = h3;
//        com.chen.swordOffer.S8_jumpFloor solution8 = new com.chen.swordOffer.S8_jumpFloor();
//        solution8.reorderList(head);
//        while (head != null){
//            System.out.println("val:"+head.val);
//            head = head.next;
//        }
//        com.chen.swordOffer.S9_jumpFloor2 solution9 = new com.chen.swordOffer.S9_jumpFloor2();
//        solution9.detectCycle(head);

        String s = "aduchst";
        ArrayList<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        Collections.reverse(a);
        System.out.println(a);
       // System.out.println(s.substring(3));
    }
}
