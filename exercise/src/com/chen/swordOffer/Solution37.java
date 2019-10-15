package com.chen.swordOffer; /**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/17 on 13:26
 **/
/**
 *查找一个数在排序数组中出现的次数
 */
public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        if(array==null){
            return 0;
        }
        if(array.length==0){
            return 0;
        }
        Integer index = findK(array,0,array.length-1,k);
        if (index == null){
            return 0;
        }
        int numOfK = 0;
        int leftK = index;
        int rightK = index+1;
        while(leftK>=0&&array[leftK]==k){
            numOfK++;
            leftK--;
        }
        while(rightK<=array.length-1&&array[rightK]==k){
            numOfK++;
            rightK++;
        }
        return numOfK;
    }
    public Integer findK(int[] array,int left,int right,int k){
        //可能会有在数组中不存在的情况，此时应该考虑到，然后返回值
        if(left == right && array[left]!=k){
            return null ;
        }
        int mid = (left+right)/2;
        if(array[mid] == k){
            return mid;
        }
        else {
            if(array[mid]<k){
                return findK(array,mid+1,right,k);
            }else {
                return findK(array,left,mid,k);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,3,3,4,5,6};
        Solution37 solution37 = new Solution37();
        System.out.println(solution37.findK(array,0,array.length-1,1));
        System.out.println(solution37.GetNumberOfK(array,1));
    }
}
