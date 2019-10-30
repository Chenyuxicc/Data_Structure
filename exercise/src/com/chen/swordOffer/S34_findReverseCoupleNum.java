package com.chen.swordOffer;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/15 on 20:36
 **/
//找出一个数组中的逆序数的对数
public class S34_findReverseCoupleNum {
    private int count=0;
    public int InversePairs(int [] array) {
         if(array==null){
             return 0;
         }else{
             int right=array.length-1;
             mergeSort(array,0,right);
             return count;
         }
    }
    private void mergeSort(int[] array,int left,int right){
        int mid=(right+left)/2;
        if(left<right){
            //先分
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            //再合
            merge(array,left,mid,right);
        }
    }
    private void merge(int[] array,int left,int mid,int right){
        //辅助数组是临时数组
        int[] temp = new int[right-left+1];
        //两个指针
        int i = left;
        int j = mid+1;
        //临时数组必须只能从头开始
        int index=0;
        while (i<=mid&&j<=right){
            if(array[i]<array[j]){
                temp[index++] = array[i++];
            } else {
                //如果array[j]<array[i],此时计算的逆序数应该是前一个子数组中还剩下的而不是后一个子数组中剩下的
                count += mid-i+1;
                temp[index++] = array[j++];
            }
        }
        for (; i <=mid; i++) {
            temp[index++]=array[i];
        }
        for(;j<=right;j++){
            temp[index++]=array[j];
        }
        for (int k = left;k<=right ; k++) {
            array[k]=temp[k-left];
        }
    }

    public static void main(String[] args) {
        int [] array={364,637,341,406,747,995,234,971,571,219,993,407,416,
                366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,
                465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,
                162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,
                497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,
                259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,
                665,874,80,45,848,38,811,267,575};
        S34_findReverseCoupleNum s=new S34_findReverseCoupleNum();
        System.out.println("逆序数对为:"+s.InversePairs(array));
    }
}
