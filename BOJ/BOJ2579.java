import java.util.Scanner;

public class BOJ2579 {

    static int N;
    static int[] score;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        score = new int[N + 1];
        dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            score[i] = sc.nextInt();
        }

        dp[1][0] = score[1];
        dp[1][1] = score[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] + score[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

}
