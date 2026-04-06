package com.fc.Class01;

public class Code04_SortTestCode {//对数器测试数组排序

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean isSucceed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);

            Code01_SelectionSort.SelectionSort(arr1);
            Code02_BubbleSort.BubbleSort(arr2);
            Code03_InsertSort.InsertSort(arr3);

            if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3)) {
                isSucceed = false;
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                break;
            }
        }
        System.out.println(isSucceed ? "结果正确" : "出错了");
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {//返回一个随机数组
        //Math.random()     [0,1)所有小数，等概率返回一个
        //Math.random()*N     [0,N)所有小数，等概率返回一个
        //(int)(Math.random()*N)     [0,N-1]所有整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
            //值随机，且有正有负有0
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {//复制数组
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void printArray(int[] arr) {//打印数组
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        boolean isSucceed = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                isSucceed = false;
            }
        }
        return isSucceed;
    }

}
