package Class13;

public class Code02_MaxSubBSTHead {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node maxSubBSTHead(Node head) {
        if (head == null) return null;
        return process(head).maxSubBSTHead;
    }

    public static class Info {
        public Node maxSubBSTHead;
        public int maxSubBSTSize;
        public int min;
        public int max;

        public Info(Node maxSubBSTHead, int maxSubBSTSize, int min, int max) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static Info process(Node x) {
        if (x == null) return null;

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int min = x.value;
        int max = x.value;
        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            maxSubBSTHead = rightInfo.maxSubBSTHead;
            maxSubBSTSize = rightInfo.maxSubBSTSize;
        }

        if ((leftInfo == null ? true : leftInfo.maxSubBSTHead == x.left && leftInfo.max < x.value)
                && (rightInfo == null ? true : rightInfo.maxSubBSTHead == x.right && rightInfo.min > x.value)) {
            maxSubBSTHead = x;
            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize);
        }

        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
    }
}
