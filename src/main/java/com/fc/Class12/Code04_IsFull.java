package Class12;

public class Code04_IsFull {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isFull(Node head) {
        if (head == null) {
            return true;
        }

        Info process = process(head);
        int height = process.height;
        int nodes = process.nodes;

        return (1 << height) - 1 == nodes;

    }

    public static class Info{
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;

        return new Info(height, nodes);
    }
}
