package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/31 on 12:19
 **/
public class S15_MergeTwoLinkedList {
    public static ListNode Merge(ListNode list1,ListNode list2) {
       if(list1==null){
           return list2;
       }
       if(list2==null){
           return list1;
       }
       ListNode head=null;
       ListNode h=head;
       ListNode p=list1;
       ListNode q=list2;
       if(p.val<q.val){
           head=p;
           h=head;
           p=p.next;
       }else{
           head=list2;
           h=head;
           q=q.next;
       }
       while(p!=null&&q!=null){
          if(p.val<q.val){
              h.next=p;
              h=p;
              p=p.next;
          }else{
              h.next=q;
              h=q;
              q=q.next;
          }
       }
       if(p!=null){
           h.next=p;
       }
       else if (q!=null){
           h.next=q;
       }else {
           h.next=null;
       }
       return head;
    }
    public static void main(String[] args) {
        ListNode h=null;
//        com.chen.swordOffer.ListNode h=new com.chen.swordOffer.ListNode(1);
//        h.next=new com.chen.swordOffer.ListNode(3);
//        h.next.next=new com.chen.swordOffer.ListNode(5);

        ListNode h1=null;
//        com.chen.swordOffer.ListNode h1=new com.chen.swordOffer.ListNode(2);
//        h1.next=new com.chen.swordOffer.ListNode(2);
//        h1.next.next=new com.chen.swordOffer.ListNode(4);

        ListNode p=Merge(h,h1);
        while(p!=null){
            System.out.println("n:"+p.val);
            p=p.next;
        }

    }
}
