package Class05;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/18 - 01 - 18 - 10:13
 * @Description: Class05
 * @version: 1.0
 */
public class Code01_CountOfRangeSum {
    /*
    给定一arr 和 两个int lower 和 upper
    要求返回arr中有多少个子数组的累加和再[lower,upper]的范围上
    */

    public static int countRangeSum(int[] arr, int lower, int upper) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return process(sum, 0, arr.length - 1, lower, upper);
    }

    public static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {//base case
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }

        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper)
                + process(sum, M + 1, R, lower, upper)
                + merge(sum, L, M, R, lower, upper);
    }

    public static int merge(long[] sum, int L, int M, int R, int lower, int upper) {
        //计算有多少个符合要求的子数组
        int ans = 0;
        int windowL = L;
        int windowR = L;
        //[windowL,windowR)
        for (int i = M + 1; i <= R; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (windowL <= M && sum[windowL] < min) {
                windowL++;
            }
            while (windowR <= M && sum[windowR] <= max) {
                windowR++;
            }
            ans += windowR - windowL;
        }
        //正常的merge过程
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = sum[p1] <= sum[p2] ? sum[p1++] : sum[p2++];
        }
        while (p1 <= M) {
            help[i++] = sum[p1++];
        }
        while (p2 <= R) {
            help[i++] = sum[p2++];
        }
        for (i = 0; i < sum.length; i++) {
            sum[L + i] = help[i];
        }

        return ans;
    }
}
