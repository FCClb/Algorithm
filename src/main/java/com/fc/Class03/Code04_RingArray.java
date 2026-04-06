package com.fc.Class03;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/10 - 01 - 10 - 11:15
 * @Description: Class03
 * @version: 1.0
 */
public class Code04_RingArray {
    public static class arrayQueue {//用数组实现双端队列
        private int[] arr;
        private int pushi;//从哪里放
        private int polli;//从哪里拿
        private int size;//控制能不能放/拿
        private final int limit;//数组的长度

        public arrayQueue(int limit) {
            this.arr = new  int[limit];
            this.pushi = 0;
            this.polli = 0;
            this.limit = limit;
        }

        public void push(int value) {//放
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {//拿
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int i) {//返回下一个位置
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
