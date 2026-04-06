package Class12;

public class Code03_IsBalanced {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        boolean isbalanced = true;
        if (!leftInfo.isBalanced) {
            isbalanced = false;
        }
        if (!rightInfo.isBalanced) {
            isbalanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isbalanced = false;
        }

        return new Info(isbalanced, height);
    }
}
