package com.fc.Class20;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_Coffee {

    public static class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {

        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
        }
    }

    public static int minTIme2(int[] arr, int n, int a, int b) {
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

        return process(drinks, a, b, 0, 0);
    }

    private static int process(int[] drinks, int a, int b, int i, int i1) {

        return 0;
    }
}
