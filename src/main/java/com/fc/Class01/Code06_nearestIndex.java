package com.fc.Class01;

/**
 * @Auther: Fc.Clb
 * @Date: 2024/12/27 -  12 - 27 - 10:19
 * @Description: Class01
 * @version: 1.0
 */
public class Code06_nearestIndex {
    public static int nearestNoLessIndex(int[] arr, int value) {//二分法 有序数组中找到>=某数最左的位置
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int nearestNoMoreIndex(int[] arr, int value) {//二分法 有序数组中找到<=某数最右的位置
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }
}
