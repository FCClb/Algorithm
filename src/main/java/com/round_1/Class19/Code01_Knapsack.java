package com.round_1.Class19;

public class Code01_Knapsack {

    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length == 0 || v.length == 0 || w.length != v.length) {
            return 0;
        }

        return process(w, v, 0, bag);
    }

    private static int process(int[] w, int[] v, int index, int bag) {
        if (index == w.length) {
            return 0;
        }
        if (bag < 0) {
            return -1;
        }

        int p1 = process(w, v, index + 1, bag);

        int p2 = 0;
        int next = process(w, v, index + 1, bag - w[index]);
        if (next != -1) {
            p2 = v[index] + next;
        }

        return Math.max(p1, p2);

    }

}
