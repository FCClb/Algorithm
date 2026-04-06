package Class13;

public class Code01_IsCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node head) {
        return process(head).isCBT;
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int heigth;

        public Info(boolean isFull, boolean isCBT, int heigth) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.heigth = heigth;
        }
    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int heigth = Math.max(leftInfo.heigth, rightInfo.heigth) + 1;

        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.heigth == rightInfo.heigth;

        boolean isCBT = false;
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.heigth == rightInfo.heigth) {
            isCBT = true;
        } else if (leftInfo.isCBT && rightInfo.isFull && leftInfo.heigth == rightInfo.heigth + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isFull && leftInfo.heigth == rightInfo.heigth + 1) {
            isCBT = true;
        } else if (leftInfo.isFull && rightInfo.isCBT && leftInfo.heigth == rightInfo.heigth) {
            isCBT = true;
        }

        return new Info(isFull, isCBT, heigth);
    }
}
