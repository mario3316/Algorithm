import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {

	static int T;
	static int N;
	static int[][] MAP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			MAP = new int[N][N];

			for (int j = 0; j < N; j++) {
				String[] arr = br.readLine().split("");
				for (int k = 0; k < N; k++) {
					MAP[j][k] = Integer.parseInt(arr[k]);
				}
			}

			System.out.printf("#%d %d\n", i, solve());
		}
	}

	public static int solve() {
		int cnt = 0;
		int idx = 0;
		int center = N / 2;

		for (int i = 0; i < center; i++) {
			for (int j = center - idx; j <= center + idx; j++) {
				cnt += MAP[i][j];
			}
			idx++;
		}
		idx--;

		for (int i = 0; i < N; i++) {
			cnt += MAP[center][i];
		}

		for (int i = center + 1; i < N; i++) {
			for (int j = center - idx; j <= center + idx; j++) {
				cnt += MAP[i][j];
			}
			idx--;
		}

		return cnt;
	}

}
