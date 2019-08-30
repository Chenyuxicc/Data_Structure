package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/30 on 14:28
 **/

public class Solution13 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        ListNode kn=head;
        ListNode p=head;
        for(int i=0;i<k;i++){
            kn=kn.next;
        }
        while(kn!=null){
            p=p.next;
            kn=kn.next;
        }
        return p;
    }
}
