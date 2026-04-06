package Class10;

public class Code02_RecursiveTraversalBT {
    /*二叉树先序，后序，中序的实现，递归方式*/

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {//先序
        if (head == null) {
            return;
        }
        System.out.println(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(Node head) {//中序
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value + " ");
        in(head.right);
    }

    public static void pos(Node head) {//后序
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value + " ");
    }

}
