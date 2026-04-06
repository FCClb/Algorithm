package Class06;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/22 - 01 - 22 - 11:44
 * @Description: Class06
 * @version: 1.0
 */
public class Code02_Heap {
    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        /*增加元素，并且保持堆的结构*/
        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        /*弹出最大值即堆顶，并且保持堆的结构*/
        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        /*上移*/
        private void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        /*下沉*/
        private void heapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        MyMaxHeap myMaxHeap = new MyMaxHeap(10);
        myMaxHeap.push(7);
        myMaxHeap.push(3);
        myMaxHeap.push(1);
        myMaxHeap.push(6);
        myMaxHeap.push(8);
        myMaxHeap.push(10);
        myMaxHeap.push(0);

        while (!myMaxHeap.isEmpty()) {
            System.out.println(myMaxHeap.pop());
        }
    }
}
