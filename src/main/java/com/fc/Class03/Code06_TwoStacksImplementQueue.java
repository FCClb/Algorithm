package com.fc.Class03;

import java.util.Stack;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/11 - 01 - 11 - 11:03
 * @Description: Class03
 * @version: 1.0
 */
public class Code06_TwoStacksImplementQueue {
    /*
    如何用栈结构实现队列结构
     */
    public static class TwoStacksQueue {//用两个栈实现队列结构
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        //push栈向pop栈 倒数据
        private void pushToPop() {
            if (stackPop.empty()) {//只有当Pop栈是空的时候才倒数据
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
