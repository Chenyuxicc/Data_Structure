package com.chen.qiuzhaotest.BIGO;

import java.util.Stack;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/2 on 20:14
 **/
class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}
public class Main1 {
    public static boolean isPar(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        ListNode p = head;
        int count = 0;
        while (p != null){
            stack.push(p);
            p = p.next;
            count ++;
        }
        count /= 2;
        while (!stack.isEmpty() && count > 0){
            p = stack.pop();
            if(p.val != temp.val){
                return false;
            }else {
                temp = temp.next;
            }
            count--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(2);
        h1.next=h2;
        h2.next=h3;
        System.out.println(isPar(h1));
    }
}
