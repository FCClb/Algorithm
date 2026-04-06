package Class09;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/10 - 02 - 10 - 9:59
 * @Description: Class09
 * @version: 1.0
 */
public class Code01_LinkedListMid {
    /*单链表求中点*/
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static Node midOrUpMidNode(Node head) {//返回中点（偶数个节点），或上中点（奇数个节点）
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //链表有3个点或以上
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidNode(Node head) {//返回中点或下中点
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrUpMidPreNode(Node head) {//返回中点或上中点 的 前一个节点
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownMidPreNode(Node head) {//返回中点或下中点 的 前一个节点
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
