package com.fc.Class01;

/**
 * 二分法 查找
 */
public class Code05_Exist {
    public static boolean exist(int[] sortedArr, int num) {//有序数组 二分法 查找是否存在某数
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = L + ((R - L) >> 1);

        while (L < R) {
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return sortedArr[L] == num;
    }
}
