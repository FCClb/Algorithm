package com.fc.Class21;

public class Code01_MinPathSum {
    /**
     * 最小路径和问题
     * 给定给定一个包含非负整数的二维数组
     * 请找出一条从左上角 (0,0) 到右下角 (m-1,n-1) 的路径，使得路径上的数字总和为最小
     */

    //递归尝试
    public static int minPathSum1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        return process(matrix, 0, 0);
    }

    private static int process(int[][] matrix, int row, int col) {
        int m = matrix.length;  //行数
        int n = matrix[0].length;   //列数

        // 1. 终止条件：到达右下角，返回当前格子的值
        if (row == m - 1 && col == n - 1) {
            return matrix[row][col];
        }

        // 2. 越界判断：行/列超出网格范围，返回极大值（无效路径）
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        // 3. 递归计算：向右走 和 向下走 的最小路径和，取较小值 + 当前格子值
        //选择向右走
        int right = process(matrix, row, col + 1);

        //选择向下走
        int down = process(matrix, row + 1, col);

        return matrix[row][col] + Math.min(right, down);
    }

    //动态规划版本
    public static int minPathSum2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        return dp[row - 1][col - 1];

    }

    //动态规划版本 -- 空间优化版
    public static int minPathSum3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];

        dp[0] = matrix[0][0];

        for (int i = 1; i < col; i++) {
            dp[i] = dp[i - 1] + matrix[0][i];
        }

        for (int i = 1; i < row; i++) {
            dp[0] += matrix[i][0];
            for (int j = 1; j < col; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
            }
        }

        return dp[col - 1];

    }


    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 100);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rowSize = 10;
        int colSize = 10;
        int[][] m = generateRandomMatrix(rowSize, colSize);
        System.out.println(minPathSum1(m));
        System.out.println(minPathSum2(m));
        System.out.println(minPathSum3(m));

    }
}
