package com.fc.Class02;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther: Fc.Clb
 * @Date: 2024/12/29 -  12 - 29 - 11:17
 * @Description: Class02
 * @version: 1.0
 */
public class Exclusive_OR_02 {
    public static int onlyKTimes(int[] arr, int K, int M) {//保证 M>1 && K<M
        /*
        一个数组中只有一种数出现K次，其他数都出现了M次，
        找到这个出现K次的数 并打印它
         */
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                if (((num >> i) & 1) != 0) {//
                    t[i]++;
                }
                //这个if 可以优化为：
                //t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % M == 0) {
                continue;
            }
            if (t[i] % M == K) {//说明num在i位上有1
                ans |= (1 << i);
            } else return -1;
        }
        if (ans == 0) {
            int count = 0;
            for (int num:arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != K) {
                return -1;
            }
        }
        return ans;
    }

    public static int test(int[] arr, int K, int M) {//常规解法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == K) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {//对数器测试
        int kinds = 10;
        int range = 200;
        int testTime = 1000000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1;//a [1,9]
            int b = (int) (Math.random() * max) + 1;//b [1,9]
            int K = Math.min(a, b);
            int M = Math.max(a, b);
            if (K == M) {
                M++;
            }
            int[] arr = randomArray(kinds, range, K, M);
            int ans1 = test(arr, K, M);
            int ans2 = onlyKTimes(arr, K, M);
            if (ans1 != ans2) {
                System.out.println("出错了");
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("测试结束");
    }

    public static int[] randomArray(int maxKinds, int range, int K, int M) {//返回一个随机数组
        int KtimeNum = randomNumber(range);//出现了K次的数
        int times = Math.random() < 0.5 ? K : ((int) (Math.random() * (M - 1) + 1));
        int numKinds = (int) (Math.random() * maxKinds) + 2;//数的种类
        int[] arr = new int[times + (numKinds - 1) * M];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = KtimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(KtimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);//其他出现M次的数
            } while (set.contains(curNum));//保证不重复
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < M; i++) {
                arr[index++] = curNum;
            }
        }//arr填好了
        for (int i = 0; i < arr.length; i++) {//打乱数组arr
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    public static int randomNumber(int range) {//返回随机数 范围[-range,range]
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }
}
