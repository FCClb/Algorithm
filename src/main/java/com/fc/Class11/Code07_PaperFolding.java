package Class11;

public class Code07_PaperFolding {
    public static void printAllFolds(int N) {
        process(1, N, true);
    }

    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.print(down ? "凹 " : "凸 ");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
