package com.chen.swordOffer; /**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/15 on 21:44
 **/
/**
 *找出两个链表的第一个公共节点
 */
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //先找出两个链表的长度
        ListNode p = pHead1;
        ListNode q =pHead2;
        int length1 = 0;
        int length2 = 0;
        int difference = 0;
        if(pHead1==null || pHead2 == null){
            return null;
        }
        while(p != null){
            length1++;
            p=p.next;
        }
        while(q != null){
            length2++;
            q = q.next;
        }
        p = pHead1;
        q = pHead2;
        difference = length1-length2;
        if(difference > 0){
            while (difference > 0){
                p = p.next;
                difference--;
            }
        }else if(difference < 0){
            while (difference < 0){
                q=q.next;
                difference++;
            }
        }
        while(p!=null&&q!=null){
            if(p == q){
                return p;
            }else {
                p = p.next;
                q = q.next;
            }
        }
        return null;
    }
}
