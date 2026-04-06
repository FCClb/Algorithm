package com.round_1.Class01;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {
    public static void BubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = arr.length - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second] < arr[second - 1]) {
                    swap(arr, second, second - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
