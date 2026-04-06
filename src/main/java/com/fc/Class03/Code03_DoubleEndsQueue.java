package com.fc.Class03;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/9 - 01 - 09 - 11:11
 * @Description: Class03
 * @version: 1.0
 */
public class Code03_DoubleEndsQueue {
    public static class doubleNode<T> {//双向链表节点
        public T value;
        public doubleNode<T> last;
        public doubleNode<T> next;

        public doubleNode(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {//用双向链表实现双端队列
        public doubleNode<T> head;
        public doubleNode<T> tail;

        public void addFromHead(T value) {
            doubleNode<T> cur = new doubleNode<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }
        public void addFromBottom(T value) {
            doubleNode<T> cur = new doubleNode<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            doubleNode<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }
        public T popFromBottom() {
            if (head == null) {
                return null;
            }
            doubleNode<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                cur.last= null;
                tail.next = null;
            }
            return cur.value;
        }
    }
}
