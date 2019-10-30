package com.chen.swordOffer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
/**
 * 从尾到头打印链表
 *
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    @Override
    public int hashCode(){
        Random random = new Random(47);
        int d = random.nextInt();
        return this.val+d;
    }
    @Override
    public boolean equals(Object anObject){
        return this == anObject;
    }
}
public class S4_reverseLinkedList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> a=new ArrayList<>();
//        ArrayList<Integer> a1=new ArrayList<>();
//        com.chen.swordOffer.ListNode p=listNode;
//        while(p!=null){
//            int num=p.val;
//            a.add(num);
//            p=p.next;
//        }
//        int size=a.size();
//        for (int i = size-1; i>=0 ; i--) {
//            int num=a.get(i);
//            a1.add(num);
//        }
//        return a1;
        //使用栈
        if(listNode==null){
            return null;
        }
        Stack<ListNode> stack=new Stack<>();
        ArrayList<Integer> a=new ArrayList<>();
        ListNode p=listNode;
        while(p!=null){
            stack.push(p);
            p=p.next;
        }
        while(!stack.isEmpty()){
            int num=stack.pop().val;
            a.add(num);
        }
        return a;

    }

    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        ListNode head=new ListNode(-1);
        ListNode p=head;
        for (int i = 0; i <5 ; i++) {
            ListNode p1=new ListNode(i);
            p.next=p1;
            p=p.next;
        }
        S4_reverseLinkedList s=new S4_reverseLinkedList();
        ArrayList<Integer> a2=s.printListFromTailToHead(head);
        for (int num:
           a2  ) {
            System.out.println("a2:"+num);
        }
    }
}
