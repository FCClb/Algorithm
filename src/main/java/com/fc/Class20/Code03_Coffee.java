package com.fc.Class20;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_Coffee {

    //问题一：每个人都喝上咖啡的最短时间

    //咖啡机
    public static class Machine {
        public int timePoint;   //可以工作的时间
        public int workTime;    //泡咖啡所用时间

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }

    //自定义比较器
    public static class MachineComparator implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
        }
    }

    public static int minTIme1(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<Machine>(new MachineComparator());
        for (int i = 0; i < n; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }

        return bestTime1(drinks, a, b, 0, 0);
    }

    //问题二：所有杯子都干净的最短时间

    /**
     *
     * @param drinks    所有杯子可以开始洗的时间
     * @param wash  单杯洗干净的时间
     * @param air   挥发干净的时间（可以并行）
     * @param index 当前做决定的杯子
     * @param free  洗的机器什么时候可用
     * @return  都变干净的最早时间
     */
    private static int bestTime1(int[] drinks, int wash, int air, int index, int free) {
        if (index == drinks.length) {
            return 0;
        }
        //index号杯子 决定洗
        int selfClean1 = Math.max(drinks[index], free) + wash;
        int restClean1 = bestTime1(drinks,wash,air,index+1,selfClean1);
        int p1 = Math.max(selfClean1, restClean1);

        //index号杯子 决定挥发
        int selfClean2 = drinks[index] + air;
        int restClean2 = bestTime1(drinks, wash, air, index + 1, free);
        int p2 = Math.max(selfClean2, restClean2);

        return Math.min(p1, p2);
    }

    //动态规划版本
    public static int bestTime2(int[] drinks, int wash, int air) {
        int N = drinks.length;
        int maxFree = 0;
        for (int i = 0; i < drinks.length; i++) {
            maxFree = Math.max(maxFree, drinks[i]) + wash;
        }

        int[][] dp = new int[N + 1][maxFree + 1];

        //dp[N][...] = 0;

        for (int index = N - 1; index >= 0; index--) {
            for (int free = 0; free <= maxFree; free++) {

                int selfClean1 = Math.max(drinks[index], free) + wash;
                if (selfClean1 > maxFree) {
                    continue;
                }
                int restClean1 = dp[index + 1][selfClean1];
                int p1 = Math.max(selfClean1, restClean1);

                //index号杯子 决定挥发
                int selfClean2 = drinks[index] + air;
                int restClean2 = dp[index + 1][free];
                int p2 = Math.max(selfClean2, restClean2);

                dp[index][free] = Math.min(p1, p2);
            }
        }

        return dp[0][0];
    }

}


