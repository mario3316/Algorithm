import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {

	static int T, N, M;
	static int[][] MAP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = null;

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			MAP = new int[N][N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					MAP[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.printf("#%d %d\n", i, solve());
		}
	}

	public static int solve() {
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, sum(i, j));
			}
		}

		return max;
	}

	public static int sum(int r, int c) {
		int tot = 0;
		for (int i = r; i < r + M; i++) {
			for (int j = c; j < c + M; j++) {
				if (i < N && j < N) {
					tot += MAP[i][j];
				}
			}
		}
		return tot;
	}
}
