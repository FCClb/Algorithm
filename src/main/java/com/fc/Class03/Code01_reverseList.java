package com.fc.Class03;

/**
 * @Auther: Fc.Clb
 * @Date: 2024/12/30 -  12 - 30 - 11:38
 * @Description: Class03
 * @version: 1.0
 */
public class Code01_reverseList {
    public class Node {//单链表 节点
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head) {//单链表的反转
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class doubleNode {//双链表 节点
        public int value;
        public doubleNode last;
        public doubleNode next;

        public doubleNode(int value) {
            this.value = value;
        }
    }

    public static doubleNode reverseLinkedDoubleList(doubleNode head) {//双向链表的反转
        doubleNode pre = null;
        doubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
