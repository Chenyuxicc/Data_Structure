package com.chen.swordOffer2;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/15 on 11:34
 **/
public class S11_minNum {
    public int get(int[] array){
        int before = 0;
        int after = array.length - 1;
        int mid = before;
        //如果没有进行旋转，不满足循环条件返回第一个
        while (array[before] >= array[after]){
            if(before + 1 == after){
                mid = after;
                break;
            }
            if(array[mid] == array[before] && array[mid] == array[after]){
                return minInOrder(array,before,after);
            }
            mid = ( before + after ) / 2;
            if(array[mid] >= array[before]){
                before = mid;
            }else if(array[mid] <= array[after]){
                after = mid;
            }
        }
        return array[mid];
    }
    //如果三个指针指向的都一样，才会顺序判断，此时最小值一定是在中间的
    public int minInOrder(int[] array,int before,int after){
        int result = array[before];
        for (int i = before + 1; i <= after; i++) {
            if(array[i] < result){
                result = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S11_minNum s = new S11_minNum();
        int[] array = {3,4,5,1,2};
        int[] array1 = {1,1,1,0,1};
        int[] array2 = {1};
        System.out.println(s.get(array));
        System.out.println(s.get(array1));
        System.out.println(s.get(array2));
    }
}
