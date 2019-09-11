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
}
