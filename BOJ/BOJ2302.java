import java.util.Scanner;

public class BOJ2302 {

    static int N, M;
    static int[] fix;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        dp = new int[N + 1];
        fix = new int[M];

        for (int i = 0; i < M; i++)
            fix[i] = sc.nextInt();

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {

            if (isIn(i) || isIn(i - 1)) { // 현재 좌석이나 이전 좌석이 vip 석일때는 바뀌는 것이 없음
                dp[i] = dp[i - 1];
            } else { // 그게 아니면 피보나치
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        System.out.println(dp[N]);
    }

    static boolean isIn(int n) {
        for (int i = 0; i < M; i++) {
            if (n == fix[i])
                return true;
        }
        return false;
    }

}
