package Class12;

public class Code06_MaxDistance {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);

        return new Info(maxDistance, height);
    }
}
