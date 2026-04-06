package Class04;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/17 - 01 - 17 - 11:59
 * @Description: Class04
 * @version: 1.0
 */
public class Code04_BiggerThanRightTwice {
    /*
    求num右边有多少个数*2后仍<num
    */
    public static int BiggerThanRightTwice(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return
                process(arr, L, mid)
                +
                process(arr, mid + 1, R)
                +
                merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int ans = 0;
        int windowR = M + 1;//囊括进来的数为[M+1,windowR)
        for (int i = L; i <= M; i++) {
            while (windowR <= R && (long) arr[i] > (long) arr[windowR] * 2) {
                windowR++;
            }
            ans += windowR - M - 1;
        }

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }

        return ans;
    }

    //for test
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 3, 2};
        System.out.println(test(arr));
        System.out.println(BiggerThanRightTwice(arr));

    }

    public static int test(int[] arr) {//暴力解法(只求个数，不排序)
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
