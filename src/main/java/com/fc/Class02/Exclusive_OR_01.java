package com.fc.Class02;

/**
 * @Auther: Fc.Clb
 * @Date: 2024/12/27 -  12 - 27 - 11:29
 * @Description: Class02
 * @version: 1.0
 */
public class Exclusive_OR_01 {//异或运算
    public static void main(String[] args) {
        //不用额外变量 交换两个数
        int num1 = 17;
        int num2 = 34;
        System.out.println("交换前："+num1 + " ," + num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("交换后："+num1 + " ," + num2);

        System.out.println("------------------------------------------------");
        int[] arr1 = {1, 4, 1, 2, 4, 4, 3, 4, 2, 1, 1, 3, 4, 3, 4};// 3 出现奇数次
        printArr(arr1);
        printOddTimesNum1(arr1);

        System.out.println("------------------------------------------------");
        int[] arr2 = {6, 10, 6, 6, 4, 4, 12, 12, 12, 12, 3, 3};
        printArr(arr2);
        printOddTimesNum2(arr2);
    }

    public static void printArr(int[] arr) {//打印数组
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.print("这个数组为：");
        for (int i = 0; i <= arr.length-1; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]+"]");
            }
        }
        System.out.println();
    }

    public static void printOddTimesNum1(int[] arr) {
        /*
        一个数组中有一种数出现奇数次，其他数都出现了偶数次，
        找到这个出现奇数次的数 并打印它
        提示：偶数个 数 ^ 结果是0  ； 奇数个 数 ^ 结果是它本身
         */
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println("出现了奇数次的数是：" + eor);
    }

    public static void printOddTimesNum2(int[] arr){
        /*
        一个数组中有两种数出现奇数次，其他数都出现了偶数次，
        找到这两个出现奇数次的数(设 num1 num2) 并打印它们
        提示：偶数个 数 ^ 结果是0  ； 奇数个 数 ^ 结果是它本身
         */
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];//eor = num1 ^ num2
        }
        int rightOne = eor & (-eor);//提取出eor最右侧的1--->这一位上有1说明 num1 和 num2 这位上必不同
        int num1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) != 0) {//只与这一位上是 1 的数^
                num1 ^= arr[i];
            }
        }
        int num2 = num1 ^ eor;
        System.out.println("这两个数是：" + num1 + " ," + num2);
    }
}
