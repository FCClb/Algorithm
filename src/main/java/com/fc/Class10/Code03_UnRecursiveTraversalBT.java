package Class10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {
    /*二叉树先序，后序，中序的实现，非递归方式*/

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void pre(Node head) {//先序
        System.out.println("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void in(Node cur) {//中序
        System.out.println("in-order: ");
        if (cur != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {//将左边界都压入栈
                    stack.push(cur);
                    cur = cur.left;
                } else {//弹出时将右子节点作cur
                    cur = stack.pop();
                    System.out.println(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }

    public static void pos(Node head) {//后序
        System.out.println("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);//按照 头 右 左 入栈stack2
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {//stack2弹出顺序：左 右 头
                System.out.println(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }
}
