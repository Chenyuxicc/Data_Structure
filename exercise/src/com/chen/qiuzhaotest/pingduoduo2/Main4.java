package com.chen.qiuzhaotest.pingduoduo2;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/1 on 16:05
 **/


public class Main4 {
    public static int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n + 1;
        int mid, count;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            count = 0;
            for (int i = 1; i <= m; i++) {
                count += (mid/i > n ? n : mid/i);
            }
            if (count >= k) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    public static void main(String[]ar){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int  k=scanner.nextInt();
        System.out.print(findKthNumber(m,n,n*m-k+1));
    }
}
