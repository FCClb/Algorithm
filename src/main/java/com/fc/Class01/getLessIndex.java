package com.fc.Class01;

/**
 * @Auther: Fc.Clb
 * @Date: 2024/12/27 -  12 - 27 - 10:51
 * @Description: Class01
 * @version: 1.0
 */
public class getLessIndex {
    public static int getLessIndex(int[] arr) {//二分法 找局部最小值位置
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
