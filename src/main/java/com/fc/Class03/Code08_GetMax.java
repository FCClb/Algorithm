package com.fc.Class03;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/12 - 01 - 12 - 11:24
 * @Description: Class03
 * @version: 1.0
 */
public class Code08_GetMax {
    //求arr中的最大值
    public static int getMax(int[] arr, int L, int R) {
        return process(arr, L, R);
    }

    //arr[L...R]范围上求最大值
    public static int process(int[] arr, int L, int R) {
        //base case   arr[L...R] 范围上只有一个数
        if (L == R) {
            return arr[L];
        }
        //L...R上不只一个数
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
