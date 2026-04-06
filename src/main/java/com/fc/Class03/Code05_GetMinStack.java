package com.fc.Class03;

import java.util.Stack;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/10 - 01 - 10 - 11:17
 * @Description: Class03
 * @version: 1.0
 */
public class Code05_GetMinStack {
    /*
    实现一个特殊的栈，实现pop，push功能外，实现getMin功能
     */
    public static class MyStack1{//方法1，数据栈和最小栈不同步
        private Stack<Integer> stackData;//数据栈
        private Stack<Integer> stackMin;//最小栈

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty() || newNum <= this.getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = stackData.pop();
            if (value == this.getMin()) {
                stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return stackMin.peek();
        }
    }

    public static class MyStack2 {//方法2，数据栈和最小栈同步
        private Stack<Integer> stackData;//数据栈
        private Stack<Integer> stackMin;//最小栈

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty() || newNum < getMin()) {
                stackMin.push(newNum);//小于，放入新数
            } else {
                stackMin.push(stackMin.peek());//大于等于，再次压入原栈顶（最小值）
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return stackMin.peek();
        }
    }

}
