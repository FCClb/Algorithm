package com.fc.Class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/11 - 01 - 11 - 11:28
 * @Description: Class03
 * @version: 1.0
 */
public class Code07_TwoQueueImplementStack {
    /*
    如何用队列结构实现栈结构
     */
    public static class TwoQueueStack<T> {
        public Queue<T> A;
        public Queue<T> B;

        public TwoQueueStack() {
            this.A = new LinkedList<>();
            this.B = new LinkedList<>();
        }

        public void push(T value) {
            A.offer(value);
        }

        public T poll() {
            while (A.size() > 1) {
                B.offer(A.poll());
            }
            T ans = A.poll();
            Queue<T> tmp = A;
            A = B;
            B = tmp;
            return ans;
        }

        public T peek() {
            while (A.size() > 1) {
                B.offer(A.poll());
            }
            T ans = A.poll();
            B.offer(ans);
            Queue<T> tmp = A;
            A = B;
            B = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return A.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueueStack myStack = new TwoQueueStack();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("出错了");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("出错了");
                        break;
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("出错了");
                        break;
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("出错了");
                        break;
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
