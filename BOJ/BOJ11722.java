import java.util.Scanner;

public class BOJ11722 {

    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++)
            dp[i] = 1;

        int LIS = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    LIS = Math.max(LIS, dp[i]);
                }
            }
        }

        System.out.println(LIS);
    }

}
