package com.chen.qiuzhaotest.aiqiyi;

import java.util.Scanner;

/**
 * @author ChenYuXi
 * @version 1.0
 * @since 2019/9/8 on 16:31
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] temp = in.nextLine().split(" ");
        int n = Integer.valueOf(temp[0]);
        int m = Integer.valueOf(temp[1]);
        double a[][]=new double[n+1][m+1];
        for(int i=1;i<=n;i++){
            a[i][0]=1;
        }
        for(int i=0;i<=m;i++){
            a[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j>=3){
                    a[i][j]=(double)(i)/(i+j)+(double)(j)/(i+j)*(double)(j-1)/(i+j-1)*((double)(i)/(i+j-2)*a[i-1][j-2]+
                            (double)(j-2)/(i+j-2)*a[i][j-3]);
                }else if(j==1){
                    a[i][j]=(double)(i)/(i+j);
                }else if(j==2){
                    a[i][j]=(double)(i)/(i+j)+(double)(j)/(i+j)*(double)(j-1)/(i+j-1)*a[i-1][j-2];
                }

            }
        }
        System.out.println(String.format("%.5f", a[n][m]));
    }
}
