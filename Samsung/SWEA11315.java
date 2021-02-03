import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA11315 {

	static int T, N;
	static char[][] MAP;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine());
			MAP = new char[N][N];

			for (int j = 0; j < N; j++) {
				MAP[j] = br.readLine().toCharArray();
			}

			if (solve()) {
				System.out.printf("#%d YES\n", i);
			} else
				System.out.printf("#%d NO\n", i);
		}
	}

	public static boolean solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 'o') {
					for (int k = 0; k < 8; k++) {
						if (DFS(i, j, k, 1)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean DFS(int r, int c, int dir, int cnt) {
		if (cnt == 5) {
			return true;
		} else {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (isIn(nr, nc) && MAP[nr][nc] == 'o') {
				if (DFS(nr, nc, dir, cnt + 1))
					return true;
				else
					return false;
			} else
				return false;
		}
	}

	public static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		else
			return false;
	}

}
