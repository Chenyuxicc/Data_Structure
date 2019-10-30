package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/30 on 15:45
 **/
public class S14_reverseLinkedlist {
    public static ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode h=head;
        ListNode p=h.next;
        h.next=null;
        ListNode l=p;
        while(p!=null){
            l=p.next;
            p.next=h;
            h=p;
            p=l;
        }
        return h;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
//        head.next=new com.chen.swordOffer.ListNode(2);
//        head.next.next=new com.chen.swordOffer.ListNode(3);
//        head.next.next.next=new com.chen.swordOffer.ListNode(4);
        ListNode p=ReverseList(head);
        while(p!=null){
            System.out.println("n:"+p.val);
            p=p.next;
        }
    }
}
