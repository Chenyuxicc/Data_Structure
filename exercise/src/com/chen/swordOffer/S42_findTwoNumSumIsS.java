package com.chen.swordOffer; /**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/5/20 on 10:06
 **/
import java.util.ArrayList;
public class S42_findTwoNumSumIsS {
    /**
     * find two numbers in array which their sum equal input sum
     *
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      if(array == null||array.length==0){
          return arrayList;
      }
      int plow = 0;
      int phigh = array.length-1;
      while (phigh>plow){
          int result = array[plow] + array[phigh];
          if(result == sum){
              if(arrayList.isEmpty()){
                  arrayList.add(array[plow]);
                  arrayList.add(array[phigh]);
              }else {
                  int product = array[plow]*array[phigh];
                  if(product<=arrayList.get(0)*arrayList.get(1)){
                      arrayList.remove(0);
                      arrayList.remove(1);
                      arrayList.add(array[plow]);
                      arrayList.add(array[phigh]);
                  }
              }
              plow++;
          }else if(result < sum){
              plow++;
          }else {
              phigh--;
          }
      }
      return arrayList;
    }

    public static void main(String[] args) {
        S42_findTwoNumSumIsS solution42 = new S42_findTwoNumSumIsS();
        int [] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(solution42.FindNumbersWithSum(array,10));
    }
}
