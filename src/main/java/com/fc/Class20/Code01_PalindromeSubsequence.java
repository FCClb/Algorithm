package com.fc.Class20;

public class Code01_PalindromeSubsequence {

    public static int lpsl1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        //尝试
        return f(str, 0, str.length - 1);
    }

    // 返回 str[L...R] 最长回文子序列长度
    public static int f(char[] str, int L, int R) {
        if (L == R) {//剩一个字符
            return 1;
        }
        if (L == R - 1) {//剩两个字符
            return str[L] == str[R] ? 2 : 1;
        }

        //最长回文子序列既不以 str[L] 开头，也不以 str[R] 结尾
        int p1 = f(str, L + 1, R - 1);
        //可能以 str[L] 开头
        int p2 = f(str, L, R - 1);
        //可能以 str[R] 结尾
        int p3 = f(str, L + 1, R);

        //可能以 str[L] 开头,可能以 str[R] 结尾
        int p4 = str[L] == str[R] ? (2 + f(str, L + 1, R - 1)) : 0;

        return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
    }


    //优化
    public static int lpsl2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];

        dp[N-1][N-1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }

        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {

                int p1 = dp[L + 1][R - 1];
                int p2 = dp[L][R - 1];
                int p3 = dp[L + 1][R];
                int p4 = str[L] == str[R] ? (2 + dp[L + 1][R - 1]) : 0;

                dp[L][R] = Math.max(p1, Math.max(p2, Math.max(p3, p4)));
            }
        }

        return dp[0][N - 1];
    }

    //优化
    public static int lpsl3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];

        dp[N-1][N-1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }

        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {

//                int p1 = dp[L + 1][R - 1];
//                int p2 = dp[L][R - 1];
//                int p3 = dp[L + 1][R];
//                int p4 = str[L] == str[R] ? (2 + dp[L + 1][R - 1]) : 0;

                dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                if (str[L] == str[R]) {
                    dp[L][R] = Math.max(dp[L][R], dp[L + 1][R - 1] + 2);
                }

//                dp[L][R] = Math.max(p1, Math.max(p2, Math.max(p3, p4)));

            }
        }

        return dp[0][N - 1];
    }


}
