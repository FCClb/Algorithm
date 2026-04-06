package Class06;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/25 - 01 - 25 - 11:07
 * @Description: Class06
 * @version: 1.0
 */
public class Code04_SortArrayDistanceLessK {
    /*一个Arr几乎有序，即若排好序，每个元素移动的距离不超K，K是一个给定参数
     * 要求选择合适的排序策略，对数组排序
     */
    public static void sortedArrDistanceLessK(int[] arr, int K) {
        if (K == 0) {
            return;
        }
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (index = 0; index <= Math.min(arr.length - 1, K - 1); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    //for test
    public static void comparator(int[] arr, int K) {
        Arrays.sort(arr);
    }

    //for test
    public static int[] randomArrayNoMoveMoreK(int maxSize, int maxValue, int K) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        Arrays.sort(arr);
        //随意交换，但保证每个数移动距离不超过K
        //swap[i] == true ，表示i位置已经参与过交换
        //swap[i] == false ，表示i位置没有参与过交换
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int) (Math.random() * (K + 1)), arr.length - 1);
            if (!isSwap[i] && !isSwap[j]) {
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }

    //for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null) && (arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //for test
    public static void main(String[] args) {
        System.out.println("test begin");
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int K = (int) (Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize, maxValue, K);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            sortedArrDistanceLessK(arr1, K);
            comparator(arr2, K);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println("K:" + K);
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "test finish" : "Wrong!");
    }
}
