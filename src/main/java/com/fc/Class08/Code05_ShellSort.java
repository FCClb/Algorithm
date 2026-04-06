package Class08;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/9 - 02 - 09 - 8:26
 * @Description: Class08
 * @version: 1.0
 */
public class Code05_ShellSort {
    /*希尔排序*/
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] step = {5, 2, 1};
        for (int s = 0; s < step.length; s++) {
            for (int i = step[s]; i < arr.length; i++) {
                for (int j = i - step[s]; j >= 0 && arr[j] > arr[j + step[s]]; j -= step[s]) {
                    swap(arr, j, j + step[s]);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
