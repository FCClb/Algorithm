package com.fc.Class03;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/10 - 01 - 10 - 11:09
 * @Description: Class03
 * @version: 1.0
 */
public class Code02_DeleteGivenValue {
    public class Node {//单链表 节点
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node removeValue(Node head, int value) {//删除链表中所有给定值
        while (head != null) {//边界条件 让head来到第一个不用删的位置
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {//让cur.next不断指向下一个不用删的节点
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
