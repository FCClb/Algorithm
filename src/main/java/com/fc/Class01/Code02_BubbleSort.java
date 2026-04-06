package com.fc.Class01;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {
    public static void BubbleSort(int[] arr) {//冒泡排序
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {//判断第二个数和第一个数，谁大谁往后
                if (arr[second] < arr[second - 1]) {
                    swap(arr, second, second - 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int i, int j) {//交换
        int num = arr[i];
        arr[i] = arr[j];
        arr[j] = num;
    }
}
