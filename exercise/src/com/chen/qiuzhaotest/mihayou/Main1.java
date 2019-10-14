package com.chen.qiuzhaotest.mihayou;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/10/10 on 18:41
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            if(num == 0){
                count++;
            }
            array[i] = num;
        }
        int numOfZero = count;
        Arrays.sort(array);
        for (int i = count; i < N-1; i++) {
            if(array[i + 1] - array[i] > 1){
                count = count - (array[i + 1] - array[i] - 1);
            }
        }
        if(count >= 0){
            System.out.println("YES+" + numOfZero);
        }else {
            System.out.println("NO+" + numOfZero);
        }
    }
}
