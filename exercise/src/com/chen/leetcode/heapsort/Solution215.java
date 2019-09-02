package com.chen.leetcode.heapsort;

/**
 * @author chenyuxi
 * @since 19-9-2:下午5:27
 */
/**
 * topK:找出数组中的第k大的元素
 *
 */
public class Solution215 {
//    public static void main(String[] args) {
//        int[] nums = {10,2,3,9,5,7,1};
//        Solution215 s = new Solution215();
////        System.out.println(s.findKthLargest(nums,5));
//        s.heapSort(nums,nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if(i == nums.length - 1){
//                System.out.print(nums[i]);
//            }else {
//                System.out.print(nums[i]+",");
//            }
//
//        }
//    }
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length){
            return -1;
        }else {
            return heapSort(nums,nums.length,k);
        }
    }
    /**
     * 堆排序，先建堆，再将堆定元素和最后一个元素交换，再继续堆化
     */
    private int heapSort(int[] nums , int n , int k){
        int count = nums.length;
        buildHeap(nums,count);
        for (int i = n-1; i >= 0; i--) {
            swap(nums,i,0);
            heapify(nums,i,0);
            if(k == n-i){
                return nums[n-k];
            }
        }
        return -1;
    }
    /**
     * 对数组的前n个节点堆化,建堆
     */
    private void buildHeap(int[] tree ,int n){
        int lastNode = n - 1;
        int parent = (lastNode - 1)/2;
        for (int i = parent; i >= 0 ; i--) {
            heapify(tree,n,i);
        }
    }
    /**
     * 对节点个数为n的树中的第i个节点进行堆化
     */
    private void heapify(int[] tree,int n,int i){
        //有递归就要考虑出口条件
        if(i >= n){
            return;
        }
        //找出节点i的两个孩子节点
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        //max存的是节点的编号
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        //如果最大值不是i则将i和max交换
        if(max != i){
            swap(tree,max,i);
            //再对已经交换节点进行递归堆化
            heapify(tree,n,max);
        }
    }
    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
