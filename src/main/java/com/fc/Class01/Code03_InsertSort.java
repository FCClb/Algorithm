package com.fc.Class01;

/**
 * 插入排序
 */
public class Code03_InsertSort {
    public static void InsertSort(int[] arr) {//插入排序
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {//0~1排序   0~2排序   0~3排序......
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
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
