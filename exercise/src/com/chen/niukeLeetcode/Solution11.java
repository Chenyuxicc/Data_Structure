package com.chen.niukeLeetcode;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/6/15 on 16:23
 **/
public class Solution11 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode p = head;
        RandomListNode q = head;
        while (p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }
        p = head;
        while (p != null){
            q = p.next;
            q.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        q = head.next;
        RandomListNode head2 = q;
        while (q != null ){
            p.next = q.next;
            q.next = q.next == null ? null : q.next.next;
            p = p.next;
            q = q.next;
        }
        return head2;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(-1);
        Solution11 solution11 = new Solution11();
        RandomListNode head1 = solution11.copyRandomList(head);
        System.out.println(head1.label);
        System.out.println("1:"+head1.next);
        System.out.println("2:"+head1.random);
    }
}
