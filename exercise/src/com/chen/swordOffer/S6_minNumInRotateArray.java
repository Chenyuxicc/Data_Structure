package com.chen.swordOffer;

/**
 * @Vesion 1.0
 * @Author Chenyuxi
 * @Date 2019/3/27 on 10:21
 **/
public class S6_minNumInRotateArray {
        public int minNumberInRotateArray(int [] array) {
            if(array.length==0){
                return 0;
            }
            int left=0;
            int right=array.length-1;
            int mid=0;
            if(array[left]>=array[right]){
                while((left+1)!=right){
                    mid=(left+right)/2;
                    if(array[left]<=array[mid]){
                        left=mid;
                    }else {
                        right=mid;
                    }
                }
                mid=left+1;
            }else{
                mid=0;
            }

            return array[mid];
        }
        public static void main(String[] args) {
            int[] array1={3,4,5,1,2};
            int[] array2={3,4,5,5,5};
            int[] array3={2,3,4,5,2};
            S6_minNumInRotateArray s=new S6_minNumInRotateArray();
            int a=s.minNumberInRotateArray(array1);
            System.out.println("hello");
            System.out.println("min:"+a);
        }
}

