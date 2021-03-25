import java.util.Scanner;

public class SWEA3307 {

    static int T, N;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N];
            dp = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = LIS();
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    static int LIS() {
        int max = 0;

        for (int i = 0; i < N; i++)
            dp[i] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
