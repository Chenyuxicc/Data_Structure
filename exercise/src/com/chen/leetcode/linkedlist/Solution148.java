package com.chen.leetcode.linkedlist;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:09
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution148 {

    /**
     * 1.递归的是quickSort，而不是partition
     * 2.end的取值为null，要确定最后一个p2指向的节点该在的位置
     * 3.链表的交换可以只交换值val
     * 4.最后一定要交换temp和p1，重要
     * 5.思路：两个指针,p1,p2,如果p2的值小于temp，就交换p2的值和p1后面的那个节点的值，保证p1及其之前的值都小于key，p1后面到p2的节点得值都小于temp
     *   p2的值小于temp就交换，并需要先将p1 = p1.next，再后移p2,否则只后移p2。
     */

    public ListNode sortList(ListNode head){
        quickSort(head,null);
        return head;
    }

    //快速排序
    private void quickSort(ListNode head,ListNode end) {
        if(head != end){
            ListNode partition = partition(head,end);
            quickSort(head,partition);
            quickSort(partition.next,end);
        }
    }
    private ListNode partition(ListNode head,ListNode end){
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != end){
            //只交换数值
//            System.out.println("p2.val:" + p2.val);
//            System.out.println("head.val:" + head.val);
            if(p2.val < head.val){
                p1 = p1.next;
                swap(p1,p2);
            }
            p2 = p2.next;
        }
        swap(p1,head);
        return p1;
    }
    private void swap(ListNode p1,ListNode p2){
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(5);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(7);
        ListNode h5 = new ListNode(9);
        ListNode h6 = new ListNode(0);
        ListNode h7 = new ListNode(1);
        head.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        Solution148 s = new Solution148();
        ListNode h = s.sortList(head);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}
