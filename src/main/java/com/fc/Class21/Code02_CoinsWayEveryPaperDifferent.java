package com.fc.Class21;

public class Code02_CoinsWayEveryPaperDifferent {
    /**
     * 给定一个货币数组arr，其中的值都是正数。再给定一个正数aim，
     * 要求返回组成aim的方法数。
     * 注意：即使是值相同的货币也认为每一张是不同的
     * eg：arr = {1,1,1}, aim = 2
     * 第0个和第1个能组成2，第1个和第2个也能组成2，第0个和第2个也能组成2，
     * 最终返回方法数3
     */

    public static int coinWays(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    /**
     *  递归尝试版本
     * @param arr 货币数组
     * @param index 当前做选择的位置
     * @param rest  还剩下多少钱需要组
     * @return  arr[index....] 组成正好rest这么多的钱，有几种方法
     */
    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) { //没组成rest(超过了)
            return 0;
        }

        if (index == arr.length) { //没钱可用了
            return rest == 0 ? 1 : 0;
        } else {
            //要index这张钱
            int p1 = process(arr, index + 1, rest - arr[index]);
            //不要index这张钱
            int p2 = process(arr, index + 1, rest);

            return p1 + p2;
        }
    }

    //动态规划版本
    public static int dp(int[] arr, int aim) {
        if (aim == 0) { //边界
            return 1;
        }

        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];   //行为0~index，列为0~aim

        dp[N][0] = 1;   //index为N时，aim为0填1，其余默认为0
        //从下往上填表
        for (int index = N - 1; index >= 0; index--) {  //从倒数第二行开始
            for (int rest = 0; rest <= aim; rest++) {
                //要index这张钱
                //观察递归版本，rest<0时要返回0
                int p1 = rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : 0;
                //不要index这张钱
                int p2 = dp[index + 1][rest];

                dp[index][rest] = p1 + p2;
            }

        }

        return dp[0][aim];
    }

    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 为了测试
    public static void main(String[] args) {
        int maxLen = 20;
        int maxValue = 30;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = coinWays(arr, aim);
            int ans2 = dp(arr, aim);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("测试结束");
    }


}
