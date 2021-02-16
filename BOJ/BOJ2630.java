import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	static int N;
	static int[][] MAP;
	static int white = 0, blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	static void solve(int r, int c, int len) {
		if (isSame(r, c, len)) {
			if (MAP[r][c] == 0)
				white++;
			else
				blue++;
			return;
		} else {
			int new_len = len / 2;
			solve(r, c, new_len);
			solve(r, c + new_len, new_len);
			solve(r + new_len, c, new_len);
			solve(r + new_len, c + new_len, new_len);
		}
	}

	static boolean isSame(int r, int c, int len) {
		int temp = MAP[r][c];

		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (MAP[i][j] != temp)
					return false;
			}
		}

		return true;
	}

}
