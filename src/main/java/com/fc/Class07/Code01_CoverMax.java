package Class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Auther: FC.Clb
 * @Date: 2025/2/1 - 02 - 01 - 11:29
 * @Description: Class07
 * @version: 1.0
 */
public class Code01_CoverMax {
    /*
    求最大线段重合数
    */
    public static int maxCover1(int[][] lines) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[i][1]);
        }
        int cover = 0;
        for (double p = min + 0.5; p < max; p += 1) {
            int cur = 0;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i][0] < p && lines[i][1] > p) {
                    cur++;
                }
            }
            cover = Math.max(cover, cur);
        }
        return cover;
    }

    public static int maxCover2(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines, new StartComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class Line{
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class StartComparator implements Comparator<Line> {
        @Override
        public int compare(Line l1, Line l2) {
            return l1.start - l2.start;
        }
    }

}
