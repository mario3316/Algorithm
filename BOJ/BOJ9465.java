import java.util.Scanner;

public class BOJ9465 {

	static int T, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			int[][] arr = new int[N][2];
			int[][] dp = new int[N][3];

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				arr[i][1] = sc.nextInt();
			}

			dp[0][0] = arr[0][0];
			dp[0][1] = arr[0][1];
			dp[0][2] = 0;
			dp[1][0] = dp[0][1] + arr[1][0];

			for (int i = 1; i < N; i++) {
				dp[i][0] = dp[i - 1][1] + arr[i][0];
				dp[i][1] = dp[i - 1][0] + arr[i][1];
			}

			for (int i = 0; i < N; i++) {
				System.out.print(dp[i][0] + " ");
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				System.out.print(dp[i][1] + " ");
			}

			System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
		}

	}

}
