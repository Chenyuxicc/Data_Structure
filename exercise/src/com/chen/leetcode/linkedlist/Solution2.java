package com.chen.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * @author chenyuxi
 * @since 19-9-10:下午6:21
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        while (l1 != null && l2 != null){
            arr1.add(l1.val);
            l1 = l1.next;
            arr2.add(l2.val);
            l2 = l2.next;
        }
        while (l1 != null){
            arr1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            arr2.add(l2.val);
            l2 = l2.next;
        }
        int i = 0;
        int j = 0;
        int c = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size()){
            int t = arr1.get(i) + arr2.get(j) + c;
            if(t >= 10){
                c = 1;
                t -= 10;
            }else {
                c = 0;
            }
            result.add(t);
            i++;
            j++;
        }
        while (i < arr1.size()){
            int t = arr1.get(i) + c;
            if(t >= 10){
                c = 1;
                t -= 10;
            }else {
                c = 0;
            }
            result.add(t);
            i++;
        }
        while (j < arr2.size()){
            int t = arr2.get(j) + c;
            if(t >= 10){
                c = 1;
                t -= 10;
            }else {
                c = 0;
            }
            result.add(t);
            j++;
        }
        if(c > 0){
            result.add(c);
        }
        ListNode result1 = new ListNode(result.get(0));
        ListNode p = result1;
        for (int k = 1; k <  result.size() ; k++) {
            ListNode node = new ListNode(result.get(k));
            p.next = node;
            p = p.next;
        }
        return result1;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode p = l1,q = l2,cur = head;
        //进位
        int carry = 0;
        //为空的时候val为0
        while (p != null || q != null){
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = carry + x + y;
            //算进位
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            //p和q判断是否为空用的是或,因此需要判断
            if(p != null){
                p = p.next;
            }
            if(q != null){
                q = q.next;
            }
        }
        //遍历完之后carry有可能有值
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
