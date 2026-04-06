package com.fc.Class19;

import java.util.HashMap;

public class Code03_StickersToSpellWord {

    public static int minStickers1(String[] stickers, String target) {
        int ans = process1(stickers, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     *所有贴纸stickers，每一种贴纸都有无穷张
     * @param stickers
     * @param target
     * @return 最少张数
     */
    public static int process1(String[] stickers, String target) {
        if (target.length() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String first : stickers) {
            String rest = minus(target, first);
            if (rest.length() != target.length()) {
                min = Math.min(min, process1(stickers, rest));
            }
        }

        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    private static String minus(String target, String first) {
        char[] str1 = target.toCharArray();
        char[] str2 = first.toCharArray();
        int[] count = new int[26];

        for (char c : str1) {
            count[c - 'a']++;
        }
        for (char c : str2) {
            count[c - 'a']--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    builder.append((char) ('a' + i));
                }
            }
        }

        return builder.toString();
    }



    public static int minStickers2(String[] stickers, String target) {
        int N = stickers.length;
        //用词频代替贴纸
        int[][] counts = new int[N][26];
        for (int i = 0; i < N; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                counts[i][c - 'a']++;
            }
        }
        int ans = process2(counts, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process2(int[][] stickers, String t) {
        if (t.length() == 0) {
            return 0;
        }

        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char c : target) {
            tcounts[c - 'a']++;
        }

        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            //第一张贴纸
            int[] sticker = stickers[i];
            //剪枝优化
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) ('a' + j));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }

    /**
     * 加入缓存
     *
     * @param stickers
     * @param t
     * @return
     */
    public static int process3(int[][] stickers, String t, HashMap<String, Integer> dp) {
        if (dp.containsKey(t)) {
            return dp.get(t);
        }

        if (t.length() == 0) {
            return 0;
        }

        char[] target = t.toCharArray();
        int[] tcounts = new int[26];
        for (char c : target) {
            tcounts[c - 'a']++;
        }

        int N = stickers.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            //第一张贴纸
            int[] sticker = stickers[i];
            //剪枝优化
            if (sticker[target[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (tcounts[j] > 0) {
                        int nums = tcounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) ('a' + j));
                        }
                    }
                }
                String rest = builder.toString();
                min = Math.min(min, process2(stickers, rest));
            }
        }

        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(t, ans);
        return ans;
    }


}
