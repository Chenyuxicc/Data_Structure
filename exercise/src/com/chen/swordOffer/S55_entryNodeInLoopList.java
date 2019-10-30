package com.chen.swordOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/28 on 10:56
 **/
public class S55_entryNodeInLoopList {
    /**
     * to judge a LinkedList has a loop or not
     * if it has a loop,find the entrance of loop
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
       if(pHead == null){
           return null;
       }
       ListNode p = pHead;
       Set<ListNode> set = new HashSet<>();
       while(p != null && !set.contains(p)){
           set.add(p);
           p = p.next;
       }
       return p;
    }
    /**
     * use two pointer
     *
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead){
        if(pHead == null){
            return null;
        }
        ListNode pSlow = pHead.next;
        if(pSlow == null){
            return null;
        }
        ListNode pFast = pSlow.next;
        if(pFast == null){
            return null;
        }
        /**
         * notice the initial condition every variable
         */
        while (pFast != null && pFast.next != null && pFast != pSlow){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        if(pFast == null || pFast.next == null){
            /**
             * com.chen.swordOffer.ListNode doesnot loop
             */
            return null;
        }else {
            int numberOfNode = 0;
            pSlow = pSlow.next;
            numberOfNode++;
            while (pSlow != pFast){
                pSlow = pSlow.next;
                numberOfNode++;
            }
            pSlow = pHead;
            pFast = pHead;
            /**
             * number of node minus number of loop
             * remainder is the number of step pSlow should go
             */
            while (numberOfNode != 0){
                pFast = pFast.next;
                numberOfNode--;
            }
            while (pFast != pSlow){
                pFast = pFast.next;
                pSlow = pSlow.next;
            }
            return pSlow;
        }
    }

}
