package Class08;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/7 - 02 - 07 - 11:02
 * @Description: Class08
 * @version: 1.0
 */
public class Code03_CountSort {
    /*
    计数排序
    */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
